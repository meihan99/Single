package yinhang;

 import java.util.Scanner;
 import user.*;
 import utility.*;

 public class YinHang
 {
 		int account;
 		private static User user;

 		public static void main(String[] args)
 		{
 			YinHang yinHang = new YinHang();
 			yinHang.login();
 			yinHang.operate();
 		}

 		// �����롢ȡ������ѯ
 		public void operate()
 		{
 			YinHang yinHang = new YinHang();
 			int n;
 			Scanner sc = new Scanner(System.in);
 			while (true)
 			{
 				System.out.println("��ѡ����Ҫ���еĲ�����");
 				System.out.println("1: ����\t 2:ȡ��\t 3:��ѯ\t0:�˳�");
 				n = sc.nextInt();
 				if(n==1||n==2)
 				{

 					int num=0;
 					try
 					{
 						System.out.println("���������Ĵ�ȡ������");
 						num=sc.nextInt();
 					}
 					catch(Exception e)
 					{
 						System.out.println("���������");
 						continue;
 					}


 					switch (n)
 					{
 						case 1:
 							yinHang.income(num);
 							break;
 						case 2:
 							yinHang.takeout(num);
 							break;
 						default:
 							break;
 					}
 				}
 				else if( n==3)
 				{
 					show();
 				}
 				else if( n== 0)
 				{
 					System.exit(0);
 				}
 				else
 				{
 					System.out.println("������0~3֮�������ѡ�����");
 				}
 			}
 		}
 		public void login()
 		{
 			Utility dt = Utility.getInstance();
 			Scanner sc = new Scanner(System.in);
 			while (true)
 			{
 				System.out.println("���������Ŀ��ţ�");
 				String cardID = sc.nextLine();
 				System.out.println("���������룺");
 				String cardpassword = sc.nextLine();
 				user = dt.getUser(cardID);
 //				System.out.println(user.getCardID());
 				if (dt.getUsers().containsKey(cardID) && user.getCardPassword().equals(cardpassword))
 				{
 					System.out.println("��½�ɹ�");// ��½�ɹ�
 					break;
 				}
 				else
 				{
 					System.out.println("������˺Ŵ������������룡");// ʧ��
 					continue;
 				}

 			}
 		}

 		public void income(int num)
 		{
 			account = user.getAccount() + num;
 			user.setAccount(account);
 			System.out.println("�ѳɹ����룬��������Ĳ�����");// ����ɹ�
 		}

 		public void takeout(int num)
 		{
 			if (user.getAccount() >= num)
 			{
 				account = user.getAccount() - num;

 				user.setAccount(account);
 				System.out.println("��ȡ��");// �ɹ�
 			}
 			else
 			{
 				System.out.println("�������㣺������ѡ�����Ĳ���");// ʧ��
 			}
 		}

 		public void show()
 		{
 			account = user.getAccount();
 			System.out.println("�������Ϊ" + account + "Ԫ");// ���
 		}
 }