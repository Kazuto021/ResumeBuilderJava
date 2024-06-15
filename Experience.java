public class Experience {
    private String jobTitle;
    private String company;
    private String duration;

    // Constructor
    public Experience(String jobTitle, String company, String duration) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.duration = duration;
    }

    // Getters and Setters
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
