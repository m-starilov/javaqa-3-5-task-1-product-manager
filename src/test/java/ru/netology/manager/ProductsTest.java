package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsTest {
    private Product firstBook = new Book(1, "Mastering SolidWorks", 6246, "Matt Lombard");
    private Product secondBook = new Book(2, "Изучаем Python. Программирование игр, визуализация данных, веб-приложения", 550, "Эрик Мэтиз");
    private Product thirdBook = new Book(3, "Чистая архитектура. Искусство разработки программного обеспечения. 2018", 499, "Роберт Мартин");
    private Product fourthBook = new Book(4, "Грокаем алгоритмы. Иллюстрированное пособие для программистов и любопытствующих. 2020", 550, "Адитья Бхаргава");
    private Product fifthBook = new Book(5, "Программирование на Python в примерах и задачах", 550, "Алексей Васильев");
    private Product firstSmartphone = new Smartphone(1, "iPhone 12 128GB, синий", 82480, "Apple");
    private Product secondSmartphone = new Smartphone(2, "iPhone 12 64GB, синий", 74480, "Apple");
    private Product thirdSmartphone = new Smartphone(3, "iPhone 12 Pro 512GB, серебристый", 129980, "Apple");
    private Product fourthSmartphone = new Smartphone(4, "Galaxy A12 3/32GB, черный", 11990, "Samsung");
    private Product fifthSmartphone = new Smartphone(5, "Galaxy S10 8/128GB, оникс", 46990, "Samsung");
    private Product firstProduct = new Product(1, "Упаковка", 10);
    private Product secondProduct = new Product(2, "Упаковка подарочная", 10);
    private Product thirdProduct = new Product(3, "Сертификат 1000 рублей", 1000);
    private Product fourthProduct = new Product(4, "Сертификат 5000 рублей", 5000);

    @Test
    public void shouldFindProductByLetterName() {
        assertTrue(firstBook.matches("SolidWorks"));
        assertTrue(secondBook.matches("Программирование"));
        assertTrue(firstSmartphone.matches("iPhone"));
        assertTrue(secondSmartphone.matches("синий"));
        assertTrue(firstProduct.matches("Упаковка"));
        assertTrue(secondProduct.matches("Упаковка"));
    }

    @Test
    public void shouldFindProductByDigitName() {
        assertTrue(thirdBook.matches("2018"));
        assertTrue(fourthBook.matches("2020"));
        assertTrue(thirdSmartphone.matches("512"));
        assertTrue(fourthSmartphone.matches("12"));
        assertTrue(thirdProduct.matches("1000"));
        assertTrue(fourthProduct.matches("5000"));
    }

    @Test
    public void shouldFindProductByAdditionalFields() {
        assertTrue(thirdBook.matches("Роберт Мартин"));
        assertTrue(fourthBook.matches("Адитья Бхаргава"));
        assertTrue(fifthBook.matches("Алексей Васильев"));
        assertTrue(thirdSmartphone.matches("Apple"));
        assertTrue(fourthSmartphone.matches("Samsung"));
        assertTrue(fifthSmartphone.matches("Samsung"));
    }

    @Test
    public void shouldNotFindProduct() {
        assertFalse(firstBook.matches("MasteringSolidWorks"));
        assertFalse(secondBook.matches("dghdgn"));
        assertFalse(thirdSmartphone.matches("dg][';"));
        assertFalse(fourthSmartphone.matches("65465464dbdqwe"));
        assertFalse(thirdProduct.matches("Apple"));
        assertFalse(fourthProduct.matches("Samsung"));
    }
}
