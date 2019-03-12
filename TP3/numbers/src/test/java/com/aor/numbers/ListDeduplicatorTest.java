package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list, new IListSorter() {
            @Override
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                list.add(5);
                return list;
            }
        });

        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);
    }
    @Test
    public void dedup2xd() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(expected);
        ListDeduplicator deduplicator = new ListDeduplicator(list,sorter);

        List<Integer> deduplicated = deduplicator.deduplicate();

        assertEquals(expected, deduplicated);
    }
}