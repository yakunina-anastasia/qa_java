package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetFoodTest {
    private Animal animal;
    private static final String ANIMAL_KIND_HERBIVORE = "Травоядное";
    private static final String ANIMAL_KIND_PREDATOR = "Хищник";
    private static final List<String> FOOD_HERBIVORE = List.of("Трава", "Различные растения");
    private static final List<String> FOOD_PREDATOR = List.of("Животные", "Птицы", "Рыба");

    private String animalKind;
    private List<String> food;

    public GetFoodTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {ANIMAL_KIND_HERBIVORE, FOOD_HERBIVORE},
                {ANIMAL_KIND_PREDATOR, FOOD_PREDATOR}
        };
    }

    @Before
    public void startUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals("Неверный список еды",
                food, actual);
    }
}
