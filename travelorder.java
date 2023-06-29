package exp05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class travelorder {
	private String num;
	private String date;
	int price=0;
	int counter=0;
	private List<adult> adults;
	private List<child> children;
	private List<oldman> oldmen;
	int getprice() {
		return price;
	}
	String getdate() {
		return date;
	}
	String getnum() {
		return num;
	}
	public travelorder() {
		adults=new ArrayList<>();
		children=new ArrayList<>();
		oldmen=new ArrayList<>();
	}
	public void addadult(adult a) {
		adults.add(a);
		price=price+2000;
	}
	public void addchild(child a) {
		children.add(a);
		price=price+a.getPrice();
	}
	public void addoldmen(oldman a) {
		oldmen.add(a);
		price=price+1000;
	}
	public void setnum(String a) {
		if(a.length()==11) {
			num=a;
		}
		else System.out.println("手机号码必须为11位");
	}
	public void setdate(String a) {
		date=a;
	}
	public void displayorder() {
		System.out.println("出发日期："+date);
		System.out.println("联系人电话号码："+num);
		System.out.println("详细信息：");
		System.out.println("姓名   年龄    金额    儿童是否占床");
		for(adult a:adults) {
			System.out.println(a.getName()+"   "+a.getAge()+"   "+a.getPrice());
		}
		for(oldman a:oldmen) {
			System.out.println(a.getName()+"   "+a.getAge()+"   "+a.getPrice());
		}
		for(child a:children) {
			System.out.println(a.getName()+"   "+a.getAge()+"   "+a.getPrice()+"   "+a.getbed());
		}
	}
	public void setinfo() {
		Scanner input=new Scanner(System.in);
		
		if(counter==0) {
			System.out.print("输入出行日期（如：20170501）");
			String date=input.next();
			System.out.print("输入联系人电话：");
			String phonenum=input.next();
			setnum(phonenum);
			setdate(date);
			counter++;
		}
		System.out.println("****添加出行信息****");
		String b="y";
		while(true) {
			System.out.print("1.成人 2.儿童（1.2m以下） 3.老人（65岁以上），请选择类别：");
			int choice=input.nextInt();
			if(choice==1) {
				adult a0=new adult();
				System.out.print("输入姓名：");
				String name=input.next();
				System.out.print("输入年龄：");
				int age=input.nextInt();
				System.out.println("姓名："+name+",年龄："+age+" 本次出行价格：2000元");
				a0.setAge(age);a0.setName(name);
				addadult(a0);
			}
			if(choice==2) {
				child c0=new child();
				System.out.print("输入姓名：");
				String name=input.next();
				c0.setName(name);
				System.out.print("输入年龄：");
				int age=input.nextInt();
				c0.setAge(age);
				System.out.print("是否占床：1.占床 2.不占床");
				int key=input.nextInt();
				if(key==1) {
					c0.setPrice(30);
				}
				System.out.println("姓名："+name+",年龄："+age+" 本次出行价格："+c0.getPrice()+"元");
				addchild(c0);
			}
			if(choice==3) {
				oldman o0=new oldman();
				System.out.print("输入姓名：");
				String name=input.next();
				o0.setName(name);
				System.out.print("输入年龄：");
				int age=input.nextInt();
				if(age>=65) {
					o0.setAge(age);
					System.out.println("姓名："+name+",年龄："+age+" 本次出行价格：1000元");
					addoldmen(o0);
				}
				else System.out.println("年龄不符合要求");
			}
			System.out.print("是否继续添加（Y/N)？");
			b=input.next();
			if(b.equals("N")||b.equals("n")) {
				System.out.println("****订单信息****");
				System.out.println("出行日期:"+getdate());
				System.out.println("联系人手机号:"+getnum());
				System.out.println("总价为:"+getprice());
				break;
			}
		}
		//input.close();
	}
	public void delpeo(String str) {
		for(adult a:adults) {
			if(str.equals(a.getName())) {
				price=price-2000;
				adults.remove(a);
			}
		}
		for(oldman a:oldmen) {
			if(str.equals(a.getName())) {
				price=price-1000;
				adults.remove(a);
			}
		}
		for(child a:children) {
			if(str.equals(a.getName())) {
				price=price-a.getPrice();
				adults.remove(a);
			}
		}
	}
}
