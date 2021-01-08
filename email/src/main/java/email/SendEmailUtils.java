package email;

import java.io.File;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendEmailUtils {
	//邮件发送者的邮箱和登陆密码
	public static String myEmailAccount = "leiwang61@iflytek.com";
	public static String myEmailPassword = "Ethink2018"; 
	//SMTP协议服务器
	public static String myEmailSMTPHost = "mail.iflytek.com";

	public static void main(String[] args) throws Exception {
		String tdMsg = MailLastRelease.updateMsg_br;
		//讯飞周报正文table
		String emailContent =  "<table width=\"100%\" border=\"1\" cellpadding=\"1\"><tr align=\"center\"><td colspan=\"5\">安徽大区交付运营中心工作周报</td>\r\n" + 
				"</tr><tr><td colspan=\"5\">本周工作完成情况</td></tr><tr align=\"center\"><td>序号</td><td>所属项目</td><td>工作内容</td>\r\n" + 
				"<td>完成情况</td><td>备注</td></tr><tr><td align=\"center\">1</td><td align=\"center\">2017-安徽高院（服务类）-智慧法院项目 D-180030001</td>\r\n" + 
				"<td>" + tdMsg + "</td><td>完成</td><td></td></tr><tr align=\"center\"><td>2</td><td>2017-安徽高院（采购类）-智慧法院项目</td><td></td><td></td><td></td>\r\n" + 
				"</tr><tr align=\"center\"><td>3</td><td>2020年度法院业务部安徽区域维保项目M类</td><td></td><td></td><td></td>\r\n" + 
				"</tr></table>";
		//高院监理周报table
//		String emailContent =   "<table width=\"100%\" border=\"1\" cellpadding=\"1\"><tr align=\"center\"><td>单位名称</td><td>服务事项</td><td>办理结果</td>\r\n" + 
//				"<td>人员请销假情况</td><td>备注</td></tr><tr><td align=\"center\">科大讯飞</td><td align=\"center\">1、智能庭审系统；<br>\r\n" + 
//				"2、智能语音助手；<br>3、智能会议系统；<br>4、智能编目系统；</td><td>" + tdMsg + "</td><td></td><td></td></tr></table>";
		Calendar rightNow = Calendar.getInstance();
		Integer year = rightNow.get(Calendar.YEAR);
		Integer month = rightNow.get(Calendar.MONTH) + 1;
		Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
		String filePath = "C:\\Users\\Hasee\\Desktop\\WeekReports\\王磊_运维周报_" + year + "年" + month + "月" + day + "日"
				+ ".xlsx";
		String subject = getFileName(filePath);
		String toEmail = "yuzhiwang1024@163.com";
		String toCopy = "839249940@qq.com"; 
		new SendEmailUtils().sendMail(subject, emailContent, filePath,"", toEmail, toCopy);
	}
	/**
	 * 发送邮件方法类
	 * @param subject 设置邮件主题
	 * @param emailContent 设置邮件正文
	 * @param filePath 附件1路径，不可为空
	 * @param filePath2 附件2路径，可为空，" "
	 * @param toEmailAddress 邮件接收人
	 * @param copyEmailAddress 邮件抄送人
	 * @return  true表示发送成功
	 */
	public boolean sendMail(String subject, String emailContent, String filePath,String filePath2, String toEmailAddress, String copyEmailAddress) {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");

		try {
			Session session = Session.getInstance(props);
			session.setDebug(true);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myEmailAccount));
			//邮件接收人的地址，逗号分隔
			InternetAddress[] toSend = InternetAddress.parse(toEmailAddress);
			message.addRecipients(Message.RecipientType.TO, toSend);
			//邮件抄送人的地址，逗号分隔
			InternetAddress[] toCopy = InternetAddress.parse(copyEmailAddress);
			message.addRecipients(Message.RecipientType.CC, toCopy);
			//邮件主题
			message.setSubject(subject);
			// 邮件主体
			BodyPart messageBodyPart = new MimeBodyPart();
			// 邮件正文
			messageBodyPart.setContent(emailContent, "text/html; charset=UTF-8");
			// 组合邮件主体
			Multipart multipart = new MimeMultipart();
			// 把邮件正文加入组合主体中
			multipart.addBodyPart(messageBodyPart);
			//根据抄送人不同，发送不同附件
			if(copyEmailAddress.equals("sszhang@iflytek.com")) {
				messageBodyPart = new MimeBodyPart();
				// 获取附件内容
				DataSource source1 = new FileDataSource(new File(filePath));
				messageBodyPart.setDataHandler(new DataHandler(source1));
				// 获取附件名称，注意编码转换避免名称乱码
				String filename1 = getFileName(filePath);
				messageBodyPart.setFileName(MimeUtility.encodeText(filename1));
				multipart.addBodyPart(messageBodyPart);
				
				//第二份附件
				messageBodyPart = new MimeBodyPart();
				DataSource source2 = new FileDataSource(new File(filePath2));
				messageBodyPart.setDataHandler(new DataHandler(source2));
				// 获取附件名称，注意编码转换避免名称乱码
				String filename2 = getFileName(filePath2);
				messageBodyPart.setFileName(MimeUtility.encodeText(filename2));
				multipart.addBodyPart(messageBodyPart);
				
			}else {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(new File(filePath));
				messageBodyPart.setDataHandler(new DataHandler(source));
				String filename = getFileName(filePath);
				messageBodyPart.setFileName(MimeUtility.encodeText(filename));
				multipart.addBodyPart(messageBodyPart);
			}
			
			// 将邮件主体放入消息中，待发送
			message.setContent(multipart);
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport();
			transport.connect(myEmailAccount, myEmailPassword);
			//getAllRecipients获取所有接收人和抄送人
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

/**
 * 获取文件名称
 * @param filePath 路径
 * @return
 */
	public static String getFileName(String filePath) {
		try {
			File tempFile = new File(filePath);
			String fileName = tempFile.getName();
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "无法获取文件名";
	}

}
