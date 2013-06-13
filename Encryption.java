import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ardi
 * @email: rizky.ardiansyah4891@gmail.com
 */
public class Encryption {

  public static void main(String[] bluesLegend){
		// put your input text here!
		String inputText = "Eric Clapton";
		// final encryption should be like this
		System.out.println(encrypt(inputText));
	}
	
    public static String encrypt(String plainText) {
        String cipherText = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(plainText.getBytes("UTF-8")); //converting byte array to Hexadecimal 
            StringBuilder sb = new StringBuilder(2 * hash.length);

            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }

            cipherText = sb.toString();
        } 
		catch (UnsupportedEncodingException ex) {} 
		catch (NoSuchAlgorithmException ex) {}

        return cipherText;
    }
}
