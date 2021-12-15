package LabWork;

public class Human {
    private int id;
    private String name;
    private String gender;
    private String bornDate;
    private Division division;
    private int salary;

    public Human(int id, String name, String gender, String bornDate, Division division, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bornDate = bornDate;
        this.division = division;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) { this.bornDate = bornDate; }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\''  +
                ", bornDate='" + bornDate + "' " +", division=" + division +
                ", salary=" + salary +
                '}';
    }
}
