
package project2_encryption;


public class Encrypt {
    
    static String pass;
    public void setText(String set){
        pass = set;
        
    }
    static String sav = "";

    public static void test() {
        
        try{
        
        int i = 0;
        sav = "";
        while(i < pass.length()){
            
            
            char ext = pass.charAt(i);
            int asc = (int)ext;
            int z = asc * 2;
            
            sav = "" + sav + z;
            i++;

        }
        }catch(Exception e){
            System.out.println(e);
        }
        

    }
    public String getText(){
            return sav;
            
        }
    
    
}
