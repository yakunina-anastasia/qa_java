package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionSexTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private Lion lion;
    private Feline feline;
    private String sex;
    private boolean hasMane;

    @Before
    public void startUp() {
        feline = Mockito.mock(Feline.class);
    }

    public LionSexTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }
}
