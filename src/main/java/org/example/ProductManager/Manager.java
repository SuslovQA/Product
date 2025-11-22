package org.example.ProductManager;

public class Manager {
    protected Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getProducts()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
