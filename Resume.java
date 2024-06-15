import java.util.List;

public class Resume {
    private PersonalInfo personalInfo;
    private List<Education> educationList;
    private List<Experience> experienceList;

    // Constructor
    public Resume(PersonalInfo personalInfo, List<Education> educationList, List<Experience> experienceList) {
        this.personalInfo = personalInfo;
        this.educationList = educationList;
        this.experienceList = experienceList;
    }

    // Getters and Setters
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }
}
