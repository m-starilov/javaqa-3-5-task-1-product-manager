package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private Book book;
    private Smartphone smartphone;
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] items = repository.findAll();
        Product[] foundItems = new Product[]{};
        for (Product item : items) {
            if (matches(item, text)) {
                int length = foundItems.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(foundItems, 0, tmp, 0, foundItems.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                foundItems = tmp;
            }
        }
        return foundItems;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search)) {
                return true;
            }
            if (smartphone.getManufacture().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
