package HR;

import java.util.*;


public class hrLogin extends hrMain {

    Scanner myScanner = new Scanner(System.in);

    public hrLogin(ArrayList<employee> employees) { //Pass user ID into this class to allow user to view and edit details.
        this.employees = employees;

    }


    public void menu() {
        System.out.println("Login successful. As a HR professional you may:");

        System.out.println("1 - View employee details");  //Hr access level options.

        System.out.println("2 - Edit employee details");

        System.out.println("3 - Add a new employee ");

        System.out.println("3 - Logout");

        int choice = Integer.parseInt(myScanner.nextLine());


        switch (choice) {

            case 1:
                viewDetails();

                break;

            case 2:
                editDetails();


            case 3:
                hrMain hr = new hrMain();
                hr.newSession();

        }
    }

    private void editDetails() {
        System.out.println("enter user ID to edit details...");
        int userID = Integer.parseInt(myScanner.nextLine());  //Uses stream and filter to find user via ID.


        Optional<employee> foundEmployee = employees.stream().filter(e -> e.employeeID == userID).findFirst();

        if (!foundEmployee.isPresent()) {
            System.out.println("User not found");
            editDetails();  //If user isn't found, loop back.


        } else {
            System.out.println("Employee found: ");
            System.out.println(foundEmployee.get().getEmployeefirstName() + " " + foundEmployee.get().getEmployeelastName());
            System.out.println("Which of the user's details would you like to edit? ");
            System.out.println("1- Name");
            System.out.println("2 - Address");
            System.out.println("3 - Contact details");
            System.out.println("4 - Date of birth");
            System.out.println("5 - Start date");
            System.out.println("6 - User ID");      //User ID retains and any of these details are editable for the user found.
            System.out.println("7 - position");
            System.out.println("8 - Return to menu");
            int choice = Integer.parseInt(myScanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Enter new first name: ");  //Arraylist entry is written over get/setter and scanner.
                    foundEmployee.get().setEmployeefirstName(myScanner.nextLine());
                    System.out.println("Enter new second name: ");
                    foundEmployee.get().setEmployeelastName(myScanner.nextLine());
                    System.out.println("New details are: ");
                    System.out.println(foundEmployee.get().getEmployeefirstName() + " " + foundEmployee.get().getEmployeelastName());
                    menu();
                    break;


                case 2:
                    System.out.println("Enter new address(first line) "); //As above for address.
                    foundEmployee.get().setEmployeeAddress1(myScanner.nextLine());
                    System.out.println("Enter new town/city: ");
                    foundEmployee.get().setEmployeeTownCity(myScanner.nextLine());
                    System.out.println("Enter new postcode: ");
                    foundEmployee.get().setEmployeePostCode(myScanner.nextLine());
                    System.out.println("New address is");
                    System.out.println(foundEmployee.get().getEmployeeAddress1() + " "
                            + foundEmployee.get().getEmployeeTownCity() + " " + foundEmployee.get().getEmployeePostCode());
                    menu();
                    break;


                case 3:
                    System.out.println("Enter new contact number: "); //As above for contact details.
                    foundEmployee.get().setEmployeeContactNumber(myScanner.nextLine());
                    System.out.println("Enter new e-mail address: ");
                    foundEmployee.get().setEmployeeEmailAddress(myScanner.nextLine());
                    System.out.println("New contact details are: ");
                    System.out.println(foundEmployee.get().getEmployeeContactNumber() + " " + foundEmployee.get().getEmployeeEmailAddress());
                    menu();

                case 4:
                    System.out.println("Enter new date of birth DDMMYY: "); //overwrites DOB
                    foundEmployee.get().setEmployeeDateOfBirth(Integer.parseInt(myScanner.nextLine()));
                    System.out.println("New details are: ");
                    System.out.println(foundEmployee.get().getEmployeeDateOfBirth());
                    menu();
                    break;

                case 5:
                    System.out.println("Enter new start date DDMMYY: ");  //overwrites start date
                    foundEmployee.get().setEmployeeStartDate(Integer.parseInt(myScanner.nextLine()));
                    System.out.println("New details are: ");
                    System.out.println(foundEmployee.get().getEmployeeStartDate());
                    menu();
                    break;

                case 6:
                    System.out.println("Enter new user ID"); //overwrites user ID
                    foundEmployee.get().setEmployeeID(Integer.parseInt(myScanner.nextLine()));
                    System.out.println("New details are: ");
                    System.out.println(foundEmployee.get().getEmployeeID());
                    menu();
                    break;

                case 7:
                    System.out.println("Enter new employee position: "); //Overwrites position
                    foundEmployee.get().setEmployeePosition(myScanner.nextLine());
                    System.out.println("New details are: ");
                    System.out.println(foundEmployee.get().getEmployeePosition());
                    menu();
                    break;

                case 8:
                    menu();
                    break;

                default:
                    System.out.println("Incorrect!");
                    editDetails();


            }


        }

    }

