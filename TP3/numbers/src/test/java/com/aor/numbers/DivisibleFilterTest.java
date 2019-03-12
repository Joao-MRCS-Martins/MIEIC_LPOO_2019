package com.aor.numbers;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivisibleFilterTest {
    @Test
    public void divisible() {
        DivisibleByFilter f1 = new DivisibleByFilter(2);
        DivisibleByFilter f2 = new DivisibleByFilter(1);
        assertTrue(f1.accept(2));
        assertTrue(f1.accept(8));
        assertFalse(f1.accept(3));
        assertTrue(f2.accept(8));
        assertTrue(f2.accept(9));
        assertTrue(f2.accept(10));
    }
}
