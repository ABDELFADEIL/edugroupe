package SRP.bad;

import java.util.Date;

public class Person {

    private String lastName;
    private String firsName;
    private Date birthDate;
    private String jobDescription;
    private boolean hasGoodSalary;

    public Person(String lastName, String firsName, Date birthDate, String jobDescription, boolean hasGoodSalary) {
        this.lastName = lastName;
        this.firsName = firsName;
        this.birthDate = birthDate;
        this.jobDescription = jobDescription;
        this.hasGoodSalary = hasGoodSalary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public boolean isHasGoodSalary() {
        return hasGoodSalary;
    }

    public void setHasGoodSalary(boolean hasGoodSalary) {
        this.hasGoodSalary = hasGoodSalary;
    }
    public void hasGoodSalary() {
         if(hasGoodSalary){
             System.out.println("Tu as un très bon salaire");
         }else {
             System.out.println("Tu n'as pas un très bon salaire");
         }
    }
}
