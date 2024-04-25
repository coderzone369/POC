package hashingAlgo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
	
	
	static byte[] key = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	
	public static void main(String[] args) {
		String plaintext = "akash@123";
		try {
			String encoded = toEncrypt(plaintext);
			System.out.println(encoded);
			System.out.println(toDecrypt(encoded));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String toEncrypt(String plaintext) throws Exception {
		// Step 1: Choose the encryption algorithm and mode
        String algorithm = "AES";
        
        // Step 2: Create a key for the chosen encryption algorithm
       // KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);

        SecretKey secretKey = new SecretKeySpec(key, 0, key.length, algorithm);
        
        
        // Step 3: Initialize a cipher object with the key and encryption mode
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        // Step 4: Encrypt the data using the cipher object
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        
        System.out.println("Encrypted data: " + encryptedBase64);
        System.out.println("Secret key:"+secretKey);
        System.out.println(encryptedBase64.length());
		return encryptedBase64;
	}
	
	public static String toDecrypt(String encryptedBase64) throws Exception {
		 // Step 1: Choose the same encryption algorithm and mode used during encryption
        String algorithm = "AES";
        
        // Step 2: Use the same key that was used during encryption
        // In this example, we assume that you have the secret key from the encryption example
//        SecretKey secretKey = ...;
        
        // Step 3: Initialize a cipher object with the key and decryption mode

        SecretKey secretKey = new SecretKeySpec(key, 0, key.length, algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        // Step 4: Decrypt the data using the cipher object
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        
        System.out.println("Decrypted data: " + decryptedText);
        return decryptedText;
	}
}
