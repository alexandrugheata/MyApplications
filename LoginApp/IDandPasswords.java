import java.util.HashMap;

public class IDandPasswords {
    
    HashMap<String,String> logininfo = new HashMap<>();

    IDandPasswords(){

        logininfo.put("Bro","pizza");
        logininfo.put("Mihai","HELLO");
    }

    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
