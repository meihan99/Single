package utility;

 import java.io.BufferedReader;
 import java.io.FileInputStream;
 import java.io.InputStreamReader;
 import java.util.HashMap;

 import user.*;

 public class Utility
 {
 		private static Utility instance;
 		private HashMap<String, User> user = new HashMap<String, User>();

 		private Utility()
 		{
 			FileInputStream in=null;
 			try{
 				in=new FileInputStream("userSrc.txt");

 			InputStreamReader isr=new InputStreamReader(in);
 			BufferedReader br=new BufferedReader(isr);
 			String line;
 			while((line=br.readLine())!=null){
 				String []Mess=line.split(";");
 				for(String str:Mess){
 					String []mess=str.split(",");
 					User u = new User();
 					u.setCardID(mess[0]);
 					u.setUserName(mess[1]);
 					u.setCall(mess[2]);
 					u.setCardpassword(mess[3]);
 					u.setAccount(Integer.parseInt(mess[4]));
 					user.put(u.getCardID(), u);
 					}	
 				}
 			br.close();
 			}catch (Exception e){
 			}
 		}

 		public static Utility getInstance()
 		{
 			if (instance == null)
 			{
 				synchronized (Utility.class)
 				{
 					if (instance == null)
 					{
 						instance = new Utility();
 					}
 				}
 			}
 			return instance;
 		}

 		public User getUser(String cardID)
 		{
 			User user2 = (User)user.get(cardID);
 //			if(user2!=null)
 //			System.out.println(user2.getCardID());
 			return user2;
 		}

 		public HashMap<String, User> getUsers()
 		{
 			return user;
 		}
 }