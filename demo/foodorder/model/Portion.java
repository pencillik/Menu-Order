package demo.foodorder.model;

public enum Portion {
    QUARTER(0.25),
    HALF(0.5),
    THREE_QUARTERS(.75),
    ONE(1),
    ONE_AND_HALF(1.5),
    DOUBLE(2);

    final double multiplier;

    Portion(double multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * gets the ordinal numbers of Portion enum class
     * @param ordinal is the order number of enum list starting from zero
     * @return ordinal number
     */
    public static Portion getTypeByOrdinal(int ordinal) {
        for (Portion t : Portion.values()) {
            if (t.ordinal() == ordinal) {
                return t;
            }
        }
        return null;
    }

    public double getMultiplier() {
        return multiplier;
    }
}


