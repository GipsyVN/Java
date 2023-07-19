package data_mahasiswa;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelius Tri Vino
 */
public class Koneksi {
    public static Connection con;
    public static void koneksi(){
        try{
            String url = "jdbc:mysql://localhost/Data_Mahasiswa";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal\n" + e.getMessage());
            System.exit(0);
        }
    }
}
