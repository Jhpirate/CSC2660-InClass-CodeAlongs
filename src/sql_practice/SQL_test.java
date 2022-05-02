package sql_practice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

// https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database

public class SQL_test {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        SQL_DataConnection connection = new SQL_DataConnection();

        String sql = "SELECT * FROM books";
        try {
            PreparedStatement statement = connection.connect().prepareStatement(sql);

            // http://tutorials.jenkov.com/jdbc/resultset.html
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                bookList.add(new Book(results.getInt(1),
                        results.getString(2),
                        results.getInt(3),
                        results.getString(4),
                        results.getInt(5),
                        results.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
            System.out.println(Arrays.toString(bookList.toArray()));
        }
    }
}


class Book {
    private int id;
    private String title;
    private int pages;
    private String author;
    private int year;
    private int num_sold;

    public Book(int id, String title, int pages, String author, int year, int num_sold) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.year = year;
        this.num_sold = num_sold;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", num_sold=" + num_sold +
                '}';
    }
}