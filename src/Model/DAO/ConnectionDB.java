package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class ConnectionDB {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            return connection = connect();
        }
    }

    private static Connection connect() {
        String url, user, pass;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //URL localhost
            url = "jdbc:mysql://localhost:3306/generic_bd";

            user = "root";
            pass = "root";
            //pass = "aluno";

            connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
