package demo.foodorder.model;

public class FoodOrder {
    private Food food;
    private Portion portion;
    private int amount;

    public FoodOrder() {
    }

    public FoodOrder(Food food, Portion portion, int amount) {
        this.food = food;
        this.portion = portion;
        this.amount = amount;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Portion getPortion() {
        return portion;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}