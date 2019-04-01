package com.aor.refactoring.example3;

import org.graalvm.compiler.api.replacements.Snippet;

public class SimpleOrder {
    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
        this.discount = new nullDiscount();
    }

    public void setDiscount(@Snippet.NonNullParameter Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {
            return discount.applyDiscount(price);
    }
}
