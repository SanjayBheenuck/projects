package HR;


import java.util.ArrayList;
import java.util.Scanner;

public class employeeLogin {

    Scanner myScanner = new Scanner(System.in);
    employee emp;

    public employeeLogin(employee emp) { //Pass user ID into this class to allow user to view and edit details.
        this.emp = emp;
    }

    public void menu() {  //menu presents employee level choices./
        System.out.println("Login successful.");

        System.out.println("1 - View my details");

        System.out.println("2 - Edit my details");

        System.out.println("3 - Logout");

        int choice = Integer.parseInt(myScanner.nextLine());


        switch (choice){

            case 1:
                viewDetails();
                break;

            case 2:
                editdetails();
                break;

            case 3:
                hrMain hr = new hrMain();
                hr.newSession();

            default:
                return;
        }


    }

    private void editdetails() {
        System.out.println("Your Permission level allows you to edit"); //If user has selected to edit..
        System.out.println("1 - name ");
        System.out.println("2 - Contact details");  //Access level only allows editing of these values.
        System.out.println("3 - Address");
        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice){

            case 1:
                editFirstName();
                break;

            case 2:
                editContact();
                break;

            case 3:
                editAddress();
                break;
        }

    }

    private void editAddress() {  // populates variables with new information.
        System.out.println("You have chosen to edit your address details: ");
        System.out.println("Please enter the first line of  your new address...");
        String newAddress = myScanner.nextLine();
        System.out.println("Please enter your postcode...");
        String newPostcode = myScanner.nextLine();
        System.out.println("Please enter you new town/city...");
        String newCity = myScanner.nextLine();
        System.out.println("Please enter your new county...");
        String newCounty = myScanner.nextLine();

        System.out.println("Confirm change of details?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int choice = Integer.parseInt(myScanner.nextLine()); //confirm change

        switch (choice){
            case 1:
                emp.employeeAddress1= newAddress;  //fills arraylist data with new captured variables.
                emp.employeeTownCity = newCity;
                emp.employeePostCode = newPostcode;
                emp.employeeCounty = newCounty;
                System.out.println("Change confirmed");
                menu();
                break;

            case 2:
                System.out.println("Data has not been changed");
                menu();
                break;

            default:
                return;
        }


    }

    private void editContact() { //Process same as above.
        System.out.println("You have chosen to edit your contact details: ");
        System.out.println("Please enter your telephone number... ");
        String newNumber = myScanner.nextLine();
        System.out.println("Please enter your new e-mail address...");
        String newEmail = myScanner.nextLine();
        System.out.println("Confirm change of details?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");


        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice){
            case 1:
                emp.employeeContactNumber= newNumber;
                emp.employeeEmailAddress = newEmail;
                System.out.println("Change confirmed");
                menu();
                break;

            case 2:
                System.out.println("Data has not been changed");
                menu();
                break;

            default:
                return;
        }
    }

    private void editFirstName() { //Method will update list data with new values.

        System.out.println("You have chosen to edit your name, please enter your first name:  ");
        String newFirstName = myScanner.nextLine();
        System.out.println("Please enter your last name: ");
        String newLastname = myScanner.nextLine();
        System.out.println("Confirm change of details?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice){
            case 1:
                emp.employeefirstName= newFirstName;  //Process is the same as above.
                emp.employeelastName = newLastname;
                System.out.println("Change confirmed");
                menu();
                break;

            case 2:
                System.out.println("Data has not been changed");
                menu();
                break;

                default:
                    return;
        }

    }

    private void viewDetails() { //Method prints out user details from object passed as parameter.
        System.out.println("The following information is held by our system"+ "\n"+ " please note that you do not " +
                "have permission to edit some of these fields" );
        System.out.println(emp.employeeID);   //Method will print all employee data.
        System.out.println(emp.employeefirstName+(" ")+emp.employeelastName);
        System.out.println(emp.employeeContactNumber);
        System.out.println(emp.employeeAddress1);
        System.out.println(emp.employeeCounty);
        System.out.println(emp.employeeTownCity);
        System.out.println(emp.employeeDateOfBirth);
        System.out.println(emp.employeeEmailAddress);
        System.out.println(emp.employeePosition);
        System.out.println(emp.employeePostCode);
menu();
    }
}