package library.models;


import java.sql.*;

/**
 * Created by Di on 13.04.2017.
 */

public class DataBaseManager
{



    public Connection initConnection()
    {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "library", "1234");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return connection;
    }


    public void select()
    {
        Connection connection = initConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.book");
            while (result.next()) {
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println(result.getInt("book_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void insert()
    {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO book(\n" +
                            " book_author, book_title, book_isbn, book_year)\n" +
                            " VALUES (?,?, ?, ?)");
            preparedStatement.setString(1, "NeSchildt");
            preparedStatement.setString(2, "PHP");
            preparedStatement.setString(3, "12344664");
            preparedStatement.setInt(4, 2017);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void update()
    {
        Connection connection = initConnection();
        try {
           Statement stmt = connection.createStatement();
           String sql = "UPDATE public.book " +
                   "SET book_year = 2000 WHERE book_year = 1916";
           stmt.executeUpdate(sql);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }

    public void delete()
    {
        Connection connection = initConnection();
        try {
            Statement stmt = connection.createStatement();
            String sql = "DELETE FROM public.book " +
                            "WHERE book_year = 2000";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex)
        {

        }
    }



}
