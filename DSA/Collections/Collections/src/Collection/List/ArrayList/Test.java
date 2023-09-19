package Collection.List.ArrayList;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList books = new ArrayList();
        books.add("Java");
        books.add("blockchain");
        books.add("Web Development");
        books.add("Java");
        books.add("Data Science");
        books.add(null);
        books.add(79.80);
        books.add(100);
        books.add("Java");
        books.add("Java");
        System.out.println(books);
        //[Java, blockchain, Web Development, Java, Data Science, null, 79.8, 100, Java, Java]

        books.remove("Data Science");
        System.out.println(books);
        //[Java, blockchain, Web Development, Java, null, 79.8, 100, Java, Java]

        //Removes only the first occurence
        System.out.println(books.remove("Java"));  //true
        System.out.println(books);
        //[blockchain, Web Development, Java, null, 79.8, 100, Java, Java]

        System.out.println(books.indexOf("Java"));          //2
        System.out.println(books.lastIndexOf("Java"));   //7

        System.out.println(books.get(4));                   //79.8

        books.set(4, "Deepak");
        System.out.println(books);
        //[blockchain, Web Development, Java, null, Deepak, 100, Java, Java]

        ArrayList bags = new ArrayList();
        bags.add("Laddu");
        bags.addAll(books);
        bags.add("BhaluShahi");

        System.out.println(bags);
        //[Laddu, blockchain, Web Development, Java, null, Deepak, 100, Java, Java, BhaluShahi]

        books.add("Raju");
        bags.add("Chutki");

        System.out.println("books : " + books);
        System.out.println("bags : " + bags);
        //books : [blockchain, Web Development, Java, null, Deepak, 100, Java, Java, Raju]
        //bags : [Laddu, blockchain, Web Development, Java, null, Deepak, 100, Java, Java, BhaluShahi, Chutki]

        System.out.println(books.removeAll(bags)); //true - Bcoz, we have found atleast one elmnt common, to remove
        System.out.println("books : " + books);
        //books : [Raju]

        System.out.println(bags.removeAll(books)); //false : Bcoz, we didn't find atleast one elmnt common
        System.out.println("bags : " + bags);
        //bags : [Laddu, blockchain, Web Development, Java, null, Deepak, 100, Java, Java, BhaluShahi, Chutki]

        books.clear();
        System.out.println("books : " + books);
        bags.clear();
        System.out.println("bags : " + bags);
        //books : []
        //bags : []



        //retainAll() method :
        books.add("pen");
        books.add("paper");
        books.add("books");
        books.add("rubber");
        books.add("ink");

        bags.add("pen");
        bags.add("ink");
        bags.add("paper");

        System.out.println("books : " + books);
        System.out.println("bags : " + bags);
        //books : [pen, paper, books, rubber, ink]
        //bags : [pen, ink, paper]

        //Whatever elements are there in "bag", only that should be present in "books"
        //and also, only if that particular elements is already there in "books"
        //For eg: in bags "chocolate" is there, and in books "chocolate" is not there
        //then there is no need to put "chocolate" in books
        //Means, "books" should only be retaining those elements, which are common in "bags"
        books.retainAll(bags);
        System.out.println("books : " + books);
        System.out.println("bags : " + bags);
        //books : [pen, paper, ink]
        //bags : [pen, ink, paper]

        books.clear();
        bags.clear();

        books.add("pen");
        books.add("books");
        books.add("rubber");
        books.add("ink");

        bags.add("pen");
        bags.add("ink");
        bags.add("paper");

        System.out.println("books : " + books);
        System.out.println("bags : " + bags);
        //books : [pen, books, rubber, ink]
        //bags : [pen, ink, paper]

        //Here, in "bags" paper is there, but in "books" paper is not there
        //So, paper, should also, not be there, in "bags"
        bags.retainAll(books);
        System.out.println("books : " + books);
        System.out.println("bags : " + bags);
        //books : [pen, books, rubber, ink]
        //bags : [pen, ink]


        Object arr[] = books.toArray();
        for(Object t : arr) {
            System.out.println(t);
        }

        /*
        pen
        books
        rubber
        ink
         */
    }
}
