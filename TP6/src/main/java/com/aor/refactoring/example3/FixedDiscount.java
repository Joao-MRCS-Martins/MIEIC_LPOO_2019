package com.aor.refactoring.example3;

public class FixedDiscount implements Discount {
    private final int fixed;

    public FixedDiscount(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public double applyDiscount(double price) {
        if (fixed > 0 && fixed > price)
            return 0;
        else
            return price - fixed;
    }
}
