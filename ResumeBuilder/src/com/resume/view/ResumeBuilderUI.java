package com.resume.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.resume.model.Resume;
import com.resume.service.ResumeService;

public class ResumeBuilderUI extends JFrame {
    private JTextField nameField, emailField, phoneField, highSchoolField, higherSecondaryField, undergraduateField, experienceField, skillsField, careerObjectiveField, languagesKnownField;
    private ResumeService resumeService;

    public ResumeBuilderUI() {
        resumeService = new ResumeService();

        setTitle("Resume Builder");
        setSize(500, 600);  // Increase the size to accommodate the new fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));  // Update the layout to 12 rows

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        panel.add(new JLabel("10th:"));
        highSchoolField = new JTextField();
        panel.add(highSchoolField);

        panel.add(new JLabel("12th:"));
        higherSecondaryField = new JTextField();
        panel.add(higherSecondaryField);

        panel.add(new JLabel("Undergraduate:"));
        undergraduateField = new JTextField();
        panel.add(undergraduateField);

        panel.add(new JLabel("Experience:"));
        experienceField = new JTextField();
        panel.add(experienceField);

        panel.add(new JLabel("Skills:"));
        skillsField = new JTextField();
        panel.add(skillsField);

        panel.add(new JLabel("Career Objective:"));
        careerObjectiveField = new JTextField();
        panel.add(careerObjectiveField);

        panel.add(new JLabel("Languages Known:"));
        languagesKnownField = new JTextField();
        panel.add(languagesKnownField);

        JButton createButton = new JButton("Create Resume");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createResume();
            }
        });
        panel.add(createButton);

        add(panel);
    }

    private void createResume() {
        Resume resume = new Resume();
        resume.setName(nameField.getText());
        resume.setEmail(emailField.getText());
        resume.setPhone(phoneField.getText());
        resume.setHighSchoolEducation(highSchoolField.getText());
        resume.setHigherSecondaryEducation(higherSecondaryField.getText());
        resume.setUndergraduateEducation(undergraduateField.getText());
        resume.setExperience(experienceField.getText());
        resume.setSkills(skillsField.getText());
        resume.setCareerObjective(careerObjectiveField.getText());
        resume.setLanguagesKnown(languagesKnownField.getText());

        resumeService.createResume(resume);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResumeBuilderUI().setVisible(true);
            }
        });
    }
}
