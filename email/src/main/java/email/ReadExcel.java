package email;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 读取问题记录表.xlsx中内容并判断取舍，写入新excel
 * @author Hasee
 *
 */
public class ReadExcel {
	public String getExcelMsg() throws Exception {
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\Hasee\\Desktop\\安徽庭审问题记录表.xlsx"));
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(2);
			String msg = cell.getStringCellValue();
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			return "无法获取单元格内容";
		} finally {
			wb.close();
		}

	}

	public static void main(String[] args) {
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		//创建要写入的新excel
		XSSFWorkbook wb2Excel = new XSSFWorkbook();
		XSSFSheet sheet2Excel = null;
		XSSFRow row2Excel = null;
		try {
			wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\Hasee\\Desktop\\WeekReports\\安徽庭审问题记录表.xlsx"));
			sheet = wb.getSheetAt(0);
//			XSSFRow row = sheet.getRow(1);
//			XSSFCell cell = row.getCell(2);
//			String msg = cell.getStringCellValue();
//			System.out.println(msg);
			//获取源文件标题行
			XSSFRow titleRow = sheet.getRow(0);
			//新文件创建第一行，等待写入
			sheet2Excel = wb2Excel.createSheet();
			row2Excel = sheet2Excel.createRow(0);
			for (int cellIndex = 0; cellIndex < titleRow.getPhysicalNumberOfCells(); cellIndex++) {
				cell = titleRow.getCell(cellIndex);
				System.out.println(cell.getStringCellValue());
				//同时写入标题行
				row2Excel.createCell(cellIndex).setCellValue(cell.getStringCellValue());
			}
			// 获取第二个标题行
			titleRow = sheet.getRow(1);
			row2Excel = sheet2Excel.createRow(1);
			for (int cellIndex = 0; cellIndex < titleRow.getPhysicalNumberOfCells(); cellIndex++) {
				cell = titleRow.getCell(cellIndex);
				System.out.println(cell.getStringCellValue());
				// 同时写入第二个标题行
				row2Excel.createCell(cellIndex).setCellValue(cell.getStringCellValue());
			}
			//从源文件第三行开始，读取excel正文并写入
			int index = 2;
			for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				try {
					row = sheet.getRow(rowIndex);
					cell = row.getCell(3);
					// System.out.print(cell.getStringCellValue());
//					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					Date date = format.parse(date);
					Long date2time;
					date2time = cell.getDateCellValue().getTime();
//					String dateBegin_str = "2020-1-9 00:00:00";
//					String dateEnd_str = "2020-1-11 00:00:00";
					// 获取系统日期，用于排除历史数据，只处理本周内数据
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					//获取本周日期始末
					String intervalStr = DateUtils.getWeekInterval(sdf.format(date), "");
					//System.out.println(intervalStr);
					String[] interval = intervalStr.split(",");
					String dateBegin_str = interval[0];
					String dateEnd_str = interval[1];
					Date dateBegin = sdf.parse(dateBegin_str);
					Date dateEnd = sdf.parse(dateEnd_str);
					Long dateBegin2time = dateBegin.getTime();
					Long dateEnd2time = dateEnd.getTime();
					//System.out.println(date2time >= dateBegin2time && date2time <= dateEnd2time);
					if (date2time >= dateBegin2time && date2time <= dateEnd2time) {
						row2Excel = sheet2Excel.createRow(index);
						for (int cellIndex = 0; cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
//							System.out.println(row.getCell(0).getDateCellValue());
//							System.out.println(row.getCell(1).getNumericCellValue());
							cell = row.getCell(cellIndex);
							//cell.setCellType(CellType.STRING);
							//第三单元格和第九单元格日期数据需要转换一下再写入
							if (cellIndex == 3 || cellIndex == 9) {
								row2Excel.createCell(cellIndex).setCellValue(sdf.format(cell.getDateCellValue()));
								//System.out.println(cellIndex);
							} else {
								row2Excel.createCell(cellIndex).setCellValue(cell.getStringCellValue());
							}
						}

						index++;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Calendar rightNow = Calendar.getInstance();
			Integer year = rightNow.get(Calendar.YEAR);
			Integer month = rightNow.get(Calendar.MONTH) + 1;
			Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
			FileOutputStream out = new FileOutputStream("C:\\Users\\Hasee\\Desktop\\WeekReports\\安徽庭审问题记录表_" + year
					+ "年" + month + "月" + day + "日" + ".xlsx");
			// 合并单元格，第0行开始，第0行结束，第0列开始，第9列结束
			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 9);
			sheet2Excel.addMergedRegion(region);

			wb2Excel.write(out);
			wb.close();
			wb2Excel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
