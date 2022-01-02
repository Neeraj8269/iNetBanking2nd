package utilities;

import java.io.FileInputStream;
import java.util.Properties;




public class ReadConfig{
	public static Properties prop;

	public ReadConfig()
	{
		try {
			   prop = new Properties();
				FileInputStream fis = new FileInputStream("./"+ "\\Configuration\\config.properties");
				prop.load(fis);
				
				
		   }catch(Exception e)
		   {
			   System.out.println("Exception is" +e.getMessage());
		   }
   
	}
	
	public String getUserName()
	 {
	 	String username =  prop.getProperty("uname");
	 	return username;
	 }
	
	
	public String getPassword() {
		String password = prop.getProperty("pwd");
		return password;
	}
	
}


