O padrão Iterator é utilizado quando:
- Você precisa acessar elementos de uma coleção sequencialmente sem expor sua estrutura interna
- Você quer fornecer uma maneira uniforme de percorrer diferentes tipos de coleções
- Você precisa ter múltiplas formas de percorrer uma coleção

Principais benefícios:
- Simplifica o código da coleção
- Permite diferentes tipos de travessias
- Permite percorrer a coleção sem expor detalhes de implementação
- Permite que múltiplos iteradores percorram a mesma coleção

Aqui está um exemplo prático de implementação:

```java
// Interface do Iterator customizado
public interface BookIterator {
    boolean hasNext();
    Book next();
}

// Classe que representa um livro
public class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;  
    }
    
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

// Interface para a coleção que será iterada
public interface BookCollection {
    void addBook(Book book);
    void removeBook(Book book);
    BookIterator iterator();
}

// Implementação concreta da coleção
public class Library implements BookCollection {
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
    
    // Implementação concreta do Iterator
    private class LibraryIterator implements BookIterator {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < books.size();
        }
        
        @Override
        public Book next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return books.get(currentIndex++);
        }
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        
        library.addBook(new Book("Design Patterns", "Gang of Four"));
        library.addBook(new Book("Clean Code", "Robert Martin"));
        library.addBook(new Book("Refactoring", "Martin Fowler"));
        
        BookIterator iterator = library.iterator();
        
        while(iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}
```

Neste exemplo:

1. Criamos uma interface `BookIterator` que define os métodos básicos para iteração
2. Definimos uma classe `Book` que representa o elemento a ser iterado
3. Criamos uma interface `BookCollection` que define o contrato para a coleção
4. Implementamos a `Library` que é nossa coleção concreta
5. Dentro da `Library`, implementamos o `LibraryIterator` que fornece a lógica de iteração
6. No exemplo de uso, demonstramos como utilizar o iterator para percorrer a coleção

O código demonstra como o padrão Iterator permite:
- Encapsular a lógica de iteração
- Esconder a implementação interna da coleção
- Fornecer uma interface uniforme para percorrer os elementos
- Permitir múltiplas iterações simultâneas e independentes

Este padrão é especialmente útil quando você precisa:
- Percorrer estruturas de dados complexas
- Fornecer diferentes tipos de travessia para uma mesma coleção
- Desacoplar o algoritmo de iteração da estrutura da coleção
- Simplificar a interface da coleção

O Java Collection Framework usa extensivamente este padrão, como pode ser visto em `List.iterator()`, `Set.iterator()`, etc.