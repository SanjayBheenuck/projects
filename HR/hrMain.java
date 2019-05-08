package HR;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Collections;

//See readme: To login use user ID and password,
//as there are different levels of access you will need to login to HR as a HR employee type,
//HR manager as manager type and employee as employee etc...

public class hrMain {
    Scanner myScanner = new Scanner(System.in);
    ArrayList<employee> employees = new ArrayList<employee>();
    ArrayList<loginDetails> logins = new ArrayList<>();     ///Imports, setting up lists, main methods.

    public void setEmployees(ArrayList employees){
        this.employees = employees;
    }

    public ArrayList getEmployees(){
        return employees;


    }

    public static void main(String[] args) {

        hrMain hr = new hrMain();   //main method

        hr.listInit();


    }
                        //Employee Arraylist intialises
    private void listInit() {
        employees.add(new employee(1, "Jackson", "Johnson", 16091962, //Lists, intialise.
                "123 Fake Street", "Reckton on Wye", "Somerset", "R12 9EQ",
                "076078934", "Jackson123@gmail.com", "Manager", 26022012));
        employees.add(new employee(2, "Johnson", "Jack", 15101978,
                "345 Real Street", "Truton", "Wessex", "WE3 5FF",
                "07990775", "Johnson123@gmail.com", "HR", 12081995));
        employees.add(new employee(3, "Fats", "Waller", 121153,
                "4/4 cool street", "Aqua Calliente", "squaresville", "sq2 ter",
                "07655789", "fats@gmail.com", "HR manager", 25041999));
        employees.add(new employee(4, "Mike", "Face", 151288,
                "12 U bend", "cooltown", "Foppston", "FE3 4EF",
                "07455298", "mikeface@gmail.com", "scrubbing boy", 2602201));
        employees.add(new employee(5, "Lampick", "Jones", 1011994,
                "567 Street", "tonkville", "Aberdeenshire", "AB3 4EQ",
                "07755963", "lampwick@protonmail.com", "Janitor", 2504199));
        employees.add(new employee(6, "Phillipa", "Offbeat", 161786,
                "12 cool street", "Aqua Calliente", "squaresville", "sq5 9ez",
                "01432 6879", "philly@email.com", "Data science", 25041999));


        loginListInit();
    }


                                    //login arraylist initialises
    private void loginListInit() {
        logins.add(new loginDetails("Jackson Johnson", "123safe", "1", 1));
        logins.add(new loginDetails("Johnson Jackson", "supersafe456", "2", 2));
        logins.add(new loginDetails("Fats Waller", "skat54", "3", 3));
        logins.add(new loginDetails("Mike Face", "fido", "1", 4));
        logins.add(new loginDetails("Lampwick Jones", "lampy the best", "2", 5));
        logins.add(new loginDetails("Phillipa Offbeat", "philly", "1", 6));
newSession();

    }






    public void newSession() {    //Main menu, provides access to three login levels.
        System.out.println("....." + "\n \n" + "......." + "\n \n" + "......");
        System.out.println("Welcome to the Dean Lewis Megacorporation HR system" + "\n \n");
        System.out.println("....." + "\n \n" + "......." + "\n \n" + "......");     //New Session, prompts for 3 levels of access.
        System.out.println("Please select an option from the following: ");
        System.out.println("....." + "\n \n" + "......." + "\n \n" + "......");
        System.out.println("1 - Employee login");
        System.out.println("2 - HR login");
        System.out.println("3 - HR Manager login");
        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice) {
            case 1:
                employeeSession();
                break;

            case 2:
                hrSession();
                break;

            case 3:
                managerSession();
                break;

            default:
                System.out.println("No such option");
                newSession();

        }
    }

    private void hrSession() { //Hr login prompts user Id and pass, then compares "type"
        System.out.println("You have chosen to login as a member of the HR team.");
        System.out.println(" ");
        System.out.println("enter user ID:...   ");
        int loginAttemptID = Integer.parseInt(myScanner.nextLine());
        System.out.println(" ");
        System.out.println("Enter Password:...");
        String loginAttemptPassword = myScanner.nextLine();

        String loginAttemptType = "2";

        boolean loginYes = false; //boolean value confirms or denys login attempt.
        for (loginDetails login : logins) {
            if (login.checkDetails(loginAttemptID, loginAttemptPassword, loginAttemptType))   //Function checks user Id, password and type to confirm access.
                hrLoginOkay(loginAttemptID);  //function called from employee data class.
            loginYes = true;
        }
        if (loginYes == false) {
            System.out.println("Incorrect login, please try again"); //boolean verifies access.
            hrSession();
        }
        System.out.println("Incorrect login, please try again");
        hrSession();

    }

    private void managerSession() { //Methodolgy is the same as HR login
        System.out.println("You have chosen to login as the HR manager");
        System.out.println(" ");
        System.out.println("enter user ID:...   ");
        int loginAttemptID = Integer.parseInt(myScanner.nextLine());
        System.out.println(" ");
        System.out.println("Enter Password:...");
        String loginAttemptPassword = myScanner.nextLine();

        String loginAttemptType = "3";

        boolean loginYes = false;
        for (loginDetails login : logins) {
            if (login.checkDetails(loginAttemptID, loginAttemptPassword, loginAttemptType))   //Function checks user Id, password and type to confirm access.
                managerLoginOkay(loginAttemptID);
            loginYes = true;
        }
        if (loginYes == false) {
            System.out.println("Incorrect login, please try again");
            managerSession();
        }
        System.out.println("Incorrect login, please try again");
        managerSession();

    }


    public void employeeSession() {  //Methodology is the same as previous login.
        System.out.println("Welcome, please follow the instructions to login");  //Employee login menu captures user ID and password.
        System.out.println(" ");
        System.out.println("enter user ID:...   ");
        int loginAttemptID = Integer.parseInt(myScanner.nextLine());
        System.out.println(" ");
        System.out.println("Enter Password:...");
        String loginAttemptPassword = myScanner.nextLine();
        String loginAttemptType = "1";

        boolean loginYes = false;
        for (loginDetails login : logins) {
            if (login.checkDetails(loginAttemptID, loginAttemptPassword, loginAttemptType))   //Function checks user Id, password and type to confirm access.
                employeeLoginOkay(loginAttemptID);
            loginYes = true;


        }
        if (loginYes == false) {
            System.out.println("Incorrect login, please try again");
            employeeSession();
        }
        System.out.println("Incorrect login, please try again");
        employeeSession();
    }

    private void employeeLoginOkay(int id) {
        for (employee e : employees) {  //Verfication of user ID, then user is sent to employee menu.
            if (e.employeeID == id) {
                employeeLogin li = new employeeLogin(e);
                li.menu();
            }
        }

    }

    private void hrLoginOkay(int id) {

            for (employee e : employees) {
                if (e.employeeID == id) {   //ID verified and user sent to Hr menu.
                    hrLogin hr = new hrLogin(employees);
                    hr.menu();
                }
            }
    }

    private void managerLoginOkay(int id){
        for(employee e: employees){ //ID verified, user sent to manager login.
            if(e.employeeID == id){
                managerLogin ml = new managerLogin(employees);
                ml.menu();
            }
        }
    }



    }
