public class Education {
    private String degree;
    private String institution;
    private String year;

    // Constructor
    public Education(String degree, String institution, String year) {
        this.degree = degree;
        this.institution = institution;
        this.year = year;
    }

    // Getters and Setters
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
