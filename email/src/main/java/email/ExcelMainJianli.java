package email;

import java.util.Calendar;
/**
 * 发送高院监理周报入口类
 * @author Hasee
 *
 */
public class ExcelMainJianli {
	public static void main(String[] args) {
		try {
			String tdMsg = MailLastRelease.updateMsg_br;
			//邮件正文table表格内容
			String emailContent_jianli = "<table width=\"100%\" border=\"1\" cellpadding=\"1\"><tr align=\"center\"><td>单位名称</td><td>服务事项</td><td>办理结果</td>\r\n" + 
					"<td>人员请销假情况</td><td>备注</td></tr><tr><td align=\"center\">科大讯飞</td><td align=\"center\">1、智能庭审系统；<br>\r\n" + 
					"2、智能语音助手；<br>3、智能会议系统；<br>4、智能编目系统；</td><td>" + tdMsg + "</td><td></td><td></td></tr></table>";
			Calendar rightNow = Calendar.getInstance();
			Integer year = rightNow.get(Calendar.YEAR);
			Integer month = rightNow.get(Calendar.MONTH) + 1;
			Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
			// 2个附件路径
			String filePath2_jianli = "C:\\Users\\Hasee\\Desktop\\WeekReports\\科大讯飞_运维周报_" + year + "年" + month + "月"
					+ day + "日" + ".xlsx";
			String filePath3_jianli = "C:\\Users\\Hasee\\Desktop\\WeekReports\\安徽庭审问题记录表_" + year + "年" + month + "月"
					+ day + "日" + ".xlsx";
			//获取文件名作为邮件主题
			String subject_Jianli = SendEmailUtils.getFileName(filePath2_jianli);
			//发送人、抄送人
			String toEmail_Jianli = "326907896@qq.com,1785737353@qq.com";
			String toEmail_Copy = "sszhang@iflytek.com";
//			String toEmail_Jianli = "yuzhiwang1024@163.com";
//			String toEmail_Copy = "839249940@qq.com";
			boolean isSended = new SendEmailUtils().sendMail(subject_Jianli, emailContent_jianli, filePath2_jianli, filePath3_jianli, toEmail_Jianli, toEmail_Copy);
			System.out.println(isSended);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
