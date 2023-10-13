import java.util.Scanner;
/**
 *
 * @author Marcelius Vino
 */
public class Caesar_Cipher {
    public static StringBuilder cipherText;
    public static String encrypted, decrypted, plaintext, ciphertext, decryptText;
    public static char karakter, base, encryptedChar;
    public static int key, pilih;
    
    // Fungsi untuk menginput plaintext
    public static void encrypt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Pesan: ");
        plaintext = scan.nextLine();
        System.out.print("Masukan Kunci: ");
        key = scan.nextInt();
       
        plaintext = plaintext.toLowerCase();
        encrypted = process(plaintext, key);
        System.out.println("Pesan Terenkripsi: " + encrypted + "\n");
    }

    // Fungsi untuk menginput ciphertext
    public static void decrypt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Pesan: ");
        ciphertext = scan.nextLine();
        System.out.print("Masukan Kunci: ");
        key = scan.nextInt();
       
        ciphertext = ciphertext.toLowerCase();
        decrypted = process(ciphertext, 26 - key);
        System.out.println("Pesan Asli: " + decrypted + "\n");
    }
    
    //Fungsi untuk mengenkripsi/dekripsi pesan
    public static String process(String plaintext, int shiftKey) {
        cipherText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            karakter = plaintext.charAt(i);
            if (Character.isLetter(karakter)) {
                base = Character.isLowerCase(karakter) ? 'a' : 'A';
                encryptedChar = (char) ((karakter - base + shiftKey) % 26 + base);
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(karakter);
            }
        }
        return cipherText.toString();
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("======== CAESAR CIPHER ========");
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
            }else if(pilih == 3){
                bruteForce();
            }
        }while(pilih != 0);
    }

    public static void bruteForce() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan Pesan Terenkripsi: ");
        ciphertext = scan.nextLine();
        System.out.println("Mencoba semua kemungkinan pergeseran:");

        for (int shift = 1; shift <= 26; shift++) {
            decryptText = process(ciphertext, 26 - shift);
            System.out.println("Shift " + shift + ": " + decryptText);
        }
    }
}