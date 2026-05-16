package features.Login;
import data.dto.User;
import features.SignUp.SignUpModel;
import java.util.Scanner;

public class LoginModel {
    SignUpModel signUpModel;

    public LoginModel(SignUpModel signUpModel) {
        this.signUpModel = signUpModel;
    }

    public User login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your USER ID : ");
        int Id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your USER PASSWORD : ");
        String passWord =  sc.nextLine();

        User loggedUser = null;
        for (User users : signUpModel.userList) {
            //System.out.println("Checking: " + users.getUserId() + " " + users.getUserPassword());

            if (users.getUserId() == Id && users.getUserPassword().equals(passWord)) {
                loggedUser = users;
                break;
            }
        }
        if (loggedUser!=null) {
            System.out.println("Login Successfully!...");
            System.out.println("-----------------------------------------------");
        } else {
            System.out.println("Invalid ID & PASSWORD \n If new User Please SIGNUP!.. \n Thank you!.. ");
            System.out.println("-----------------------------------------------");
        }
        return loggedUser;
    }
}