package com.aor.numbers;

public class DivisibleByFilter {
    Integer num;
    public void DivisibleByFilter(Integer num) implements IListFilter {
        this.num = num;
    }
    @Override
    public boolean accept(Integer num) {
        return num % this.num;
    }

}
