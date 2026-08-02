package features.Admin;
import java.util.Scanner;

public class AdminVIew {
    AdminModel adminModel;
    public AdminVIew(AdminModel adminModel)
    {
        this.adminModel=adminModel;
    }


    public void adminDisplay()
    {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1.Add Flights");
            System.out.println("2.Remove Flights");
            System.out.println("3.Update Flights");
            System.out.println("4.Exit");
            System.out.println("Enter a Admin operation choice : ");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    adminModel.addFlight();

                    break;
                case 2:
                    adminModel.removeFlight();

                    break;
                case 3:
                    adminModel.updateFlight();

                    break;
                case 4:
                    System.out.println("Admin Logged Out!..");
                    System.out.println("-----------------------------------------------");
                    return;
                default:
                    System.out.println("Invalid choice \n Please enter a valid choice!..");
                    break;
            }
        }
    }
}
