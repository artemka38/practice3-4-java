package ru.edu.pr01;

public class OrderCalculator {
    private static final double MAX_DISCOUNT_PERCENT = 15.0;
    private static final double MIN_DISCOUNT_PERCENT = 0.0;
    private static final double MAX_QUANTITY = 10_000.0;
    private static final double MAX_UNIT_PRICE = 5_000_000.0;
    private static final double MIN_QUANTITY = 0;
    private static final double MIN_UNIT_PRICE = 0.0;
    public static boolean isValid(int quantity, double unitPrice, double discountPercent) {
        return quantity > MIN_QUANTITY
                && quantity <= MAX_QUANTITY
                && unitPrice > MIN_UNIT_PRICE
                && unitPrice <= MAX_UNIT_PRICE
                && discountPercent >= MIN_DISCOUNT_PERCENT
                && discountPercent <= MAX_DISCOUNT_PERCENT;
    }
    public static double calculateBase(int quantity, double unitPrice) {
        return quantity * unitPrice;
    }
    public static double applyDiscount(double base, double discountPercent) {
        return base * (1.0 - discountPercent / 100.0);
    }
    public static double calculateVat(double discounted, double vatPercent) {
        return discounted * vatPercent / 100.0;
    }
    public static double calculateTotal(int quantity, double unitPrice, double discountPercent, double vatPercent) {
        double base = calculateBase(quantity, unitPrice);
        double discounted = applyDiscount(base, discountPercent);
        return discounted + calculateVat(discounted, vatPercent);
    }
}