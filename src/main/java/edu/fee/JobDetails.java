package edu.fee;
public class JobDetails {
    private String title;
    private String country;
    private String level;
    private String yearsOfExperience;

    public JobDetails(String title, String country, String level, String yearsOfExperience) {
        this.setTitle(title);
        this.setCountry(country);
        this.setLevel(level);
        this.setYearsOfExperience(yearsOfExperience);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

}
