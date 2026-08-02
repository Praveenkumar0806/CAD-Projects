package features.Login;
import data.dto.User;


public class LoginView {
    LoginModel loginModel;

    public LoginView(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
    public User displayLogin(){
       return  loginModel.login();
    }
}
