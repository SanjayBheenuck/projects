package banking;

import java.util.Scanner;   //login details for ATM:
                                    //User: devacademy
public class user {                 //pin: 1234

    public double currentBalance;      //defining instance variables which hold account data.
    public double jointBalance;
    public double savingsBalance;


    Scanner myScanner = new Scanner(System.in);

    public static void main(String args[]) {
        user u = new user();
        u.login();
    }       //Calling scanner and defining main method


    private void login() { //Login method

        currentBalance = 1000;    //Assigning some values to the account data instance variables
        jointBalance = 3000;
        savingsBalance = 8000;


        String username = "devacademy";   //login "screen" requesting username and pin
        String pin = "1234";
        System.out.println("Please login ");
        System.out.println(" ");
        System.out.println("Enter username");
        String enterUser = myScanner.nextLine();
        System.out.println(" ");
        System.out.println("Enter pin:  ");
        String enterPin = myScanner.nextLine();

        if (enterUser.equals(username) && enterPin.equals(pin)) { //Returns to login if wrong,opens main menu if right
            openAtm();
        } else {
            login();
        }

    }

    private void openAtm() {

        System.out.println("Select account via number: ");   //Prompts account type or logout.
        System.out.println(" ");                                //Pushes to method for account type.
        System.out.println(" ");
        System.out.println("1.Current" + "\n" + "2.Joint" + "\n" + "3.Savings" + "\n"+ "4.logout");
        String accountSelect = myScanner.nextLine();
        if (accountSelect.equalsIgnoreCase("1")) {
            currentMenu();
        } else if (accountSelect.equalsIgnoreCase("2")) {
            jointMenu();
        } else if (accountSelect.equalsIgnoreCase("3")) {
            savingsMenu();
        } else if (accountSelect.equalsIgnoreCase("4")){
            login();   //Back to login if selecting logout
        }

    }

    private void currentMenu() {  //Menu for current, options for withdraw, deposit, transfer, logout.
        System.out.println("What would you like to do, select number :");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1.View balance" + "\n" + "2.Withdraw" + "\n" + "3.Deposit" + "\n" + "4.Transfer" + "\n \n"+ "any other key to logout");
        String savingsSelect = myScanner.nextLine();
        if (savingsSelect.equalsIgnoreCase("1")) {
            System.out.println("Your balance is:  " + currentBalance);
            System.out.println("Goodbye: ");
            login();


        } else if (savingsSelect.equalsIgnoreCase("2")) {
            System.out.println("enter amount: ");
            double withdraw = myScanner.nextDouble();
            currentBalance = currentBalance - withdraw;  //Value manipulations for options 1-3
            System.out.println(" ");
            System.out.println("Your new balance is:  " + currentBalance);
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();


        } else if (savingsSelect.equalsIgnoreCase("3")) {
            System.out.println("enter amount: ");
            double deposit = myScanner.nextDouble();
            currentBalance = currentBalance + deposit;
            System.out.println(" ");
            System.out.println("your new balance is:  " + currentBalance);
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();

        } else if (savingsSelect.equalsIgnoreCase("4")) {

            transferMenu(); //if the user selects transfer they are pushed to a new method, as this is more complex.

        } else {
            login(); //logout returns to start.
        }

    }


    private void jointMenu() {  //implementation here is same as method above
        System.out.println("What would you like to do, select number: ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1.View balance" + "\n" + "2.Withdraw" + "\n" + "3.Deposit" + "\n" + "4.Transfer"+ "\n\n"+ "any other key to logout");
        String jointSelect = myScanner.nextLine();
        if (jointSelect.equalsIgnoreCase("1")) {
            System.out.println("Your balance is: " + jointBalance);
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();

        } else if (jointSelect.equalsIgnoreCase("2")) {
            System.out.println("enter amount: ");
            double withdraw = myScanner.nextDouble();
            jointBalance = jointBalance - withdraw;
            System.out.println(" ");
            System.out.println("Your new balance is:  " + jointBalance);
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();


        } else if (jointSelect.equalsIgnoreCase("3")) {
            System.out.println("enter amount: ");
            double deposit = myScanner.nextDouble();
            jointBalance = jointBalance + deposit;
            System.out.println(" ");
            System.out.println("your new balance is:  " + jointBalance);
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();

        } else if (jointSelect.equalsIgnoreCase("4")) {
            transferMenu();
        } else {
            login();
        }
    }

