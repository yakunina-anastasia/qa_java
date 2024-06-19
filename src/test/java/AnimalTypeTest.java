package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class AnimalTypeTest {
    private Animal animal;
    private static final String UNKNOWN_ANIMAL_KIND = "Неизвестный вид";
    private static final String EXCEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Before
    public void startUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodExceptionTest() {
        Throwable throwable = catchThrowable(() -> {
            animal.getFood(UNKNOWN_ANIMAL_KIND);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(EXCEPTION);
    }

    @Test
    public void getFamilyTest() {
        String actual = animal.getFamily();

        assertEquals("Неверно",
                FAMILY, actual);
    }
}
