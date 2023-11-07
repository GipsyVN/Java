public class Tebel_Vigenere {
    public static void main(String[] args) {
        char table[][] = create();
        
        // for(int i = 0; i < 26; i++){
        //     for(int j = 0; j < 26; j++){
        //         System.out.println(Arrays.toString(table[i]));
        //     }
        //     System.out.println();
        // }

        for (char[] baris : table) {
            System.out.print("{");
            for (char col : baris) {
                System.out.print((col + ","));
            }
            System.out.print("}\n");
        }
        //System.out.println("}\n");
    }

    private static char[][] create(){
        char table[][] = new char[26][26];
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                table[i][j] = alpha.charAt((i + j) % 26);
            }
        }
        return table;
    }
}
