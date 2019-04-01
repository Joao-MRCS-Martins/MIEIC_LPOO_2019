package com.aor.refactoring.example3;

public class nullDiscount implements Discount {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
