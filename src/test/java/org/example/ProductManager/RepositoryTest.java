package org.example.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();

    Product product1 = new Book(1, "Книга1", 110, "EugeneQA");
    Product product2 = new Smartphone(2, "N70", 29_999, "Nokla");
    Product product3 = new Book(3, "Книга2", 799, "EugeneDev");


    @Test
    public void shouldSaveProduct() {
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);

        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }
}
