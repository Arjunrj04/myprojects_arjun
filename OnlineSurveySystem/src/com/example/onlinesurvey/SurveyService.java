package com.example.onlinesurvey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyService {
    public boolean createSurvey(String title, String description) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO surveys (title, description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, description);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean submitResponse(int surveyId, int userId, String response) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO responses (survey_id, user_id, response) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, surveyId);
            statement.setInt(2, userId);
            statement.setString(3, response);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getSurveys() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM surveys";
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
