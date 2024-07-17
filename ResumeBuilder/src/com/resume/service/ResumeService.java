package com.resume.service;

import com.resume.model.Resume;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ResumeService {
    public void createResume(Resume resume) {
        try {
            // Create a new PDF document
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Add content to the PDF
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
            contentStream.newLineAtOffset(220, 750);
            contentStream.showText("Resume");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);

            // Career Objective
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Career Objective");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText(resume.getCareerObjective());
            contentStream.newLine();
            contentStream.newLine();

            // Personal Information
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Personal Information");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText("Name: " + resume.getName());
            contentStream.newLine();
            contentStream.showText("Email: " + resume.getEmail());
            contentStream.newLine();
            contentStream.showText("Phone: " + resume.getPhone());
            contentStream.newLine();
            contentStream.newLine();

            // Education
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Education");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText("10th: " + resume.getHighSchoolEducation());
            contentStream.newLine();
            contentStream.showText("12th: " + resume.getHigherSecondaryEducation());
            contentStream.newLine();
            contentStream.showText("Undergraduate: " + resume.getUndergraduateEducation());
            contentStream.newLine();
            contentStream.newLine();

            // Experience
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Experience");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText(resume.getExperience());
            contentStream.newLine();
            contentStream.newLine();

            // Skills
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Skills");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText(resume.getSkills());
            contentStream.newLine();
            contentStream.newLine();

            // Languages Known
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Languages Known");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText(resume.getLanguagesKnown());
            contentStream.newLine();

            contentStream.close();

            // Save the PDF document
            document.save("resume.pdf");
            document.close();

            System.out.println("Resume created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
