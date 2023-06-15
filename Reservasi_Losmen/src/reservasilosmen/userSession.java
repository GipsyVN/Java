package reservasilosmen;

public class userSession {
    public static String id;
    public static String Uname;
    public static String pass;
    
    public static String get_id(){
        return id;
    }
    public static void set_id(String id){
        userSession.id = id;
    }
    
    public static String get_Uname(){
        return Uname;
    }
    public static void set_Uname(String Uname){
        userSession.Uname = Uname;
    }
    
    public static String get_pass(){
        return pass;
    }
    public static void set_pass(String pass){
        userSession.pass = pass;
    }
}
