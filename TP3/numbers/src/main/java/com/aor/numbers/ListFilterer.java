package com.aor.numbers;

import com.aor.numbers.IListFilter;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    List<Integer> list;
    public void ListFilterer (List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter) {
        List<Integer> filtered = new ArrayList<>();
        for(Integer num: list) {
            if(filter.accept(num)) {
                filtered.add(num);
            }
        }
        return filtered;
    }
}
