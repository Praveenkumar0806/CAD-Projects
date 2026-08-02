package data.dto;

public class User {
    private int userId;
    private int userAge;
    private String userPassword;
    private String userName;
    private String userDOB;
    private String userPhoneno;
    private String userMail;
    private String gender;

    public User(int userId,int userAge,String userPassword, String userName,String userDOB,String userPhoneno,String userMail,String gender){
        this.userId =userId;
        this.userAge=userAge;
        this.userPassword=userPassword;
        this.userName=userName;
        this.userDOB=userDOB;
        this.userPhoneno=userPhoneno;
        this.userMail=userMail;
        this.gender=gender;
    }
    public int getUserId(){
        return userId;
    }
    public int getUserAge(){
        return userAge;
    }
    public String getUserPassword(){
        return userPassword;
    }
    public String getUserName(){
        return userName;
    }
    public String getUserDOB(){
        return userDOB;
    }
    public  String getuserPhoneno(){
        return userPhoneno;
    }
    public  String getUserMail(){
        return userMail;
    }
    public  String  getGender(){
        return gender;
    }

    public void setUserId(int userId){
        this.userId =userId;
    }
    public void setUserAge(int userAge){
        this.userAge=userAge;
    }
    public void setUserPassword(String userPassword){
        this.userPassword=userPassword;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setUserDOB(String userDOB) {
        this.userDOB = userDOB;
    }
    public void setuserPhoneno(String userPhoneno){
        this.userPhoneno=userPhoneno;
    }
    public void setUserMail(String userMail){
        this.userMail=userMail;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
}
