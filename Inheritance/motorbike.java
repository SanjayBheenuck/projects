package Inheritance;

import java.util.Scanner;

public class motorbike extends handlebars {

    Scanner myScanner = new Scanner(System.in);

    public motorbike(short numberOfSeats, short numberOfWheels) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }

    public void motorbikeMenu() {
        System.out.println("let's haul ass to lollapalooza");
        System.out.println("1 - Accelerate");
        System.out.println("2 - Break, baby");
        System.out.println("3 - Steer, a pothole!");
        System.out.println("4 - Gimmie something else");
        int input = Integer.parseInt(myScanner.nextLine());

        switch (input) {
            case 1:
                accelerate();
                System.out.println("Wow that was fast, what's next");
                motorbikeMenu();
                break;

            case 2:
                brake();
                System.out.println("Good going, what now?");
                motorbikeMenu();
                break;

            case 3:
                steer("left");
                motorbikeMenu();
                break;

            case 4:
return;


            default:
                System.out.println("That's not option!");
                motorbikeMenu();
                break;

        }
    }
}
