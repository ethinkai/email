package email;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 更新excel
 * @author Hasee
 *
 */
public class UpdateExcel {
	public static String updateMsg_br = MailLastRelease.updateMsg_br;
	public static String updateMsg_nr = MailLastRelease.updateMsg_nr;
	//2021-3-22修改监理日报格式，添加备注
	public static String updateMsg_nr_beizhu = MailLastRelease.updateMsg_nr_beizhu;
	
	public static void main(String[] args) throws Exception, IOException {
		//获取当前日期
		Calendar rightNow = Calendar.getInstance();
		Integer year = rightNow.get(Calendar.YEAR);
		Integer month = rightNow.get(Calendar.MONTH)+1;//从0开始，+1
		Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
		
		String fileInput1="C:\\Users\\Hasee\\Desktop\\WeekReports\\王磊_运维周报.xlsx";
		String fileOutput1="C:\\Users\\Hasee\\Desktop\\WeekReports\\王磊_运维周报_"+year+"年"+month+"月"+day+"日"+".xlsx";
		int row1 = 3;
		int cell1 = 2;
		String fileInput2="C:\\Users\\Hasee\\Desktop\\WeekReports\\科大讯飞_运维周报.xlsx";
		String fileOutput2="C:\\Users\\Hasee\\Desktop\\WeekReports\\科大讯飞_运维周报_"+year+"年"+month+"月"+day+"日"+".xlsx";
		int row2 = 1;
		int cell2 = 2;
		new UpdateExcel().update(fileInput1, row1, cell1, fileOutput1, updateMsg_nr);
		new UpdateExcel().update(fileInput2, row2, cell2, fileOutput2, updateMsg_nr);
		//2021-3-22修改监理日报格式，添加备注
		int row3 = 1;
		int cell3 = 4;
		new UpdateExcel().update(fileInput2, row3, cell3, fileOutput2, updateMsg_nr_beizhu);
	}
	
	
	public void update(String fileInputPath, int rowNum, int cellNum, String fileOutputPath, String updateMsg ) throws Exception, IOException {
		XSSFWorkbook wb = null;
		wb = new XSSFWorkbook(new FileInputStream(fileInputPath));
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		//System.out.println(cell.getStringCellValue());
		//cell.setCellValue("1111122222");
		//String updateMsg = new readExcel().getExcelMsg();
		cell.setCellValue(updateMsg);
		FileOutputStream out = new FileOutputStream(fileOutputPath);
		wb.write(out);
		wb.close();
	}

}
