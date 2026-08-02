package features.SignUp;

public class SignUpView {
    SignUpModel model;

    public SignUpView(SignUpModel signUpModel)
    {
        this.model = signUpModel;
    }
    public void displaySignUp() {
        model.addUsers();
    }
}
