// Homework 1: JavaGUI - Books
// Student Name: Bradley Chippi
// Course: CS421, Fall 2017
// Instructor: Dr. Cho
// Date finished: 9-5-2017
// Program description: This application allows a user to lookup what books they need for their classes.
// All of the books from the CSIS department for Fall 2017 gets pushed into the application. Additionally,
// users can add the books to their cart.

package main;

/**
 * Keeps track of all the books that are required for individual classes.
 * A book has a title, author, publisher, isbn, keywords, course it aligns to, and price.
 *
 * @author Bradley Chippi
 * @version 1.0 September 5, 2017
 */

class Book {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String[] keywords;
    private String course;
    private double price;

    /**
     * Constructor that gives values to class variables
     */

    public Book(){
        this.title = "Object-Oriented Software Engineering: An Agile Unified Methodology";
        this.author = "Kung, David";
        this.publisher = "McGraw-Hill Education";
        this.isbn = "0073376256";
        this.course = "CS421";
        this.price = 85.38;
        this.keywords = new String[] {this.title, this.author, this.publisher, this.isbn, this.course};
    }

    /**
     * Constructor that initializes the class variables to the parameters given by the user.
     *
     * @param title     title of book
     * @param author    author of book
     * @param publisher publisher of book
     * @param isbn      isbn identifier for book
     * @param course    course the book aligns to
     * @param price     price of book
     */

    public Book(String title, String author, String publisher, String isbn, String course, double price){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.keywords = new String[] {title, author, publisher, isbn, course};
        this.course = course;
        this.price = price;
    }

    /**
     * Grabs the books author
     *
     * @return books author
     */

    public String getAuthor(){
        return this.author;
    }

    /**
     * Grabs the books title
     *
     * @return books title
     */

    public String getTitle(){
        return this.title;
    }

    /**
     * Grabs the books price
     *
     * @return books price
     */

    public double getPrice(){
        return this.price;
    }

    /**
     * Grabs the books publisher
     *
     * @return books publisher
     */
    public String getPublisher(){
        return this.publisher;
    }

    /**
     * Grabs the books isbn numbers
     *
     * @return books isbn10/isbn13
     */
    public String getISBN(){
        return this.isbn;
    }

    /**
     * Grabs the books course it aligns to
     *
     * @return course it aligns to
     */
    public String getCourse() {
        return this.course;
    }

    /**
     * Grabs the books keywords
     *
     * @return books keywords
     */
    public String getKeywords(){
        return String.join(" ", this.keywords);
    }

    /**
     * Grabs all book information in one return
     *
     * @return books info
     */
    public String toString(){
        return "TITLE: "+ this.title + "\n" + "AUTHOR: "+this.author + "\n" + "PUBLISHER: " +
                this.publisher + "\n" + "IBSN: "+this.isbn + "\n" + "COURSE: "+this.course;
    }

}
