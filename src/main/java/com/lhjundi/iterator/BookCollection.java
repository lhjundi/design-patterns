package com.lhjundi.iterator;

// Interface para a coleção que será iterada
public interface BookCollection {
    void addBook(Book book);
    void removeBook(Book book);
    BookIterator iterator();
}
