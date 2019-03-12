package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    List<Integer> list;
    @Before
    public void listSetup() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }
    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new IListDeduplicator() {
           @Override
           public List<Integer> deduplicate() {
               list = new ArrayList<>();
               list.add(1);
               list.add(2);
               list.add(4);
               list.add(5);
               return list;
           }
       });

        assertEquals(4, distinct);
    }
    @Test
    public void max_negatives() {
        List<Integer> list2 = new ArrayList<>();
        list2.add(-1);
        list2.add(-5);
        list2.add(-4);

        ListAggregator aggregator = new ListAggregator(list2);

        int max = aggregator.max();
        assertEquals(-1,max);
    }
    @Test
    public void distinct_agreg_test() {
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate()).thenReturn(expected);
        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3, distinct);
    }


}