package features.SignUp;
import data.dto.User;
import java.util.Scanner;
import java.util.ArrayList;

public class SignUpModel {
   public ArrayList<User> userList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addUsers()
    {
        System.out.println("Enter your  ID : ");
        int userId = sc.nextInt();
        System.out.println("Enter your  AGE : ");
        int userAge=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your  PASSWORD : ");
        String userPassword=sc.nextLine();

        System.out.println("Enter your  NAME : ");
        String userName=sc.nextLine();

        System.out.println("Enter your DOB (DD-MM-YY) : ");
        String usedDOB = sc.nextLine();

        System.out.println("Enter your PHONE NO : ");
        String userPhoneno =sc.nextLine();

        System.out.println("Enter your G-MAIL : ");
        String userMail = sc.nextLine();

        System.out.println("Enter your GENDER : (Male / Female)  ");
        String  gender= sc.nextLine();


        User user = new User(userId,userAge,userPassword,userName,usedDOB,userPhoneno,userMail,gender);
        userList.add(user);

    }
}
