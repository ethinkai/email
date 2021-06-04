package email;
/**
 * 发送邮件主类入口，注意updateMsg_br为邮件正文table内容，后缀<br>;updateMsg_nr为Excel更新，后缀<br>
 * @author Hasee
 *
 */
public class MailLastRelease {
		public static String updateMsg_br =  "日常及重点工作：<br>" + 
				"1、滨湖高院机房断电，重启庭审、电子质证、助手等服务，测试正常（4小时）<br>" + 
				"2、相山区法院第一法庭声卡硬件故障排查，跟换（1小时）<br>" + 
				"3、瑶海区法院助手重装、高院日常运维（3小时）<br>" + 
				"4、全省5月份庭审、助手、会议数据导出整理、宿州2020年全市各市区县庭审数据导出整理（5小时）<br>" + 
				"5、智能编目问题排查处理、安庆、黄山等法院语音助手故障排查处理（3小时）<br>" + 
				"6、编目系统故障，排查Nign服务死掉，重启Nginx恢复，另外，编目存在从通达海拉取文件丢失问题，找研发解决中（5小时）<br>" + 
				"7、滁州中院庭审无法上传文件，排查USP服务故障，重启解决（1小时）<br>" + 
				"8、芜湖弋江区法院庭审客户端开庭失败，排查存在临时文件问题，删掉重启恢复（2小时）<br>" + 
				"8、涡阳法院第七法庭升级WPS庭审、高院其他事务（１小时）<br>" + 
				"10、利辛法院重装庭审客户端、芜湖中院客户端故障排查、萧县法院更换新电脑重装客户端故障排查等（4小时）<br>" + 
				"11、编目系统故障处理，存在编目丢失图片、编目卡顿等问题，联系研发解决中（4小时）<br>" + 
				"12、芜湖经开区法院庭审无法开庭，排查网络、服务器，磁盘空间不足，activemq死掉，删除历史文件，释放空间，重启恢复（3小时）<br>" + 
				"13、合肥铁路法院第九法庭声卡硬件故障，无法联网，建议更换声卡（1小时）<br>" + 
				"15、芜湖中院第四法庭庭审客户端无故损坏，排查电脑环境，重装恢复（1小时）<br>" + 
				"16、导出本周全省庭审数据（2小时）<br>" + 
				"<br>" + 
				"汇总信息：<br>" + 
				"本周共接运维电话（7）个，微信运维群中共处理问题（10）个。<br>" + 
				"操作指导类10次，<br>" + 
				"系统故障类2次，<br>" + 
				"需求增加类0次，<br>" + 
				"数据查询类1次。";

		public static String updateMsg_nr =  "日常及重点工作：\r\n" + 
				"1、滨湖高院机房断电，重启庭审、电子质证、助手等服务，测试正常（4小时）\r\n" + 
				"2、相山区法院第一法庭声卡硬件故障排查，跟换（1小时）\r\n" + 
				"3、瑶海区法院助手重装、高院日常运维（3小时）\r\n" + 
				"4、全省5月份庭审、助手、会议数据导出整理、宿州2020年全市各市区县庭审数据导出整理（5小时）\r\n" + 
				"5、智能编目问题排查处理、安庆、黄山等法院语音助手故障排查处理（3小时）\r\n" + 
				"6、编目系统故障，排查Nign服务死掉，重启Nginx恢复，另外，编目存在从通达海拉取文件丢失问题，找研发解决中（5小时）\r\n" + 
				"7、滁州中院庭审无法上传文件，排查USP服务故障，重启解决（1小时）\r\n" + 
				"8、芜湖弋江区法院庭审客户端开庭失败，排查存在临时文件问题，删掉重启恢复（2小时）\r\n" + 
				"8、涡阳法院第七法庭升级WPS庭审、高院其他事务（１小时）\r\n" + 
				"10、利辛法院重装庭审客户端、芜湖中院客户端故障排查、萧县法院更换新电脑重装客户端故障排查等（4小时）\r\n" + 
				"11、编目系统故障处理，存在编目丢失图片、编目卡顿等问题，联系研发解决中（4小时）\r\n" + 
				"12、芜湖经开区法院庭审无法开庭，排查网络、服务器，磁盘空间不足，activemq死掉，删除历史文件，释放空间，重启恢复（3小时）\r\n" + 
				"13、合肥铁路法院第九法庭声卡硬件故障，无法联网，建议更换声卡（1小时）\r\n" + 
				"15、芜湖中院第四法庭庭审客户端无故损坏，排查电脑环境，重装恢复（1小时）\r\n" + 
				"16、导出本周全省庭审数据（2小时）\r\n" + 
				"\r\n" + 
				"汇总信息：\r\n" + 
				"本周共接运维电话（7）个，微信运维群中共处理问题（10）个。\r\n" + 
				"操作指导类10次，\r\n" + 
				"系统故障类2次，\r\n" + 
				"需求增加类0次，\r\n" + 
				"数据查询类1次。";
		//2021-3-22修改监理日报格式，添加备注
		public static String updateMsg_br_beizhu = "1、故障现象：高院庭审服务故障；<br>" + 
				"故障原因：高院机房断电；<br>" + 
				"处理：重启庭审、助手、电子质证等后台服务，测试正常；<br>"
				+ "2、故障现象：芜湖经开区法院无法正常开庭；<br>"
				+ "故障原因：后台服务器磁盘空间不足;<br>"
				+ "处理：释放空间后重启部分服务恢复;";
		public static String updateMsg_nr_beizhu = "1、故障现象：芜湖经开区法院无法正常开庭；\r\n" + 
				"故障原因：后台服务器磁盘空间不足；\r\n" + 
				"处理：释放空间后重启部分服务恢复；\r\n"
				+ "2、故障现象：高院庭审服务故障；\r\n"
				+ "故障原因：高院机房断电；\r\n"
				+ "处理：重启庭审、助手、电子质证等后台服务，测试正常；";


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
