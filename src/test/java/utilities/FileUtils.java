package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

	public String readData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IframeConstant.PropertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
