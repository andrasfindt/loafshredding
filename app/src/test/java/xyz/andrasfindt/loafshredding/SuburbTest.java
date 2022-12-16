package xyz.andrasfindt.loafshredding;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuburbTest {
    @Test
    public void lineItemConstructor() {
        Suburb suburb = new Suburb("<li class=\"suburbListing\" value=\"73-1B\"><a>Cheltondale, </a></li>");
        assertEquals("73-1B", suburb.getCityPowerId());
        assertEquals("Cheltondale", suburb.getName());
    }
}