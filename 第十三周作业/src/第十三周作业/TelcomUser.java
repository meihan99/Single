package 第十三周作业;

import java.util.*;

public class TelcomUser {

	private String TelNum;
	private String callTo;
	private HashMap singleRecoed;
	private LinkedHashMap singleRecord;
	private TreeMap TreeMapCallToRecords;
	private TreeMap TreeSingleRecord;
	private ArrayList communicationRecords;

	public MapTelcomUser(String TelNum) {
		this.TelNum = TelNum;
		this.communicationRecords = new ArrayList();
		this.TreeMapCallToRecords = new TreeMap();
	}

	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			this.TreeSingleRecord = new TreeMap();
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToTelNum();
			this.TreeSingleRecord.put("主叫", this.TelNum);
			this.TreeSingleRecord.put("开始时间", new Date(timeStart));
			this.TreeSingleRecord.put("结束时间", new Date(timeEnd));
			this.TreeSingleRecord.put("被叫号码", this.callTo);
			this.TreeSingleRecord.put("计费", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(TreeSingleRecord);
			this.TreeMapCallToRecords.put(this.callTo, this.accountFee(timeStart, timeEnd));
		}
	}
	private String getCallToTelNum() {
		return "1380372000" + String
				.valueOf(new Random().nextInt(5))+ String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10));
	}
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.3f", feeTotal);
	}


	void printDetails() {

		Iterator it = this.communicationRecords.iterator();
		while (it.hasNext()) {
			System.out.println("----------通话记录分割线----------");
			this.TreeSingleRecord = ((TreeMap) it.next());
			Set entrySet = this.TreeSingleRecord.entrySet();
			Iterator itEntry = entrySet.iterator();
			while (itEntry.hasNext()) {
				Map.Entry entry = (Map.Entry) itEntry.next();
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}

		}

	}

	void printCallToDetails() {
		Iterator it = this.TreeMapCallToRecords.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}