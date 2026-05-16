import features.Login.LoginView;
import features.SignUp.SignUpModel;
import features.SignUp.SignUpView;
import features.Login.LoginModel;
import data.dto.User;
import features.Admin.AdminModel;
import features.Admin.AdminVIew;
import features.Flight.FlightModel;
import features.Flight.FlightView;
import features.Booking.BookingModel;
import features.Booking.BookingView;
import java.util.Scanner;

public class FlightMain {
    public static void main(String[] args)
    {
        AdminModel adminModel = new AdminModel();
        AdminVIew adminVIew = new AdminVIew(adminModel);
        SignUpModel signUpModel =  new SignUpModel();
        LoginModel loginModel = new LoginModel(signUpModel);
        SignUpView signUpView = new SignUpView(signUpModel);
        FlightModel flightModel = new FlightModel(adminModel);
        LoginView loginView = new LoginView(loginModel);
        FlightView flightView = new FlightView(flightModel);
        BookingModel bookingModel = new BookingModel(flightModel);
        BookingView bookingView = new BookingView(bookingModel);

        Scanner sc = new Scanner(System.in);
        boolean adminDone=false;
        while(!adminDone)
        {
            System.out.println("Welcome To Admin Login!..");
            System.out.println("1.Admin Login");
            System.out.println("2.Continue to User");
            System.out.println("Enter a choice (1-2) ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid Input! Enter numbers only.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter Admin Password : ");
                    String adminPass = sc.next();
                    if(adminPass.equals("Praveen@123")) {
                        adminVIew.adminDisplay();
                    } else {
                        System.out.println("Wrong Password!");
                    }
                    break;
                case 2:
                    adminDone=true;
                    break;
                default:
                    System.out.println("Invalid Choice!..");
                    break;

            }
        }
        while(true)
        {
            System.out.println("Welcome To Flight Ticket Booking!..");
            System.out.println("1.SignUp ");
            System.out.println("2.User Login ");
            System.out.println("3.Exit ");

            System.out.println("Enter a choice (1-3) ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid Input! Enter numbers only.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    signUpView.displaySignUp();
                    System.out.println("SignUp Successfully completed!..");
                    System.out.println("-----------------------------------------------");
                    break;
                case 2:

                    User userLog = loginModel.login();
                    boolean logout = false;
                    if(userLog!=null)
                    {
                        while(!logout)
                        {
                            System.out.println("Welcome "+userLog.getUserName());
                            System.out.println("1.View All Flights");
                            System. out.println("2.Booking Flight");
                            System. out.println("3.User BookedFlight Ticket View ");
                            System.out.println("4.Logout");
                            System.out.println("Enter a option (1-4) : ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid Input! Enter numbers only.");
                                sc.next();
                                continue;
                            }
                            int option = sc.nextInt();
                            switch(option)
                            {
                                case 1:
                                    flightView.showAllFlights();

                                    break;

                                case 2:
                                    bookingModel.bookingFlight(userLog);

                                    break;

                                case 3:
                                    bookingView.userBookingView(userLog);

                                    break;
                                    case 4:
                                        System.out.println("User Logged Out!");

                                        logout = true;
                                        break;
                                default:
                                    System.out.println("Invalid Option \n Please Type valid Option ");
                                    break;
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using Flight Booking System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice \n Please Enter a valid choice");
                    break;
            }
        }
    }
}
