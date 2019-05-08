package Inheritance;

import java.util.Scanner;

public class train extends vehicle {

    Scanner myScanner = new Scanner(System.in);

    public train(short numberOfSeats, short numberOfWheels){
        this.numberOfSeats = numberOfSeats;
        this.numberOfWheels = numberOfWheels;
    }

    public void steer(String dir){
        System.out.println("I don't need to do anything "+ "to turn" +dir+ ", I just follow the tracks.");
    }
}
