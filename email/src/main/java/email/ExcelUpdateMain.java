package email;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class ExcelUpdateMain {
	public static void main(String[] args) {
		Calendar rightNow = Calendar.getInstance();
		Integer year = rightNow.get(Calendar.YEAR);
		Integer month = rightNow.get(Calendar.MONTH) + 1;
		Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
		// 讯飞周报存储路径
		String filePath_iflytek = "C:\\Users\\Hasee\\Desktop\\WeekReports\\王磊_运维周报_"+year+"年"+month+"月"+day+"日"+".xlsx";
		// 监理周报存储路径
		String filePath2_jianli = "C:\\Users\\Hasee\\Desktop\\WeekReports\\科大讯飞_运维周报_"+year+"年"+month+"月"+day+"日"+".xlsx";
		String filePath3_jianli = "C:\\Users\\Hasee\\Desktop\\WeekReports\\安徽庭审问题记录表_" + year + "年" + month + "月" + day
				+ "日" + ".xlsx";
		try {
			//如果文件不存在才开始更新生成
			if(!new File(filePath_iflytek).exists() && !new File(filePath2_jianli).exists()) {
				UpdateExcel.main(null);
			}
			if(!new File(filePath3_jianli).exists()) {
				ReadExcel.main(null);
			}
			
		} catch (IOException e) {		
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
