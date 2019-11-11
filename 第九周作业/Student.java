package 第九周作业; 
public class Student {
	public String no;//学号
	public String name;//姓名
	public String gender;//性别
	public String college;//学院
	public String password;//密码
	public Student()
	{
		
	}
	
	public Student(String no, String name, String gender, String college, String password) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.college = college;
		this.password = password;
	}
	public String toString()
	{
		return ("学号："+this.no+"姓名："+this.name+" 性别:"+this.gender+" 学院:"+this.college);
	}
	public boolean judge(String no,String password) {
		if(this.no.equals(no)&&this.password.equals(password))
			return true;
		else
			return false;
	}

  public void changeName(String name){
	this.name=name;
	System.out.println("Successfully!");
}
 public void changeGender(String gender){
	this.gender=gender;
	System.out.println("Successfully!");
}
  public void changeCollege(String college){
	this.college=college;
	System.out.println("Successfully!");
}
 public void deleteName(String name){
	 this.name=name;
	 System.out.println("删除成功");
}

 public String getName(){
	return name;
}
 public String getGender(){
	return gender;
}
 public String getCollege(){
	return college;
}
}
 

