package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void startUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
