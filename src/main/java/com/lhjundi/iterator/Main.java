package com.lhjundi.iterator;

public class Main {
    void main(){
        Library library = new Library();

        library.addBook(new Book("Design Patterns", "Gang of Four"));
        library.addBook(new Book("Clean Code", "Robert martin"));
        library.addBook(new Book("Refactoring", "Martin Fowler"));

        BookIterator iterator = library.iterator();

        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println(book);
        }

    }
}
