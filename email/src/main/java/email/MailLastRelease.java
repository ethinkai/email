package email;
/**
 * 发送邮件主类入口，注意updateMsg_br为邮件正文table内容，后缀<br>;updateMsg_nr为Excel更新，后缀<br>
 * @author Hasee
 *
 */
public class MailLastRelease {
		public static String updateMsg_br =  "日常及重点工作：<br>" + 
				"1、滨湖高院二法庭安装WPS嵌入版客户端，避免与华夏客户端冲突；<br>" + 
				"2、芜湖鸠江区法院机房断电服务器重启；<br>" + 
				"3、祁门县第三法庭重装嵌入版客户端；<br>" + 
				"4、黄山休宁、滁州来安导出庭审数据；<br>" + 
				"5、铜陵电子质证大屏交付手册更新；<br>" + 
				"6、全省庭审数据导出；<br>" + 
				"7、宁国法院书记员电脑重装庭审客户端；<br>" + 
				"8、五里墩高院1308安装语音助手客户端；<br>" + 
				"9、整理高院项目运维报告材料<br>" + 
				"<br>" + 
				"汇总信息：<br>" + 
				"本周共接运维电话（5）个，微信运维群中共处理问题（7）个。<br>" + 
				"本周运维人员总共受理操作引导类服务6次（庭审系统安装5次、<br>" + 
				"编目系统问题0次，语音助手1次），数据查询需求9次，bug类0次。";

		public static String updateMsg_nr =  "日常及重点工作：\r\n" + 
				"1、滨湖高院二法庭安装WPS嵌入版客户端，避免与华夏客户端冲突；\r\n" + 
				"2、芜湖鸠江区法院机房断电服务器重启；\r\n" + 
				"3、祁门县第三法庭重装嵌入版客户端；\r\n" + 
				"4、黄山休宁、滁州来安导出庭审数据；\r\n" + 
				"5、铜陵电子质证大屏交付手册更新；\r\n" + 
				"6、全省庭审数据导出；\r\n" + 
				"7、宁国法院书记员电脑重装庭审客户端；\r\n" + 
				"8、五里墩高院1308安装语音助手客户端；\r\n" + 
				"9、整理高院项目运维报告材料\r\n" + 
				"\r\n" + 
				"汇总信息：\r\n" + 
				"本周共接运维电话（5）个，微信运维群中共处理问题（7）个。\r\n" + 
				"本周运维人员总共受理操作引导类服务6次（庭审系统安装5次、\r\n" + 
				"编目系统问题0次，语音助手1次），数据查询需求9次，bug类0次。";


	public static void main(String[] args) throws Exception {
		thread_Excel t1 = new thread_Excel();
		thread_Iflytek t2 = new thread_Iflytek();
		thread_Jianli t3 = new thread_Jianli();
		//顺序执行
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
	}

}
/**
 * 更新Excel线程
 * @author Hasee
 *
 */
class thread_Excel extends java.lang.Thread{
	public void run() {
		try {
			ExcelUpdateMain.main(null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 * 发送讯飞周报邮件线程
 * @author Hasee
 *
 */
class thread_Iflytek extends java.lang.Thread{
	public void run() {
		try {
			ExcelMainIflytek.main(null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 * 发送高院监理周报线程
 * @author Hasee
 *
 */
class thread_Jianli extends java.lang.Thread{
	public void run() {
		try {
			ExcelMainJianli.main(null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
