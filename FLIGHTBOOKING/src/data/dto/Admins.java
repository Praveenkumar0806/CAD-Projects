package data.dto;

public class Admins {
    private String adminName;
    private int adminId;
    private String adminPassword;

    public String getAdminName(){
        return adminName;
    }
    public int getAdminId() {
        return adminId;
    }
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminName(String adminName) {
        this.adminName=adminName;
    }
    public void setAdminId(int adminId){
        this.adminId=adminId;
    }
    public void setAdminPassword(String adminPassword){
        this.adminPassword=adminPassword;
    }
}
