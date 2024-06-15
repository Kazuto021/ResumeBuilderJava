import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResumeBuilderGUI extends JFrame {

    private JTextField nameField, emailField, phoneField;
    private JTextField degreeField, institutionField, yearField;
    private JTextField jobTitleField, companyField, durationField;
    private JTextArea educationArea, experienceArea;
    private ResumeBuilderService builderService;

    public ResumeBuilderGUI() {
        builderService = new ResumeBuilderService();
        setTitle("Resume Builder");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);

        // Personal Info
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        // Education
        panel.add(new JLabel("Education"));
        degreeField = new JTextField("Degree");
        panel.add(degreeField);
        institutionField = new JTextField("Institution");
        panel.add(institutionField);
        yearField = new JTextField("Year");
        panel.add(yearField);

        JButton addEducationButton = new JButton("Add Education");
        panel.add(addEducationButton);
        addEducationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String degree = degreeField.getText();
                String institution = institutionField.getText();
                String year = yearField.getText();
                builderService.addEducation(degree, institution, year);
                educationArea.append(degree + " - " + institution + " (" + year + ")\n");
            }
        });

        educationArea = new JTextArea(5, 40);
        educationArea.setEditable(false);
        panel.add(new JScrollPane(educationArea));

        // Experience
        panel.add(new JLabel("Experience"));
        jobTitleField = new JTextField("Job Title");
        panel.add(jobTitleField);
        companyField = new JTextField("Company");
        panel.add(companyField);
        durationField = new JTextField("Duration");
        panel.add(durationField);

        JButton addExperienceButton = new JButton("Add Experience");
        panel.add(addExperienceButton);
        addExperienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jobTitle = jobTitleField.getText();
                String company = companyField.getText();
                String duration = durationField.getText();
                builderService.addExperience(jobTitle, company, duration);
                experienceArea.append(jobTitle + " at " + company + " (" + duration + ")\n");
            }
        });

        experienceArea = new JTextArea(5, 40);
        experienceArea.setEditable(false);
        panel.add(new JScrollPane(experienceArea));

        // Save Resume
        JButton saveButton = new JButton("Save Resume");
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                builderService.addPersonalInfo(name, email, phone);
                Resume resume = builderService.getResume();

                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(ResumeBuilderGUI.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getPath();
                    try {
                        ResumeFileGenerator.generateResumeFile(resume, filePath);
                        JOptionPane.showMessageDialog(ResumeBuilderGUI.this, "Resume saved successfully to " + filePath);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ResumeBuilderGUI.this, "An error occurred while saving the resume: " + ex.getMessage());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ResumeBuilderGUI gui = new ResumeBuilderGUI();
                gui.setVisible(true);
            }
        });
    }
}
