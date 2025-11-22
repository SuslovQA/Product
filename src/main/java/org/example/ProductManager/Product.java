package org.example.ProductManager;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean matches(String search) {
        return getName().contains(search);
    }

//    if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
////        return product.getName().contains(search);


//    Реализуйте в классе Product метод public boolean matches(String search), который определяет,
//    подходит ли продукт поисковому запросу исходя из названия.
//Переопределите этот метод в дочерних классах, чтобы они сначала вызывали родительский метод,
// и только если родительский метод вернул false, тогда проводили дополнительные проверки:
// Book — по автору, Smartphone — по производителю.
//Замените в менеджере вызов метода matches из класса самого менеджера на вызов метода matches у самих продуктов:
// if (product.matches(search)) {.
//Теперь вам нужны unit-тесты на методы ваших умных моделей, напишите их.
//Удостоверьтесь, что ранее написанные тесты на менеджера из решения задачи 1 проходят.
//Добейтесь 100% покрытия по бранчам методов с логикой.
//Заготовка для метода matches у класса Book:
//
//public class Book extends Product {
//  // ваши поля, конструкторы, методы
//
//}
}
