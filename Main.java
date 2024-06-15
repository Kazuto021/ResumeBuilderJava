// Main.java
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResumeBuilderService builderService = new ResumeBuilderService();

        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phone = scanner.nextLine();
        builderService.addPersonalInfo(name, email, phone);

        System.out.println("Enter number of education entries:");
        int educationCount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < educationCount; i++) {
            System.out.println("Enter degree:");
            String degree = scanner.nextLine();
            System.out.println("Enter institution:");
            String institution = scanner.nextLine();
            System.out.println("Enter year:");
            String year = scanner.nextLine();
            builderService.addEducation(degree, institution, year);
        }

        System.out.println("Enter number of experience entries:");
        int experienceCount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < experienceCount; i++) {
            System.out.println("Enter job title:");
            String jobTitle = scanner.nextLine();
            System.out.println("Enter company:");
            String company = scanner.nextLine();
            System.out.println("Enter duration:");
            String duration = scanner.nextLine();
            builderService.addExperience(jobTitle, company, duration);
        }

        Resume resume = builderService.getResume();

        System.out.println("Enter file path to save the resume:");
        String filePath = scanner.nextLine();
        try {
            ResumeFileGenerator.generateResumeFile(resume, filePath);
            System.out.println("Resume saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the resume: " + e.getMessage());
        }

        scanner.close();
    }
}
