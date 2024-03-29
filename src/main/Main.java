// Homework 1: JavaGUI - Books
// Student Name: Bradley Chippi
// Course: CS421, Fall 2017
// Instructor: Dr. Cho
// Date finished: 9-5-2017
// Program description: This application allows a user to lookup what books they need for their classes.
// All of the books from the CSIS department for Fall 2017 gets pushed into the application. Additionally,
// users can add the books to their cart.

package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;

/**
 * Main starts the GUI up and brings you to the main screen. At the main screen, you can
 * search for your required books for a certain class.
 *
 * @author Bradley Chippi
 * @version 1.0 September 5, 2017
 */

public class Main extends Application {
    private int row = 7;
    private boolean found = false;

    /**
     * Starts up the main GUI, calls to read the txt file to get book info,
     * and then you have the option to search for your required books for a certain class.
     *
     * @param stage Stage
     */

    @Override
    public void start(Stage stage) {

        Book[] books = setData();
        Group root = new Group();
        Scene scene = new Scene(root, 400, 720);
        stage.setScene(scene);
        stage.setTitle("Search your Bookstore");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setMinWidth(400);

        scene.setRoot(grid);

        final TextField title = new TextField();
        title.setPromptText("Title");
        GridPane.setConstraints(title, 0, 0);
        grid.getChildren().add(title);

        final TextField author = new TextField();
        author.setPromptText("Author");
        author.setPrefColumnCount(10);
        GridPane.setConstraints(author, 0, 1);
        grid.getChildren().add(author);

        final TextField isbn = new TextField();
        isbn.setPrefColumnCount(15);
        isbn.setPromptText("ISBN");
        GridPane.setConstraints(isbn, 0, 2);
        grid.getChildren().add(isbn);

        final TextField keywords = new TextField();
        keywords.setPrefColumnCount(15);
        keywords.setPromptText("Keywords");
        GridPane.setConstraints(keywords, 0, 3);
        grid.getChildren().add(keywords);

        final TextField course = new TextField();
        course.setPrefColumnCount(15);
        course.setPromptText("Course");
        GridPane.setConstraints(course, 0, 4);
        grid.getChildren().add(course);

        Button submit = new Button("Find");
        GridPane.setConstraints(submit, 0, 5);
        grid.getChildren().add(submit);

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 6);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);


        submit.setOnAction((event) -> {

            for (Book book : books) {
                if (title.getText().toUpperCase().equals(book.getTitle()) ||
                        isbn.getText().equals(book.getISBN()) ||
                        (contains(book.getKeywords(), keywords.getText()) &&
                                keywords.getText().length() > 0) ||
                        course.getText().toUpperCase().equals(book.getCourse())) {
                    Label bookData = new Label(book.toString() +
                            "\n____________________________________________");
                    GridPane.setConstraints(bookData, 0, row);
                    grid.getChildren().add(bookData);
                    Button addCart = new Button("Add to Cart");
                    GridPane.setConstraints(addCart, 1, row);
                    grid.getChildren().add(addCart);
                    addCart.setOnAction((e) -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thank you! Order is Processing");
                        alert.setHeaderText("Thank you! Your Order is Processing!!!");
                        alert.showAndWait();
                    });
                    row++;
                    found = true;
                }

            }
            if (!(found)) {
                Label notFound = new Label(
                        "NO RESULTS\n____________________________________________");
                GridPane.setConstraints(notFound, 0, row);
                grid.getChildren().add(notFound);
                row++;
            }
            found = false;
            title.clear();
            author.clear();
            isbn.clear();
            keywords.clear();
            course.clear();


        });

        stage.show();
    }

    /**
     * Gets book information from Textbooks.txt and creates an object array of Books.
     * The object array is returned back.
     *
     * @return Book[] array of Book objects
     */

    public Book[] setData() {
        Book[] books = new Book[17];
        InputStream in = getClass().getResourceAsStream("/Textbooks.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                books[i] = new Book(line, br.readLine(), br.readLine(), br.readLine(), br.readLine(), Double.parseDouble(br.readLine()));
                br.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    /**
     * Checks to see if a string contains another string. EX: (dog, og) => True
     *
     * @param str1 Main string
     * @param str2 Check to see if this string is in str1
     * @return boolean True/False
     */
    public boolean contains(String str1, String str2) {
        str1 = str1 == null ? "" : str1;
        str2 = str2 == null ? "" : str2;

        return str1.toUpperCase().contains(str2.toUpperCase());
    }

    /**
     * Calls main GUI
     */
    public static void main(String[] args) {
        launch(args);
    }
}
