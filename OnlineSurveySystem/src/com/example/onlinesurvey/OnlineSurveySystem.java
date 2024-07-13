package com.example.onlinesurvey;

import java.util.Scanner;

public class OnlineSurveySystem {
    public static void main(String[] args) {
        UserService userService = new UserService();
        SurveyService surveyService = new SurveyService();
        EmailService emailService = new EmailService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Survey System");

        // Registration and Login
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (userService.registerUser(email, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. User may already exist.");
        }

        if (userService.authenticateUser(email, password)) {
            System.out.println("Login successful!");

            // Create Survey
            System.out.println("Enter survey title:");
            String title = scanner.nextLine();
            System.out.println("Enter survey description:");
            String description = scanner.nextLine();

            if (surveyService.createSurvey(title, description)) {
                System.out.println("Survey created successfully!");
            } else {
                System.out.println("Failed to create survey.");
            }

            // Send Promotional Email
            System.out.println("Enter promotional email subject:");
            String subject = scanner.nextLine();
            System.out.println("Enter promotional email message:");
            String messageText = scanner.nextLine();

            emailService.sendEmail(email, subject, messageText);

        } else {
            System.out.println("Login failed. Please check your credentials.");
        }

        scanner.close();
    }
}
