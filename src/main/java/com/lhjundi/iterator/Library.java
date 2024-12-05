package com.lhjundi.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library implements BookCollection{
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public BookIterator iterator() {
        return new LibraryIterator();
    }

    // Implementação concretado Iterator
    private class LibraryIterator implements BookIterator{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < books.size();
        }

        @Override
        public Book next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return books.get(currentIndex++);
        }
    }
}
