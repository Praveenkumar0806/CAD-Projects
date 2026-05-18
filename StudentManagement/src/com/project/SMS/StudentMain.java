package com.project.SMS;
import  java.util.Scanner;
import java.util.ArrayList;

public class StudentMain {
    Student student;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Praveen");
        ArrayList<Student> studentList = new ArrayList<>();

        while(true)
        {
            admin.showMenu();
            System.out.println("Enter your Option : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter your Roll NO :");
                    int studRollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter your Name : ");
                    String stdName = sc.nextLine();

                    System.out.println("Enter your MailId : ");
                    String stdMail = sc.nextLine();

                    System.out.println("Enter your DEPT : ");
                    String stdDept = sc.nextLine();

                    System.out.println("Enter your Gender : ");
                    String stdGender = sc.nextLine();

                    System.out.println("Enter your City : ");
                    String stdCity = sc.nextLine();

                    System.out.println("Enter your Phone_NO");
                    String stdPhone = sc.nextLine();

                    System.out.println("Enter your Mark : ");
                    int stdMark=sc.nextInt();
                    sc.nextLine();

                    studentList.add(new Student(studRollNo,stdName,stdMail,
                            stdDept,stdGender,stdCity,stdPhone,stdMark));

                    System.out.println("Student Added Successfully!..");
                    break;
                case 2:
                    if(studentList.isEmpty())
                    {
                        System.out.println("No Students Available!..");
                    }
                    else
                    {
                        for(Student student : studentList)
                        {
                           student.display();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter your ROLL NO : ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();
                    boolean found=false;
                    for(Student student : studentList)
                    {
                        if(student.getRollNo()==rollNo)
                        {
                            System.out.println("Enter your new Mark : ");
                            int newMark= sc.nextInt();
                            student.setMark(newMark);
                            System.out.println("Your New Mark Will Be Update Successfully!..");
                            found=true;
                            break;
                        }
                    }
                    if(!found)
                    {
                            System.out.println("Wrong ROLL NO.. \n Please Enter Correct RollNo!..");
                    }
                    break;
                case 4:
                    System.out.println("Exit Successfully!..");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice \n Please Enter Valid Choice..");
                    break;
            }
        }
    }
}
