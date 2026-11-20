import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        boolean carStarted = false;
        String gear = "P";
        int speed = 0;
        int choice;

        while (true) {

            System.out.println("\n===== CAR SIMULATOR =====");
            System.out.println("1. Start the car");
            System.out.println("2. Select gear");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = keyboard.nextInt();

            switch (choice) {

                case 1:
                    if (!carStarted) {
                        carStarted = true;
                        System.out.println("Car started successfully!");
                    } else {
                        System.out.println("Car is already started.");
                    }
                    break;

                case 2:
                    if (carStarted) {
                        System.out.print("Select gear (P, D, R): ");
                        gear = keyboard.next().toUpperCase();

                        if (gear.equals("P") || gear.equals("D") || gear.equals("R")) {
                            System.out.println("Gear selected: " + gear);
                        } else {
                            System.out.println("Invalid gear!");
                            gear = "P";
                        }
                    } else {
                        System.out.println("Start the car first!");
                    }
                    break;

                case 3:
                    if (carStarted && (gear.equals("D") || gear.equals("R"))) {
                        speed += 10;
                        System.out.println("Accelerating...");
                        System.out.println("Current speed: " + speed + " km/h");
                    } else {
                        System.out.println("Start the car and select D or R first!");
                    }
                    break;

                case 4:
                    if (speed > 0) {
                        speed -= 10;

                        if (speed < 0) {
                            speed = 0;
                        }

                        System.out.println("Braking...");
                        System.out.println("Current speed: " + speed + " km/h");
                    } else {
                        System.out.println("The car is already stopped.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting simulator. Goodbye!");
                    keyboard.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }

