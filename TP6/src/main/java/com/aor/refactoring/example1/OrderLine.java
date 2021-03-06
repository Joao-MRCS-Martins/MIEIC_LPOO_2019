package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    double getLineTotal() {
        return product.getPrice() * quantity;
    }

    public String toString() {
        return this.getProduct().getName() + "(x" + this.getQuantity() + "): " + (this.getLineTotal()) + "\n";
    }
}
