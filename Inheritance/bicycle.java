package Inheritance;

import java.util.Scanner;

public class bicycle extends handlebars {

    Scanner myScanner = new Scanner(System.in);

    public bicycle(short numberOfSeats, short numberOfWheels) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }

    public void bikeMenu() {
        System.out.println("Hop on, what would you like to do?");
        System.out.println("1 - Pedal to the medal");
        System.out.println("2 - Hit the breaks");
        System.out.println("3 - Steer, a pothole!");
        System.out.println("4 - Bikes are for losers");
        int input = Integer.parseInt(myScanner.nextLine());

        switch (input) {
            case 1:
                accelerate();
                System.out.println("Wow that was fast, what's next");
                bikeMenu();
                break;

            case 2:
                brake();
                System.out.println("Good going, what now?");
                bikeMenu();
                break;

            case 3:
                steer("right");
                bikeMenu();
                break;

            case 4:

                return;

            default:
                System.out.println("That's not option!");
                bikeMenu();
                break;

        }

    }
}
