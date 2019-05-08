package Inheritance;

import java.util.Scanner;

public class truck extends steeringWheel {


    Scanner myScanner = new Scanner(System.in);

    public truck(short numberOfSeats, short numberOfWheels) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }

    public void truckMenu() {
        System.out.println("Well, we rolled up Interstate 44\n" +
                "Like a rocket sled on rails.");
        System.out.println("1 - Accelerate baby!");
        System.out.println("2 - Let's break");
        System.out.println("3 - Steer.");
        System.out.println("4 - I want another vehicle");
        int input = Integer.parseInt(myScanner.nextLine());

        switch (input) {
            case 1:
                accelerate();
                System.out.println("We're gonna be on time for this job!");
                truckMenu();
                break;

            case 2:
                brake();
                System.out.println("Good going, what now?");
                truckMenu();
                break;

            case 3:
                steer("right");
                truckMenu();
                break;

            case 4:
                return;


            default:
                System.out.println("That's not option!");
                truckMenu();
                break;

        }
    }

}
