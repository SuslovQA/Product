package org.example.ProductManager;

public class Repository {
    protected Product[] product = new Product[0];

    public void saveProduct(Product item) {
        Product[] tmp = new Product[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        tmp[tmp.length - 1] = item;
        product = tmp;
    }

    public Product[] getProducts() {
        return product;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[product.length - 1];
        int copyToIndex = 0;

        for (Product item : product) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        product = tmp;
    }
}
