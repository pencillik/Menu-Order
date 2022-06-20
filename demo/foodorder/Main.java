package demo.foodorder;

import demo.foodorder.operations.MenuOperations;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuOperations m = new MenuOperations();
        do {
            m.displayMenu();
            int option = m.getOption();
            if (option == 1) {
                m.displayList();
                m.insertFood();
            } else if (option == 2) {
                m.displayBasket();
            } else if (option == 3) {
                m.emptyBasket();
            } else if (option == 4) {
                System.out.println("Exiting...");
                break;
            }
        } while (true);
    }
}