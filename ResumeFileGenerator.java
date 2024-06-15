// ResumeFileGenerator.java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResumeFileGenerator {
    public static void generateResumeFile(Resume resume, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            PersonalInfo personalInfo = resume.getPersonalInfo();
            writer.write("Personal Information\n");
            writer.write("Name: " + personalInfo.getName() + "\n");
            writer.write("Email: " + personalInfo.getEmail() + "\n");
            writer.write("Phone: " + personalInfo.getPhone() + "\n");
            writer.write("\nEducation\n");

            for (Education edu : resume.getEducationList()) {
                writer.write(edu.getDegree() + " - " + edu.getInstitution() + " (" + edu.getYear() + ")\n");
            }
            writer.write("\nExperience\n");
            for (Experience exp : resume.getExperienceList()) {
                writer.write(exp.getJobTitle() + " at " + exp.getCompany() + " (" + exp.getDuration() + ")\n");
            }
        }
    }
}
