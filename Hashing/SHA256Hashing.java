import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class SHA256Hashing {

    public static String hashText(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
	    // Menghitung hash dari teks
	    byte[] encodedHash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            
	    // Mengubah nilai byte menjadi format hexadecimal
	    StringBuilder hashedText = new StringBuilder();
            for (byte b : encodedHash) {
                hashedText.append(String.format("%02x", b));
            }
            return hashedText.toString();
        } catch (NoSuchAlgorithmException e) {
	    // Handle exception jika algoritma hashing tidak tersedia            
	    e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
      	Scanner scan = new Scanner(System.in);
      	System.out.print("Masukan Teks: ");
        String teks = scan.nextLine();
        String hashedValue = hashText(teks);

        System.out.println("Teks Asli: " + teks);
        System.out.println("Hashed Value (SHA-256): " + hashedValue);
    }
}