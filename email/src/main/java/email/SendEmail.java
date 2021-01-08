package email;


import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	//发送人账号密码
	public static String myEmailAccount="leiwang61@iflytek.com";
	public static String myEmailPassword="Ethink2018";
	
	//SMTP服务器ַ
	public static String myEmailSMTPHost="mail.iflytek.com";
	
	//接收人地址ַ
	public static String receiveEmailAccount="839249940@qq.com";
	
	public static void main(String[] args) throws Exception {
		//设置发送人SMTP服务器信息
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		//以下是连接SMTP服务器不同端口比如网易等
//		final String smtpPort="465";
//		props.setProperty("mail.smtp.port", smtpPort);
//		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.setProperty("mail.smtp.socketFactory.fallback", "false");
//		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		
		Session session = Session.getInstance(props);
		//Debug模式，能看到详细信息
		session.setDebug(true);
		
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveEmailAccount);
		
		Transport transport = session.getTransport();
		//连接SMTP服务器
		transport.connect(myEmailAccount, myEmailPassword);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		
		
		
		
	}
	/**
	 * 发送方法
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendMail, "发送人", "UTF-8"));
		//邮件接收人
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "接收人", "UTF-8"));
		//主题
		message.setSubject("Hello SMTP","UTF-8");
		//正文
		message.setContent("测试邮件","text/html;charset=UTF-8");
		//发送时间
		message.setSentDate(new Date());
		message.saveChanges();
		return message;
		
	}

}
