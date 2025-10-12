package com.example.service;

import com.example.model.Book;

import java.util.Comparator;
import java.util.List;

/**
 * Utility class for price calculations related to books and book series. Provides methods for calculating discounted prices, total and average prices, and
 * identifying the most and least expensive books within a list.
 */
public class PriceCalculator {

    /**
     * Calculates the final price for a single book, applying a discount if specified.
     *
     * @param book
     *                 The book for which the price is calculated.
     * @param discountPercent
     *                 The discount in percent (e.g. 10 for 10% discount). Use 0 for no discount.
     * @return The final book price, never negative. Returns 0.0 if the book is null.
     */
    public static double calculateBookPrice(Book book, double discountPercent) {
        if (book == null)
            return 0.0;
        double price = book.getPrice();
        if (discountPercent > 0) {
            price = price * (1 - discountPercent / 100.0);
        }
        return Math.max(price, 0.0);
    }

    /**
     * Calculates the total price for a list of books.
     *
     * @param books
     *                 The list of books.
     * @return The sum of all book prices in the list. Returns 0.0 if the list is null or empty.
     */
    public static double calculateTotalPrice(List<Book> books) {
        if (books == null || books.isEmpty())
            return 0.0;
        return books.stream()
                    .mapToDouble(Book::getPrice)
                    .sum();
    }

    /**
     * Calculates the average price of books in the given list.
     *
     * @param books
     *                 The list of books.
     * @return The average price, or 0.0 if the list is null or empty.
     */
    public static double calculateAveragePrice(List<Book> books) {
        if (books == null || books.isEmpty())
            return 0.0;
        return books.stream()
                    .mapToDouble(Book::getPrice)
                    .average()
                    .orElse(0.0);
    }

    /**
     * Finds the most expensive book from the given list.
     *
     * @param books
     *                 The list of books.
     * @return The book with the highest price, or null if the list is null or empty.
     */
    public static Book findMostExpensiveBook(List<Book> books) {
        if (books == null || books.isEmpty())
            return null;
        return books.stream()
                    .max(Comparator.comparingDouble(Book::getPrice))
                    .orElse(null);
    }

    /**
     * Finds the cheapest book from the given list.
     *
     * @param books
     *                 The list of books.
     * @return The book with the lowest price, or null if the list is null or empty.
     */
    public static Book findCheapestBook(List<Book> books) {
        if (books == null || books.isEmpty())
            return null;
        return books.stream()
                    .min(Comparator.comparingDouble(Book::getPrice))
                    .orElse(null);
    }
}