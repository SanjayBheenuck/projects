package Inheritance;
import java.util.Scanner;

public class car extends steeringWheel {

    Scanner myScanner = new Scanner(System.in);

    public car(short numberOfSeats, short numberOfWheels) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }

    public void carMenu() {
        System.out.println("Vroom Vroom, what would you like to do?");
        System.out.println("1 - Floor the accelerator");
        System.out.println("2 - Play it safe, hit the brake ");
        System.out.println("3 - Steer, there's a dog in the road");
        System.out.println("4 - Cars suck, I want another vehicle");
        int input = Integer.parseInt(myScanner.nextLine());

        switch (input) {
            case 1:
                accelerate();
                System.out.println("Wow that was fast, what's next");
                carMenu();
                break;

            case 2:
                brake();
                System.out.println("Good going, what now?");
                carMenu();
                break;

            case 3:
                steer("right");
                carMenu();
                break;

            case 4:
                return;


                default:
                    System.out.println("That's not option!");
                    carMenu();
                    break;

        }

    }
}
