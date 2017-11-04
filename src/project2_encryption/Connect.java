
package project2_encryption;

import java.sql.*;
import javax.swing.JOptionPane;


public class Connect {
    
    static String str;
    static String str2;
    public void setText(String set , String set2){
        str = set;
        str2 = set2;
    }
    
    
    //For Screen2B
    static String getusr;
    static String getpass;
    static String setusr;
    static String pass;
    
    public void setText(String s){
        setusr = s;
        
    }
    
    
    public static void connection(){
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try {
            
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/encryption?user=root&password=");
            stmt = con.createStatement();
            
            
                if(str!=null){
                ps = con.prepareStatement("insert into user(user_name,pass) values (?,?)");
                ps.setString(1,str);
                ps.setString(2, str2);

                int i = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "New User created successfully.", "Congratulation!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
        if(setusr != null){
        try {
            ps = con.prepareStatement("select * from user");
            rs = ps.executeQuery();
            while(rs.next()){
               getusr = rs.getString("user_name");
               getpass = rs.getString("pass");
               
               if(getusr.equals(setusr)){
                   
                   pass = getpass;
                   break;
               }
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    }
    
    /*public String getUser(){
        return getusr;        
    }*/
    public String getPass(){
        return pass;
    }
    
}
