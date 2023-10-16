import java.util.Scanner;
/**
 *
 * @author Marcelius Vino
 */
public class Vigenere_Cipher {
    public static StringBuilder ciphertext, plaintext;
    public static String text, key, encryptedText, decryptedText;
    public static char plainChar, cipherChar, keyChar, encryptedChar, decryptedChar;
    public static int shift, pilih;
    
    public static String hapusSpace(String text) {
        return text.replaceAll(" ", "");
    }

    public static void encrypt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan teks yang ingin dienkripsi: ");
        text = scan.nextLine();
        
        System.out.print("Masukkan kata kunci: ");
        key = scan.nextLine();
        
        ciphertext = new StringBuilder();
        text = hapusSpace(text.toUpperCase());
        key = hapusSpace(key.toUpperCase());
        
        for (int i = 0, j = 0; i < text.length(); i++) {
            plainChar = text.charAt(i);
            if (plainChar >= 'A' && plainChar <= 'Z') {
                keyChar = key.charAt(j % key.length());
                shift = keyChar - 'A';
                encryptedChar = (char)('A' + (plainChar + shift - 'A') % 26);
                ciphertext.append(encryptedChar);
                j++;
            } else {
                ciphertext.append(plainChar);
            }
        }
        
        encryptedText = ciphertext.toString();
        System.out.println("Teks Terenkripsi: " + encryptedText + "\n");
    }
    
    public static void decrypt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan ciphertext yang ingin didekripsi: ");
        text = scan.nextLine();
        
        System.out.print("Masukkan kata kunci: ");
        key = scan.nextLine();
        
        plaintext = new StringBuilder();
        text = hapusSpace(text.toUpperCase());
        key = hapusSpace(key.toUpperCase());
        
        for (int i = 0, j = 0; i < text.length(); i++) {
            cipherChar = text.charAt(i);
            if (cipherChar >= 'A' && cipherChar <= 'Z') {
                keyChar = key.charAt(j % key.length());
                shift = keyChar - 'A';
                decryptedChar = (char)('A' + (cipherChar - shift - 'A' + 26) % 26);
                plaintext.append(decryptedChar);
                j++;
            } else {
                plaintext.append(cipherChar);
            }
        }
        
        decryptedText = plaintext.toString();
        System.out.println("Teks Terdekripsi: " + decryptedText + "\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("======== VIGENERE CIPHER ========");
            System.out.println("Pilih Proses:"
                + "\n1. Enkripsi"
                + "\n2. Dekripsi"
                + "\n0. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
        
            if(pilih == 1){
                encrypt();
            }else if(pilih == 2){
                decrypt();
            }
        }while(pilih != 0);
    }
}