    private void addNew() { //Add new user, captures all required variables. Then adds to arraylist via .add command.
        System.out.println("enter new user's ID");
        int id = Integer.parseInt(myScanner.nextLine());
        System.out.println("enter new user's Firstname");
        String firstName = myScanner.nextLine();
        System.out.println("enter user's Lastname");
        String lastName = myScanner.nextLine();
        System.out.println("enter user's date of birth");
        int dob = Integer.parseInt(myScanner.nextLine());
        System.out.println("enter user's first line of address");
        String address = myScanner.nextLine();
        System.out.println("enter user's town/city");
        String city = myScanner.nextLine();
        System.out.println("enter new user's county");
        String county = myScanner.nextLine();
        System.out.println("enter user postcode: ");
        String postcode = myScanner.nextLine();
        System.out.println("enter new user's contact number");
        String number = myScanner.nextLine();
        System.out.println("enter new user's email");
        String email = myScanner.nextLine();
        System.out.println("What is the new user's position?");
        String position = myScanner.nextLine();
        System.out.println("When did the new user start ddmmyy");
        int start = Integer.parseInt(myScanner.nextLine());
        System.out.println("Please provide a password");
        String password = myScanner.nextLine();
        String loginName = firstName + lastName;
        System.out.println("What is the users's type?");
        System.out.println("1- employee" + "\n" + "2- HR");
        String type = myScanner.nextLine();

        employees.add(new employee(id, firstName, lastName, dob, address, city, county, postcode, number,
                email, position, start));
        logins.add(new loginDetails(loginName, password, type, id));

        System.out.println("New employee " + firstName + lastName + " added");

        menu();

    }

    private void viewDetails() {

        System.out.println("enter user ID to view details..."); //to view a user capture ID
        int userID = Integer.parseInt(myScanner.nextLine());


        Optional<employee> foundEmployee = employees.stream().filter(e -> e.employeeID == userID).findFirst();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getEmployeefirstName());  //stream and filter finds via ID

            if (!foundEmployee.isPresent()) {
                System.out.println("User not found");
                viewDetails();


            } else {
                System.out.println("Employee found: "); //All employee details are printed via associated ID and getters in employee class.
                System.out.println(foundEmployee.get().getEmployeefirstName() + " " + foundEmployee.get().getEmployeelastName());
                System.out.println(foundEmployee.get().getEmployeeDateOfBirth());
                System.out.println(foundEmployee.get().getEmployeeAddress1());
                System.out.println(foundEmployee.get().getEmployeeTownCity());
                System.out.println(foundEmployee.get().getEmployeeCounty());
                System.out.println(foundEmployee.get().getEmployeePostCode());
                System.out.println(foundEmployee.get().getEmployeeContactNumber());
                System.out.println(foundEmployee.get().getEmployeeEmailAddress());
                System.out.println(foundEmployee.get().getEmployeePosition());
                System.out.println(foundEmployee.get().getEmployeeStartDate());
                System.out.println(foundEmployee.get().getEmployeeID());

                menu();


            }

        }


    }
}








