// ResumeBuilderService.java
import java.util.ArrayList;
import java.util.List;

public class ResumeBuilderService {
    private Resume resume;

    public ResumeBuilderService() {
        this.resume = new Resume(null, new ArrayList<>(), new ArrayList<>());
    }

    public void addPersonalInfo(String name, String email, String phone) {
        PersonalInfo personalInfo = new PersonalInfo(name, email, phone);
        resume.setPersonalInfo(personalInfo);
    }

    public void addEducation(String degree, String institution, String year) {
        List<Education> educationList = resume.getEducationList();
        educationList.add(new Education(degree, institution, year));
    }

    public void addExperience(String jobTitle, String company, String duration) {
        List<Experience> experienceList = resume.getExperienceList();
        experienceList.add(new Experience(jobTitle, company, duration));
    }

    public Resume getResume() {
        return resume;
    }
}
