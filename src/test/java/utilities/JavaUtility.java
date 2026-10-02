package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtility {

	public String randomAlphabetic(int count) {
		
		return RandomStringUtils.randomAlphabetic(count);
		
	}

	public String randomNumeric(int count) {
		
		return RandomStringUtils.randomNumeric(count);
		
	}
	
	public String randomAlphanumeric(int count) {
		
		return RandomStringUtils.randomAlphanumeric(count);
		
	}
	
	public String currentTimeStamps() {
		
		return new SimpleDateFormat("YYYYmmdd_hhmmss").format(new Date());
		
	}
	
}
