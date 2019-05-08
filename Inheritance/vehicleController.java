package Inheritance;

import java.util.Scanner;

public class vehicleController {

    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        vehicleController vc = new vehicleController();
        vc.menu();


    }

    public void menu() {
        System.out.println("Which vehicle would you like to create today?");
        System.out.println("1 - Car");
        System.out.println("2 - Bus");
        System.out.println("3 - Truck ");
        System.out.println("4 - Train");
        System.out.println("5 - Motorcycle");
        System.out.println("6 - Bicycle");

        int input = Integer.parseInt(myScanner.nextLine());

        switch (input) {
            case 1:
                createCar();
                break;

            case 2:
                createBus();
                break;

            case 3:
                createTruck();
                break;

            case 4:
                createTrain();
                break;

            case 5:
                createMotorcycle();
                break;

            case 6:
                createBicicyle();
                break;

            default:
                System.out.println("There is no such vehicle! c'mom ");
                menu();
        }
    }

    private void createBicicyle() {
        bicycle bi = new bicycle((short) 1, (short) 2);
        bi.bikeMenu();
    }

    private void createMotorcycle() {
        motorbike m = new motorbike((short) 1, (short) 2);
        m.motorbikeMenu();
    }

    private void createTrain() {
        train tr = new train((short) 30, (short) 200);
        tr.accelerate();
        tr.steer(" right");
        tr.brake();
        menu();
    }

    private void createTruck() {
        truck t = new truck((short) 8, (short) 2);
       t.truckMenu();
    }

    private void createBus() {
        bus b = new bus((short) 4, (short) 20);
        b.busMenu();
    }

    public void createCar() {
        car c = new car((short) 5, (short) 4);

        c.carMenu();
        menu();
    }


}



