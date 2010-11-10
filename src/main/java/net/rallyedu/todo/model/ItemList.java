package net.rallyedu.todo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class ItemList {
    private static final String CONN_STRING = "jdbc:mysql://localhost/todo?user=root";

    private List<Item> items = new ArrayList<Item>();
    private boolean stale = true;
    private Connection conn;

    public List<Item> get() {
        refresh();
        return unmodifiableList(items);
    }

    public void add(String info) {
        try {
            PreparedStatement stmt =
                getConnection().prepareStatement("INSERT INTO item (info) VALUES (?)");
            stmt.setString(1, info);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Could not create in db:\n" + ex.getMessage());
        }
        stale = true;
    }

    public void delete(int id) {
        try {
            PreparedStatement stmt =
                getConnection().prepareStatement("DELETE FROM item WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Could not delete from db:\n" + ex.getMessage());
        }
        stale = true;
    }

    private void refresh() {
        if (stale) {
            try {
                Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, info FROM item");
                items = new ArrayList<Item>();
                while (rs.next()) {
                    items.add(new Item(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException ex) {
                System.err.println("Could not refresh from db:\n" + ex.getMessage());
            }
        }
    }

    private Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(CONN_STRING);
        }
        return conn;
    }
}
