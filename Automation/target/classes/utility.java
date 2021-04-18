package Resources;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Random;

public class utility {
	
	public static String decode(String encodedpassword) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedpassword);
		String decodedpass = new String(decodedBytes);
		return decodedpass;
	}
	
	
public static String random() {
	String abc = "ABCDRTYUOLKJHGFVBNM";
	Random r = new Random();
	char letter= abc.charAt(r.nextInt(abc.length()));
	System.out.println(letter);
	return Character.toString(letter);
	
    
}

}