    private void savingsMenu() { //implementation here is same as method above
        System.out.println("What would you like to do, select number: ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1.View balance" + "\n" + "2.Withdraw" + "\n" + "3.Deposit" + "\n" + "4.Transfer"+ "\n\n"+ "any other key to logout");
        String jointSelect = myScanner.nextLine();
        if (jointSelect.equalsIgnoreCase("1")) {
            System.out.println("Your balance is: " + savingsBalance);
            System.out.println(" ");
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();
        } else if (jointSelect.equalsIgnoreCase("2")) {
            System.out.println("enter amount: ");
            double withdraw = myScanner.nextDouble();
            savingsBalance = savingsBalance - withdraw;
            System.out.println(" ");
            System.out.println("Your new balance is:  " + savingsBalance);
            System.out.println(" ");
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();

        } else if (jointSelect.equalsIgnoreCase("3")) {
            System.out.println("enter amount: ");
            double deposit = myScanner.nextDouble();
            savingsBalance = savingsBalance + deposit;
            System.out.println(" ");
            System.out.println("your new balance is: " + savingsBalance);
            System.out.println(" ");
            System.out.println("Goodbye:");
            System.out.println(" ");
            login();

        } else if (jointSelect.equalsIgnoreCase("4")) {
            transferMenu();
        } else {
            login();
        }


    }

    private void transferMenu() { //transfer method handles logic for transfer calculations by comparing strings..
                                    //And by +/- instance account variables via a series of if statements.
        System.out.println("From which account? (type name)");
        String accountFrom = myScanner.nextLine();
        System.out.println(" ");              ///These questions prompt account to/from and transfer value.
        System.out.println("To which account?(type name)");
        String accountTransfer = myScanner.nextLine();
        System.out.println(" ");
        System.out.println("How much would you like to transfer? (type amount)");
        double transferValue = myScanner.nextDouble();

        if (accountFrom.equalsIgnoreCase("Current") && accountTransfer.equalsIgnoreCase("joint")) {
            currentBalance = currentBalance - transferValue;
            jointBalance = jointBalance + transferValue;    //the above if statements, compares strings determine this calculation
            System.out.println(" ");
            System.out.println("your new balance is: ");
            System.out.println("Current:" + currentBalance + "\n" + "Joint: " + jointBalance);
            System.out.println(" ");
            System.out.println("Goodbye");
            login();


        } else if (accountFrom.equalsIgnoreCase("current") && accountTransfer.equalsIgnoreCase("savings")) {
            currentBalance = currentBalance - transferValue;
            savingsBalance = savingsBalance + transferValue; //As above the if statements generates this calculation, changing account values.
            System.out.println(" ");
            System.out.println("your new balance is: ");
            System.out.println("Current:" + currentBalance + "\n" + "Savings: " + savingsBalance);
            System.out.println(" ");
            System.out.println("Goodbye");
            login();

        } else if (accountFrom.equalsIgnoreCase("savings") && accountTransfer.equalsIgnoreCase("current")) {
            savingsBalance = savingsBalance - transferValue;
            currentBalance = currentBalance + transferValue;
            System.out.println(" ");
            System.out.println("your new balance is: ");
            System.out.println("Savings:" + savingsBalance + "\n" + "current: " + currentBalance);
            System.out.println(" ");
            System.out.println("Goodbye");
            login();

        } else if (accountFrom.equalsIgnoreCase("savings") && accountTransfer.equalsIgnoreCase("joint")) {
            savingsBalance = savingsBalance - transferValue;
            jointBalance = jointBalance + transferValue;   //else if statement is same above, comparing different string combinations
            System.out.println(" ");
            System.out.println("your new balance is: ");
            System.out.println("Savings: " +savingsBalance+ "current: " +currentBalance );
            System.out.println(" ");
            System.out.println("Goodbye");
            login();


        } else if (accountFrom.equalsIgnoreCase("joint") && accountTransfer.equalsIgnoreCase("current")) {
            jointBalance = jointBalance - transferValue;
            currentBalance = currentBalance + transferValue;
            System.out.println(" ");
            System.out.println("your new balance is: ");
            System.out.println("Joint:" + jointBalance + "\n" + "Current: " + currentBalance);
            System.out.println("Goodbye");
            login();

        } else if (accountFrom.equalsIgnoreCase("joint") && accountTransfer.equalsIgnoreCase("savings")) {
            jointBalance = jointBalance - transferValue;
            savingsBalance = savingsBalance + transferValue;
            System.out.println(" ");
            System.out.println("your new balance is: ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Joint:" + jointBalance + "\n" + "Savings: " + savingsBalance);
            System.out.println("Goodbye");
            login(); //return to login screen
        }

    }




}

