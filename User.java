import java.io.*;
import java.util.*;

public abstract class User implements HasMenu, Serializable {
    private String userName;
    private String PIN;

    
    public User(){
      this.userName = "";
      this.PIN = "";
    }
    

    public boolean login() {
	System.out.print("Username: ");
	String name = IN.nextLine().trim();
	System.out.print("PIN: ");
	String pin = IN.nextLine().trim();
	return login(name, pin);
    }

    public boolean login(String userName, String PIN){
      boolean success = false;
      if (this.userName.equals(userName) && this.PIN.equals(PIN)){
	System.out.println("Login Successful");
	success = true;
      } else {
	System.out.println("Login Failed");
      }
      return success;
    }

    public void setUserName(String userName){
      this.userName = userName;
    }

    public String getUserName(){
      return this.userName;
    }

    public void setPIN(String PIN){
      this.PIN = PIN;
    }

    public abstract String getReport();

}
