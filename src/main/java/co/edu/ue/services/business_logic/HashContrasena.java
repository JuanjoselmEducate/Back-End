package co.edu.ue.services.business_logic;

import org.springframework.stereotype.Component;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

@Component
public class HashContrasena {
	
	public boolean hashContrasenaValidated(String plainPassword, String hashedPassword) {
        String hashedPlainPassword = hashContrasena(plainPassword);
        return hashedPlainPassword != null && hashedPlainPassword.equals(hashedPassword);
    }
	
	public String hashContrasena(String contrasena) {
		try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                contrasena.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: The requested hashing algorithm is not available.");
            return null;
        }
	}
	
	 private String bytesToHex(byte[] hash) {
	        StringBuilder hexString = new StringBuilder(2 * hash.length);
	        for (byte b : hash) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    }
}
