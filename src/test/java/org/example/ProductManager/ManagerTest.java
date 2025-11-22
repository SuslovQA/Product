package org.example.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Smartphone product1 = new Smartphone(4, "Телефон1", 50_000, "aAa");
    Smartphone product2 = new Smartphone(6, "Телефон2", 74_990, "China");
    Book product3 = new Book(10, "Книга1", 990, "EugeneDev");
    Smartphone product4 = new Smartphone(1, "Телефон3", 100_999, "EugeneQA");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void shouldAdd() {
        manager.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldMatches() {
//        boolean expected = true;
//        boolean actual = manager.matches(product3, "Книга1");
//
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldNotMatches() {
//        boolean expected = false;
//        boolean actual = manager.matches(product1, "Книга1");
//    }

    @Test
    public void shouldSearchObject() {

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralObject() {

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("Телефон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayBeforeSearch() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Футболка");

        Assertions.assertArrayEquals(expected, actual);
    }
}
