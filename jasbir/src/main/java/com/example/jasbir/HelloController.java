package com.example.jasbir;

import com.example.jasbir.entertainment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

public class HelloController {
    @FXML
    private TableView<entertainment> tableView;

    @FXML
    private TextField gameField;

    @FXML
    private TextField hobbyField;

    @FXML
    private TextField movieField;

    private Connection connection;

    public HelloController() {
        try {
            String url = "jdbc:mysql://localhost:3306/lab2lab2";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onViewDataButtonClick() {
        ObservableList<entertainment> data = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM entertainment");
            while (resultSet.next()) {
                String game = resultSet.getString("game");
                String hobby = resultSet.getString("hobby");
                String movie = resultSet.getString("movie");
                data.add(new entertainment(game, hobby, movie));
            }
            tableView.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onInsertButtonClick() {
        String game = gameField.getText();
        String hobby = hobbyField.getText();
        String movie = movieField.getText();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO entertainment (game, hobby, movie) VALUES (?, ?, ?)");
            statement.setString(1, game);
            statement.setString(2, hobby);
            statement.setString(3, movie);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new entertainment record was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onUpdateButtonClick() {
        String game = gameField.getText();
        String hobby = hobbyField.getText();
        String movie = movieField.getText();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE entertainment SET hobby = ?, movie = ? WHERE game = ?");
            statement.setString(1, hobby);
            statement.setString(2, movie);
            statement.setString(3, game);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing entertainment record was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        String game = gameField.getText();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM entertainment WHERE game = ?");
            statement.setString(1, game);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An existing entertainment record was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}








    
