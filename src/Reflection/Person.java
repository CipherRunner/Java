package Reflection;

@Autor(name = "Mark", dateOfCreation = 2021)
public class Person {
    private int id;
    private String name;

    public Person() {
        this.id = -1;
        this.name = "No name";

    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Person id: " + id + " Name: " + name + "Hello!");
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


}
