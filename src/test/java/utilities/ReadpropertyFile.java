package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader("E:\\github\\framework_build\\src\\test\\resources\\configfiles\\config.properties");
		
		Properties propert = new Properties();
		
		propert.load(fr);
		
		System.out.println(propert.getProperty("browser", null));
		System.out.println(propert.getProperty("testurl"));
	}

}
