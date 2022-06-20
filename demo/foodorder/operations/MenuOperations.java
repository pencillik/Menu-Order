package demo.foodorder.operations;

import demo.foodorder.Main;
import demo.foodorder.model.Food;
import demo.foodorder.model.FoodOrder;
import demo.foodorder.model.Portion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuOperations {
    List<FoodOrder> basket = new ArrayList<>();
    private static final List<Food> foodList = new ArrayList<>() {
        {
        add(new Food("Ezogelin Soup", 91, 19));
        add(new Food("Tomato Soup", 68, 18));
        add(new Food("Lentil Soup", 60, 25));
        add(new Food("Rice", 24, 21));
        add(new Food("Bulgur", 149, 17));
        add(new Food("Buckwheat", 317, 40));
        add(new Food("Sauteed Meat", 225, 65));
        add(new Food("Sauteed Chicken", 288, 41));
        add(new Food("Moussaka", 192, 50));
        add(new Food("Baklava", 350, 38));
        }
    };

    private static final List<String> menuOptions = new LinkedList<>() {
        {
        add("1 - View Food List");
        add("2 - View Basket");
        add("3 - Empty Basket");
        add("4 - Exit");
        }
    };

    public void displayMenu() {
        printLine("______________________________\n- Welcome to adesso Deli -\n");
        menuOptions.forEach(System.out::println);
    }

    /**
     * get the option input from the user
     * @return menu option number entered by user
     */
    public int getOption() {
        print("Option: ");
        int option = 1;
        // bError is boolean variable created in order to make it sure that the user only entered integer numbers
        boolean bError = true;
        while (bError) {
            if (Main.scanner.hasNextInt()) {
                option = Main.scanner.nextInt();
                if (option < 1 || option > 4) {
                    do {
                        printLine("Warning: Please select again only from the listed options!");
                        print("Option: ");
                        option = Main.scanner.nextInt();
                    } while (option < 1 || option > 4);
                }
            } else {
                printLine("Warning: Please select only from list with numeric values.");
                print("Option: ");
                Main.scanner.next();
                continue;
            }
            bError = false;
        }
        printLine("");
        return option;
    }

    /**
     * displays the food list
     */
    public void displayList() {
        printLine("______________________________\n- Food List -\n");
        for (int i = 0; i < foodList.size(); i++) {
            printLine(i + 1 + " - " + foodList.get(i).getName() + " - " + foodList.get(i).getPrice() + " TL");
        }
    }

    /**
     * adds the selected food from the food list into the user basket
     */
    public void insertFood() {
        Food fn = foodNumber();
        int oa = orderAmount();
        Portion p = portion();
        FoodOrder order = new FoodOrder();
        order.setFood(fn);
        order.setPortion(p);
        order.setAmount(oa);
        basket.add(order);
        printLine("\nInfo: Selected food(s) has been added to your basket.");
    }

    /**
     * it's for getting the order amount from user after user chooses the food from food list
     * @return the number of amount user wants for selected food
     */
    private int orderAmount() {
        print("Order Amount: ");
        int i = 0;
        // bError is boolean variable created in order to make it sure that the user only entered integer numbers
        boolean bError = true;
        while (bError) {
            if (Main.scanner.hasNextInt())
                i = Main.scanner.nextInt();
            else {
                printLine("Warning: Please type only numeric values.");
                print("Order Amount: ");
                Main.scanner.next();
                continue;
            }
            bError = false;
        }
        return i;
    }

    /**
     * lets user choose serving size for the food selected
     * @return the portion name from enum class
     */
    private Portion portion() {
        int i = 1;
        print("~~~Portion Options - Type the corresponding number~~~\n");
        for (Portion myVar : Portion.values()) {
            printLine(i + " - " + myVar);
            i++;
        }
        print("Portion: ");
        int portionNumber = 1;
        // bError is boolean variable created in order to make it sure that the user only entered integer numbers
        boolean bError = true;
        while (bError) {
            if (Main.scanner.hasNextInt()) {
                portionNumber = Main.scanner.nextInt();
                if (portionNumber < 1 || portionNumber > 6) {
                    do {
                        printLine("Warning: Please select again only from the listed options!");
                        print("Portion: ");
                        portionNumber = Main.scanner.nextInt();
                    } while (portionNumber < 1 || portionNumber > 6);
                }
                } else {
                printLine("Warning: Please select only from list with numeric values.");
                print("Portion: ");
                Main.scanner.next();
                continue;
                }
            bError = false;
        }
        return Portion.getTypeByOrdinal(portionNumber - 1);
    }

    /**
     * lets user choose desired food from the foods numbered in the food list
     * @return corresponding food number
     */
    private Food foodNumber() {
        print("Select Food Number: ");
        int num = 1;
        boolean bError = true;
        while (bError) {
            if (Main.scanner.hasNextInt()) {
                num = Main.scanner.nextInt();
                if (num < 1 || num > 10) {
                    do {
                        printLine("Error: There is no food with that number.");
                        print("Select Food Number: ");
                        num = Main.scanner.nextInt();
                    } while (num < 1 || num > 10);
                }
            } else {
                printLine("Warning: Please select only from list with numeric values.");
                print("Select Food Number: ");
                Main.scanner.next();
                continue;
            }
            bError = false;
        }
        return foodList.get(num - 1);
    }

    /**
     * empties the basket
     */
    public void emptyBasket() {
        basket.clear();
        printLine("Info: Your basket has been emptied.");
    }

    /**
     * displays the basket with additional information
     */
    public void displayBasket() {
        double totalCaloriesInBasket = 0;
        double totalPriceInBasket = 0;
        int numberOfFoods = 0;
        printLine("______________________________\n- Your Basket -\n");
        for (FoodOrder fo : basket) {
            printLine(fo.getAmount() + " " + fo.getFood().getName() + " - " + fo.getPortion() + " serving");
            totalCaloriesInBasket += fo.getFood().getCalories() * fo.getPortion().getMultiplier()*fo.getAmount();
            totalPriceInBasket += fo.getPortion().getMultiplier() * fo.getFood().getPrice() * fo.getAmount();
            numberOfFoods += fo.getAmount();
        }
        if (numberOfFoods == 0) {
            printLine("There is nothing to show here.");
        } else {
            printLine("");
            printLine("Your basket consists of " + numberOfFoods + " food(s).");
            printLine("You'll get " + totalCaloriesInBasket + " calories and pay " + totalPriceInBasket + " TL.");
        }
    }

    /**
     * prints the input with new line at the end
     * @param text the input
     */
    private void printLine(String text) {
        System.out.println(text);
    }

    /**
     * prints the input in-line
     * @param text the input
     */
    private void print(String text) {
        System.out.print(text);
    }
}