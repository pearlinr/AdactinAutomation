package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public Properties prop=new Properties();
	public ConfigReader () throws Exception {
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\cucumber\\prop\\Config.properties");
		FileInputStream fin= new FileInputStream(f);
		prop.load(fin);
	}
	
	public String getBrowserName() throws Exception {
		String p = prop.getProperty("browserName");
		/*if (p==null) {
			throw new Exception("Invalid browser name");
		}*/
		return p;
	}
	
	
	public String getUrl() throws Exception {
		String pp = prop.getProperty("url");
		if (pp==null) {
			throw new Exception("Invalid URL name");
		}
		return pp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}