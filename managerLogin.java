package HR;

import java.util.ArrayList;
import java.util.Collections;

public class managerLogin extends hrMain {

    public  managerLogin(ArrayList<employee> employees) {
        this.employees = employees;

    }

    public void menu() {
        System.out.println("Login successful, as HR manager you can: "); //Manager levels login options include sort/access to all data.
        System.out.println("1 - View all data of a type IE: 'All names'");
        System.out.println("2 - View all employee data");
        System.out.println("3 - Sort data");
        System.out.println("4 - Logout");

        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice) {

            case 1:
                viewAllInstances();
                break;

            case 2:
                viewEmployeeData();
                break;
            case 3:
                sort();
                break;

            case 4:
                hrMain hr = new hrMain();
                hr.newSession();

             default:
                 menu();
                 break;
        }
    }

    private void sort() {

        System.out.println("You may arrange employee data by: ");
        System.out.println("1 - Ascending order: ");
        System.out.println("2 - Descending order: ");  //sort menu arranges arraylist via collections.sort command
        System.out.println(" 3 - Menu");
        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice){

            case 1:
                ascendingSort();
                break;

            case 2:
                descendingSort();
                break;

            case 3:
                menu();
        }
    }

    private void descendingSort() {

        Collections.sort(employees, Collections.reverseOrder());  //sorts descending.
        System.out.println("You have sorted by descending order");
        menu();


    }

    private void ascendingSort() {
        Collections.sort(employees); //Sorts ascending.
        System.out.println("You have sorted by ascending order");
        menu();
    }

    private void viewEmployeeData() {
        for(employee employee: employees) {
            System.out.println(employee); //See employee class for functionality,
                                            //Overridden "to string" function allows entire arraylist to print.
        }                                   //Though abstract typing means I cannot print int, so dob/ID is excluded.
        menu();                             //There's probably a simple resolution, but I couldn't find it.
    }

    private void viewAllInstances() { //As per brief all instances of a certain type can be viewed.

        System.out.println("What data would you like to see? ");
        System.out.println("1 - All forenames: ");
        System.out.println("2- All surnames: ");
        System.out.println("3- All date of births: ");
        System.out.println("4- All address first lines: ");
        System.out.println("5- All towns/cities: ");
        System.out.println("6- All counties: ");
        System.out.println("7- All postcodes: ");
        System.out.println("8- All contact numbers: ");
        System.out.println("9- All e-mail address': ");
        System.out.println("10- All employee positions: ");
        System.out.println("11- All start dates: ");
        System.out.println("12- All employee ID's: ");
        System.out.println("13- Return to menu: ");


        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice) {
            case 1:
                viewForenames();
                break;

            case 2:
                viewSurname();
                break;

            case 3:
                viewDob();
                break;


            case 4:
                viewAddress1();
                break;


            case 5:
                viewCity();
                break;

            case 6:
                viewCounty();
                break;


            case 7:
                viewPostCode();
                break;

            case 8:
                viewContactNumber();
                break;

            case 9:
                viewEmail();
                break;

            case 10:
                viewPosition();
                break;

            case 11:
                viewStart();
                break;

            case 12:

             viewID();
             break;

            case 13:
             menu();
             break;

            default:
                System.out.println("Incorrect");
                menu();
                break;
        }


    }

    private void viewID() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //For loop prints all ID's in arraylist.
            System.out.println(employees.get(i).getEmployeeID());
        }
        viewAllInstances();
    }

    private void viewStart() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //and start date
            System.out.println(employees.get(i).getEmployeeStartDate());
        }

        viewAllInstances();
    }

    private void viewPosition() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //and position
            System.out.println(employees.get(i).getEmployeePosition());
        }
        viewAllInstances();
    }
    private void viewEmail() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //and e-mail address.
            System.out.println(employees.get(i).getEmployeeEmailAddress());

        }
        viewAllInstances();
    }

    private void viewContactNumber() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //and contact number
            System.out.println(employees.get(i).getEmployeeContactNumber());
        }
        viewAllInstances();
    }

    private void viewPostCode() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //and postcode
            System.out.println(employees.get(i).getEmployeePostCode());
        }
        viewAllInstances();
    }
    private void viewCounty() { //and county
        getEmployees();
        for (int i = 0; i < employees.size(); i++) { //and county
            System.out.println(employees.get(i).getEmployeeCounty());
        }
        viewAllInstances();
    }

    private void viewCity() { //and city
        getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getEmployeeTownCity());
        }
        viewAllInstances();
    }



    private void viewAddress1() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getEmployeeAddress1());
        }

        viewAllInstances();
    }

    private void viewDob() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getEmployeeDateOfBirth());
        }
        viewAllInstances();
    }

    private void viewSurname() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getEmployeelastName());
        }

        viewAllInstances();

    }
    private void viewForenames() {
        getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getEmployeefirstName());

        }
        viewAllInstances();

    }
}



