package email;
/**
 * 发送邮件主类入口，注意updateMsg_br为邮件正文table内容，后缀<br>;updateMsg_nr为Excel更新，后缀<br>
 * @author Hasee
 *
 */
public class MailLastRelease {
		public static String updateMsg_br =  "日常及重点工作：<br>" + 
				"1、涡阳法院庭审客户端WPS安装测试（４小时）<br>" + 
				"2、全椒法院5月份庭审数据导出、全省庭审本周数据导出整理（4小时）<br>" + 
				"3、含山法院三套庭审客户端安装，测试正常（3小时）<br>" + 
				"4、高院验收资料整理打印（4小时）<br>" + 
				"5、灵璧语音助手授权处理，启动授权机制（1小时）<br>" + 
				"6、铜陵学院庭审服务器断电重启（3小时）<br>" + 
				"7、怀宁第一法庭嵌入版丢失，排查故障，重装恢复（1小时）<br>" + 
				"8、霍邱法院反映编目丢失文件，排查编目系统，检查各服务，重启，故障未再现，跟进中（4小时）<br>" + 
				"10.休宁法院开庭无法转写，引擎授权到期，修改配置，重启，暂时切换到安庆县服务器，4小时<br>" + 
				"<br>" + 
				"汇总信息：<br>" + 
				"本周共接运维电话（1）个，微信运维群中共处理问题（4）个。<br>" + 
				"操作指导类3次，<br>" + 
				"系统故障类0次，<br>" + 
				"需求增加类0次，<br>" + 
				"数据查询类2次。";

		public static String updateMsg_nr =  "日常及重点工作：\r\n" + 
				"1、涡阳法院庭审客户端WPS安装测试（４小时）\r\n" + 
				"2、全椒法院5月份庭审数据导出、全省庭审本周数据导出整理（4小时）\r\n" + 
				"3、含山法院三套庭审客户端安装，测试正常（3小时）\r\n" + 
				"4、高院验收资料整理打印（4小时）\r\n" + 
				"5、灵璧语音助手授权处理，启动授权机制（1小时）\r\n" + 
				"6、铜陵学院庭审服务器断电重启（3小时）\r\n" + 
				"7、怀宁第一法庭嵌入版丢失，排查故障，重装恢复（1小时）\r\n" + 
				"8、霍邱法院反映编目丢失文件，排查编目系统，检查各服务，重启，故障未再现，跟进中（4小时）\r\n" + 
				"10.休宁法院开庭无法转写，引擎授权到期，修改配置，重启，暂时切换到安庆县服务器，4小时\r\n" + 
				"\r\n" + 
				"汇总信息：\r\n" + 
				"本周共接运维电话（1）个，微信运维群中共处理问题（4）个。\r\n" + 
				"操作指导类3次，\r\n" + 
				"系统故障类0次，\r\n" + 
				"需求增加类0次，\r\n" + 
				"数据查询类2次。";
		//2021-3-22修改监理日报格式，添加备注
		public static String updateMsg_br_beizhu = "1、故障现象：无；<br>" + 
				"故障原因：无；<br>" + 
				"处理：无；";
		public static String updateMsg_nr_beizhu = "1、故障现象：无；\r\n" + 
				"故障原因：无；\r\n" + 
				"处理：无；";


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
