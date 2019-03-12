package com.aor.numbers;
import java.util.ArrayList;
import java.util.List;

/**
 * An utility class that removes duplicate numbers
 * from a list.6
 */
public class ListDeduplicator implements IListDeduplicator {
    private final List<Integer> list;
    private IListSorter sorter;

    public ListDeduplicator(List<Integer> list, IListSorter sorter) {
        this.list = list;
        this.sorter = sorter;
    }

    /**
     * Removes duplicate numbers from a list.
     * @return A list having the same numbers as the original
     * but without duplicates. The order of the numbers might
     * change.
     */
    public List<Integer> deduplicate() {
        List<Integer> sorted = sorter.sort();
        List<Integer> unique = new ArrayList<>();

        Integer last = null;

        for (Integer number : sorted)
            if (!number.equals(last)) {
                last = number;
                unique.add(number);
            }

        return unique;
    }

}
