package org.example.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Book product1 = new Book(1, "Книга1", 110, "EugeneQA");
    Smartphone product2 = new Smartphone(2, "N70", 29_999, "Nokla");

    @Test
    public void shouldSearchByAuthor() {
        boolean expected = true;
        boolean actual = product1.matches("EugeneQA");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        boolean expected = true;
        boolean actual = product2.matches("Nokla");

        Assertions.assertEquals(expected, actual);
    }
}
