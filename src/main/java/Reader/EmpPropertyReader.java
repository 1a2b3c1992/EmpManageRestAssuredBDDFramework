package Reader;

import java.io.FileReader;
import java.util.Properties;

public class EmpPropertyReader {
	public static String path = System.getProperty("user.dir") + "/src/main/resources/ConfigurationLayer/config.properties";

	public static String getPropery(String key)
	{
		Properties prop = new Properties();

		try
		{
			FileReader file = new FileReader(path);
			prop.load(file);
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return prop.getProperty(key);
	}
}
