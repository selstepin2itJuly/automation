package objectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	
	public By getElement(String str) throws IOException{
		
		Properties prop = new Properties();
		InputStream inputstream = new FileInputStream("ObjectRepo.properties");
		prop.load(inputstream);
		String string = prop.getProperty(str);
		String[] loc=string.split(";");
		String locator = loc[0];
		String value1 = loc[1];
		By value=null;
		try {
			if(locator.equalsIgnoreCase("id")) {
				value=By.id(value1);
			}
			else if(locator.equalsIgnoreCase("name")) {
				value=By.name(value1);
			}
			else if(locator.equalsIgnoreCase("class")) {
				value=By.className(value1);
			}
			else if(locator.equalsIgnoreCase("tag")) {
				value=By.tagName(value1);
			}
			else if(locator.equalsIgnoreCase("xpath")) {
				value=By.xpath(value1);
			}
			else if(locator.equalsIgnoreCase("css")) {
				value=By.cssSelector(value1);
			}
			else if(locator.equalsIgnoreCase("linkText")) {
				value=By.linkText(value1);
			}
			else if(locator.equalsIgnoreCase("partialLinkText")) {
				value=By.partialLinkText(value1);
			}
			else {
				System.out.println("Element not defined");
				//value=null;
		}
		}catch(Exception e) {
		   	System.out.println(e.getMessage());
		}
		return value;
		
		
	}

}
