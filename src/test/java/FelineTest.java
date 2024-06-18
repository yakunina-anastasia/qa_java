package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private final String expected = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT = 1;
    private int kittensCount = 3;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Неверное семейство",
                expected, actual);
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(EXPECTED_KITTENS_COUNT);

        assertEquals("Неверное количество котят",
                EXPECTED_KITTENS_COUNT, actual);
    }

    @Test
    public void kittensCountTest() {
        int actual = feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals("Неверное количество котят",
                kittensCount, actual);
    }
}
