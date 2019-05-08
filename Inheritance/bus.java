package Inheritance;

import java.util.Scanner;

public class bus extends steeringWheel {

    Scanner myScanner = new Scanner(System.in);

    public bus(short numberOfSeats, short numberOfWheels) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }

    public void busMenu() {
        System.out.println("Ahh the bus, chariot of the poor and the very poor alike, what would you like to do?");
        System.out.println("1 - Let's go!");
        System.out.println("2 - Break!!");
        System.out.println("3 - Steer...");
        System.out.println("I want another vehicle");
        int input = Integer.parseInt(myScanner.nextLine());

        switch (input) {
            case 1:
                accelerate();
                System.out.println("Safe and efficient public transport, good huh?");
                busMenu();
                break;

            case 2:
                brake();
                System.out.println("We're okay, what now?");
                busMenu();
                break;

            case 3:
                steer("reverse");
                busMenu();
                break;

            case 4:
                return;


            default:
                System.out.println("That's not option!");
                busMenu();
                break;

        }


    }

}