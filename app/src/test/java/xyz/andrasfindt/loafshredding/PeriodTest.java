package xyz.andrasfindt.loafshredding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeriodTest {

    @Test
    public void nameWithStartAndEnd() {
        Period fromTableString = Period.createFromTableString("6A \t4B \t2A \t8A \t6B \t4A\t2B \t8B\t7A \t5B\t3A \t1B \t7B \t5A \t3B \t1A \t8A \t6B \t4A \t2B \t8B \t6A \t4B \t2A \t1B \t7B \t5A \t3B \t1A \t7A \t5B", "1:00", "2:00");
        System.out.println(fromTableString);
    }

    @Test
    public void nameWithoutStartAndEnd() {
        Period fromTableString = Period.createFromTableString("8:00\t12:30\t7A \t5B \t3A \t1B \t7B \t5A\t3B \t1A\t8A \t6B\t4A \t2B \t8B \t6A \t4B \t2A \t1B \t7B \t5A \t3B \t1A \t7A \t5B \t3A \t2B \t8B \t6A \t4B \t2A \t8A \t6B");
        System.out.println(fromTableString);
        assertEquals("8:00", fromTableString.getStart());
        assertEquals("12:30", fromTableString.getEnd());
        assertEquals(31, fromTableString.getBlocks().size());
    }
}