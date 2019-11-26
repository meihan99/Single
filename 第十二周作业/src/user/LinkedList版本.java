package user;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import production.*;
public class TelcomUser implements User{
	private String phoneNumber;
	private String callTo;
	private LinkedList commucationRecords;
	public TelcomUser(String phoneNumber){
		this.phoneNumber=phoneNumber;
		this.commucationRecords=new LinkedList();
	}
	public void printDetails(){
		/*LinkedList版本*/
		Iterator it=commucationRecords.iterator();
		for(;it.hasNext();){
			String []recordField=((String)(it.next())).split(",");
			System.out.println("主叫:"+recordField[0]);
			System.out.println("被叫:"+recordField[3]);
			System.out.println("通话开始时间:"+new Date(Long.parseLong(recordField[1])));
			System.out.println("通话结束时间:"+new Date(Long.parseLong(recordField[2])));
			System.out.println("计费:"+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");
		}
	}
	public void generateCommucationRecord(){
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++){
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			callTo=this.getCallToPhoneNumber();
			this.commucationRecords.add(0,this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";");
		}
	}
	public String getCallToPhoneNumber(){
			return "1551515"+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10));
	}
	public String accountFee(long timeStart,long timeEnd){
		double feePerMinute=0.2;
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		return String.format("%.4f",feeTotal);
	}
}
