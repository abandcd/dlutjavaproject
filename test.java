package exp05;//孙鹏
import java.util.*;



import java.io.*;

public class test {

	public static void main(String[] args) {
		System.out.println("********欢迎光临阳光旅游网********");
		System.out.println("1.添加出行订单 2.查看我的出行订单 3.修改订单信息 4.删除出行人 5.查看行程 6.退出系统");
		System.out.print("请选择（1~6）");
		travelorder order=new travelorder();
		String goalstr;
		Scanner input=new Scanner(System.in);
		int a=1;a=input.nextInt();
		while(a!=6) {
			switch(a) {
				case 1:
					order.setinfo();
					break;
				case 2:
					order.displayorder();
					break;
				case 3:
					System.out.print("输入新的出行日期：");
					goalstr=input.next();
					order.setdate(goalstr);
					System.out.print("输入新的联系号码：");
					goalstr=input.next();
					order.setnum(goalstr);
					break;
				case 4:
					System.out.print("输入想删除的人：");
					goalstr=input.next();
					order.delpeo(goalstr);
					break;
				case 5:
					String filename="trade.txt";
					try {
						FileReader fr=new FileReader(filename);
						BufferedReader br=new BufferedReader(fr);
						String line=br.readLine();
						while(line!=null) {
							System.out.println(line);
							line=br.readLine();
						}
						br.close();
						fr.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 6:
					
			}
			System.out.print("请选择（1~6）");
			a=input.nextInt();
		}
	}

}
