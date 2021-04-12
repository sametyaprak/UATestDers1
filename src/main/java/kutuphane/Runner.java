package kutuphane;

import java.util.*;

public class Runner {

    static Map<Integer,Book> myBookMap = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    static int bookId = 1000;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.defaultBooks();
        runner.mainRunner();
    }

    public void mainRunner(){
        int toDo  = 0;
        do {
            System.out.println("enter what to do");
            System.out.println("1...to see all books");
            System.out.println("2...to add a book");
            System.out.println("3...to delete a book");
            System.out.println("4...to search a book");
            System.out.println("5... to exit");
            toDo = scan.nextInt();
            switch (toDo) {
                case 1 : listAllBooks();
                        break;
                case 2 : createBook();
                    break;
                case 3 : deleteBook();
                    break;
                case 4 : searchABook();
                    break;
                case 5 :    System.out.println("have a good day");
                            System.exit(0);
                    break;
                default:
                    System.out.println("wrong input");
            }
        } while (true);
    }

    public void listAllBooks(){
        for (Integer w : myBookMap.keySet()){
            System.out.println("bookid: " + w + " " +myBookMap.get(w).toString());
        }
    }
    public void searchABook(){
        System.out.println("give me a id");
        int idSearch = scan.nextInt();
        for (Integer w : myBookMap.keySet()){
            if(w==idSearch){
                System.out.println(myBookMap.get(w).toString());
            }
        }
    }



    public void createBook(){
        System.out.println("bookName");
        String bookName = scan.next();
        System.out.println("writerName");
        String writerName = scan.next();
        System.out.println("releaseYear");
        int releaseYear = Integer.parseInt(scan.next());
        System.out.println("price");
        long price = Integer.parseInt(scan.next());
        myBookMap.put(++bookId,new Book(bookName,writerName,releaseYear,price));
    }

    public void deleteBook(){
        System.out.println("enter id to delete");
        Integer bookId = scan.nextInt();
        myBookMap.remove(bookId);
    }

    public void defaultBooks(){
        myBookMap.put(++bookId,new Book("ingilizce","michael",2005,100));
        myBookMap.put(++bookId,new Book("almanca","hans",2015,90));
        myBookMap.put(++bookId,new Book("japonca","lei",1991,45));
        myBookMap.put(++bookId,new Book("ispanyolca","maria",1071,650));

    }


}
