package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product firstBook = new Book(1, "Mastering SolidWorks", 6246, "Matt Lombard");
    private Product secondBook = new Book(2, "Изучаем Python. Программирование игр, визуализация данных, веб-приложения", 550, "Эрик Мэтиз");
    private Product thirdBook = new Book(3, "Чистая архитектура. Искусство разработки программного обеспечения", 499, "Роберт Мартин");
    private Product fourthBook = new Book(4, "Грокаем алгоритмы. Иллюстрированное пособие для программистов и любопытствующих", 550, "Адитья Бхаргава");
    private Product fifthBook = new Book(5, "Программирование на Python в примерах и задачах", 550, "Алексей Васильев");
    private Product firstSmartphone = new Smartphone(1, "iPhone 12 128GB, синий", 82480, "Apple");
    private Product secondSmartphone = new Smartphone(2, "iPhone 12 64GB, синий", 74480, "Apple");
    private Product thirdSmartphone = new Smartphone(3, "iPhone 12 Pro 512GB, серебристый", 129980, "Apple");
    private Product fourthSmartphone = new Smartphone(4, "Samsung Galaxy A12 3/32GB, черный", 11990, "Samsung");
    private Product fifthSmartphone = new Smartphone(5, "Samsung Galaxy S10 8/128GB, оникс", 46990, "Samsung");
    private Product firstProduct = new Product(0,"Не книга и не смартфон",0);

    @Test
    public void shouldNotFindProductFromZero() {
        manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("Python");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProductFromOne() {
        manager = new ProductManager(repository);
        manager.add(firstBook);

        Product[] actual = manager.searchBy("Python");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProductFromThree() {
        manager = new ProductManager(repository);
        manager.add(firstBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);

        Product[] actual = manager.searchBy("Python");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductFromOne() {
        manager = new ProductManager(repository);
        manager.add(secondBook);

        Product[] actual = manager.searchBy("Python");
        Product[] expected = new Product[]{secondBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductFromFive() {
        manager = new ProductManager(repository);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);

        Product[] actual = manager.searchBy("Matt Lombard");
        Product[] expected = new Product[]{firstBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoProductsFromThree() {
        manager = new ProductManager(repository);
        manager.add(secondBook);
        manager.add(fifthBook);
        manager.add(secondSmartphone);

        Product[] actual = manager.searchBy("Python");
        Product[] expected = new Product[]{secondBook, fifthBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindThreeProductsFromTen() {
        manager = new ProductManager(repository);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
        manager.add(fourthSmartphone);
        manager.add(fifthSmartphone);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone, thirdSmartphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProduct() {
        manager = new ProductManager(repository);
        manager.add(firstProduct);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}
