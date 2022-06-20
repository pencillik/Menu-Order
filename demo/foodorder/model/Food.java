package demo.foodorder.model;

public class Food {
    private final String name;
    private final int calories;
    private final int price;

    public Food(String name, int calories, int price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }
}
