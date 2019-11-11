package 第九周作业;

public class Main {
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

