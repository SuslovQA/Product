package org.example.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();

    Book product1 = new Book(1, "Книга1", 110, "EugeneQA");
    Smartphone product2 = new Smartphone(2, "N70", 29_999, "Nokla");
    Book product3 = new Book(3, "Книга2", 799, "EugeneDev");
    Smartphone product4 = new Smartphone(2, "T1000", 5999, "Suslov");

    @BeforeEach
    public void setup() {
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
    }

    @Test
    public void shouldSaveProduct() {
        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionNotFoundWithNegativeId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-10);
        });
    }

    @Test
    public void shouldThrowExceptionNotFoundWithAboveId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    public void shouldThrowExceptionAlreadyExist() {
        Assertions.assertThrows(AlreadyExistException.class, () -> {
            repo.saveProduct(product4);
        });
    }
}
