package email;

import java.util.Calendar;
/**
 * 发送讯飞周报入口类
 * @author Hasee
 *
 */
public class ExcelMainIflytek {
	public static void main(String[] args) {
		try {
			//获取<br>后缀的更新信息
			String tdMsg = MailLastRelease.updateMsg_br;
			//邮件正文显示table结构
			String emailContent_iflytek = "<table width=\"100%\" border=\"1\" cellpadding=\"1\"><tr align=\"center\"><td colspan=\"5\">安徽大区交付运营中心工作周报</td>\r\n" + 
					"</tr><tr><td colspan=\"5\">本周工作完成情况</td></tr><tr align=\"center\"><td>序号</td><td>所属项目</td><td>工作内容</td>\r\n" + 
					"<td>完成情况</td><td>备注</td></tr><tr><td align=\"center\">1</td><td align=\"center\">2017-安徽高院（服务类）-智慧法院项目 D-180030001</td>\r\n" + 
					"<td>" + tdMsg + "</td><td>完成</td><td></td></tr><tr align=\"center\"><td>2</td><td>2017-安徽高院（采购类）-智慧法院项目</td><td></td><td></td><td></td>\r\n" + 
					"</tr><tr align=\"center\"><td>3</td><td>2020年度法院业务部安徽区域维保项目M类</td><td></td><td></td><td></td>\r\n" + 
					"</tr></table>";
			Calendar rightNow = Calendar.getInstance();
			Integer year = rightNow.get(Calendar.YEAR);
			Integer month = rightNow.get(Calendar.MONTH) + 1;
			Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
			//附件路径
			String filePath_iflytek = "C:\\Users\\Hasee\\Desktop\\WeekReports\\王磊_运维周报_" + year + "年" + month + "月" + day + "日"
					+ ".xlsx";
			//获取文件名称用于邮件主题
			String subject_iflytek = SendEmailUtils.getFileName(filePath_iflytek);
			//发送人和抄送人
			String toEmail_iflytek = "yongzhang28@iflytek.com,sszhang@iflytek.com,szwu@iflytek.com";
			String toCopy_iflytek = "ah_area_zfbg@iflytek.com";
//			String toEmail_iflytek = "839249940@qq.com";
//			String toCopy_iflytek = "yuzhiwang1024@163.com";
			boolean isSended = new SendEmailUtils().sendMail(subject_iflytek, emailContent_iflytek, filePath_iflytek, "", toEmail_iflytek, toCopy_iflytek);
			System.out.println(isSended);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
