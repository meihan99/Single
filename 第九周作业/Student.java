package �ھ�����ҵ; 
public class Student {
	public String no;//ѧ��
	public String name;//����
	public String gender;//�Ա�
	public String college;//ѧԺ
	public String password;//����
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
		return ("ѧ�ţ�"+this.no+"������"+this.name+" �Ա�:"+this.gender+" ѧԺ:"+this.college);
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
	 System.out.println("ɾ���ɹ�");
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
 

