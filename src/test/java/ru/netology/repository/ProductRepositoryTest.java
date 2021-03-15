package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Product first = new Book(1, "Война и мир", 10, "Л.Н.Толстой");
    Product second = new Book(2, "Анна Каренина", 20, "Л.Н.Толстой");
    Product third = new Book(3, "Дама с собачкой", 30, "А.П.Чехов");
    Product fourth = new Smartphone(4, "IPhoneX", 100, "Apple");
    Product fifth = new Smartphone(5, "Galaxy Z", 200, "Samsung");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    void shouldRemoveByExistId() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = {first, third, fourth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotExistId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }

}