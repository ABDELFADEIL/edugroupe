package SRP.good;

import java.util.Date;

public class Person {

    private String lastName;
    private String firsName;
    private Date birthDate;
    private Job job;
    private Salary salary;


    public Person(String lastName, String firsName, Date birthDate, Job job, Salary salary) {
        this.lastName = lastName;
        this.firsName = firsName;
        this.birthDate = birthDate;
        this.job = job;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Job getJob() {
        return job;
    }

    public Salary getSalary() {
        return salary;
    }
}
