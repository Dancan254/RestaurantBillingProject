package BillingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static double totalCost = 0;
    private static final double BURGER_PRICE = 100;
    private static final double SMOKIES_PRICE = 200;
    private static final double CHIPS_PLAIN_PRICE = 250;
    private static final double CHIPS_KUKU_PRICE = 300;

    public static void main(String[] args) {
        displayMenu();
        deliverOrder();
    }

    /**
     * Displays the restaurant menu
     */
    public static void displayMenu() {
        System.out.println("\t\tWelcome to Our Restaurant");
        System.out.println("\n\tRestaurant Menu");
        System.out.println("1. Burger - $100");
        System.out.println("2. Smokies - $200");
        System.out.println("3. Chips Plain - $250");
        System.out.println("4. Chips Kuku - $300");
        System.out.println("______________________");
    }

    /**
     * Returns user input as an integer
     */
    public static int getUserChoice() {
        int choice;
        while (true){

            try {
                System.out.println("Place your order (Enter the item number):");
                choice =  scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid choice try again");
                scanner.nextLine();
            }
        }
        return choice;
    }

    /**
     * Perform operations based on user choice
     */
    public static void deliverOrder() {
        int choice = getUserChoice();

        switch (choice) {
            case 1 -> orderBurger();
            case 2 -> orderSmokies();
            case 3 -> orderChips(CHIPS_PLAIN_PRICE);
            case 4 -> orderChips(CHIPS_KUKU_PRICE);
            default -> {
                System.out.println("Invalid choice. Please select a valid menu item.");
                deliverOrder();
            }
        }
    }

    /**
     * Order burgers
     */
    public static void orderBurger() {
        System.out.println("You have selected Burger");
        while (true) {
            try {
                System.out.println("How many burgers do you want?");
                int quantity = scanner.nextInt();
                totalCost = quantity * BURGER_PRICE;
                System.out.println("Total price is: $" + totalCost);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
                scanner.next();
            }
        }
        continueShopping();
    }

    /**
     * Order smokies
     */
    public static void orderSmokies() {
        System.out.println("You have selected Smokies");
        while (true) {
            try {
                System.out.println("How many smokies do you want?");
                int quantity = scanner.nextInt();
                totalCost = quantity * SMOKIES_PRICE;
                System.out.println("Total price is: $" + totalCost);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
                scanner.next();
            }
        }
        continueShopping();
    }

    /**
     * Order chips
     */
    public static void orderChips(double price) {
        System.out.println("You have selected Chips");
        while (true) {
            try {
                System.out.println("How many packets of chips do you want?");
                int quantity = scanner.nextInt();
                totalCost = quantity * price;
                System.out.println("Total price is: $" + totalCost);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
                scanner.next();
            }
        }
        continueShopping();
    }

    /**
     * Continue shopping or exit
     */
    public static void continueShopping() {
        System.out.println("Do you still want to buy something? Enter 'Y' (yes) or 'N' (no):");
        String shop = scanner.next();
        if (shop.equalsIgnoreCase("Y")) {
            displayMenu();
            deliverOrder();
        } else if (shop.equalsIgnoreCase("N")) {
            System.out.println("Thank you for dining with us. Your total bill is: $" + totalCost);
            System.out.println("Have a great day!");
        } else {
            System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
            continueShopping();
        }
    }

    public static void getTotal(){

    }
}
