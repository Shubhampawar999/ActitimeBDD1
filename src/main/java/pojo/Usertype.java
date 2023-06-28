package pojo;

public class Usertype {
   private String email;
   private String firstName;
   private String lastName;
   private String username;
   private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;

   public void  setEmail(String email){
       this.email=email;
   }
   public void setfirstName(String firstName){
       this.firstName=firstName;
   }
   public void setLastName(String lastName){
       this.lastName=lastName;
   }
   public void setUsername(String username){
       this.username=username;
   }
   public void setPassword(String password){
       this.password=password;
   }

   public String getEmail(){
       return email;
   }
    public String getfirstName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public String getusername(){
        return username;
    }
    public String getpassword(){
        return password;
    }

    public String toString(){
       return super.toString();
    }


}
