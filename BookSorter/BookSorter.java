import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BookSorter {
    public static void main(String[] args) {
        // Creation of the first set.
        Set<Book> bookSet1 = new TreeSet<>();

        bookSet1.add(new Book("The Return of the King", 416, "J.R.R. Tolkien", 1955));
        bookSet1.add(new Book("Harry Potter and the Deathly Hallows", 607, "J.K. Rowling", 2007));
        bookSet1.add(new Book("The Hunger Games", 374, "Suzanne Collins", 2008));
        bookSet1.add(new Book("White Fang", 298, "Jack London", 1906));
        bookSet1.add(new Book("The Call of the Wild", 232, "Jack London", 1903));


        // Creation of the second set and defining of compare method.
        Set<Book> bookSet2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageCount() - o2.getPageCount();
            }
        });

        bookSet2.addAll(bookSet1);


        Iterator<Book> itr = bookSet1.iterator();
        System.out.println("Book Set 1:");
        while (itr.hasNext()) {
            Book b1 = itr.next();
            System.out.println(b1.getName() + " : " + b1.getPageCount());
        }

        System.out.println("---------------------------------------------------\nBook Set 2:");

        for (Book b2 : bookSet2) {
            System.out.println(b2.getName() + " : " + b2.getPageCount());
        }
    }
}
