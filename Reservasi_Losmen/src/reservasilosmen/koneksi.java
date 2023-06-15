package reservasilosmen;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    public static Connection con;
    public static Statement stm;
    public static Resultset rs;
    public static void dbkoneksi(){
        try{
            String url = "jdbc:mysql://localhost/losmen_mms";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi gagal\n(" + e.getMessage() + ")");
        }
    }
    
    public static void main(String[] args) throws SQLException {
        new f_login().setVisible(true);
        
    }
    
}
