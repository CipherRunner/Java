package LabWork;

import java.util.*;

public class Division {
    private static int count = 0;

    private String name;
    private int id;
    private static Set<Division> divisionsSet = new HashSet<>();


    public Division(String name) {
        this.name = name;
        this.id = count;
        count++;
    }

    public static Division createNewDivision(String name) {
        for (Division div: divisionsSet) {
            if (name.equals(div.getName())) {
                return div;
            }
        }
        Division division = new Division(name);
        divisionsSet.add(division);
        return division;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public static Set<Division> getDivisionsSet() { return divisionsSet; }

    @Override
    public String toString() {
        return "Division{" +
                "name='" + name + '\'' + " id "+ id +
                '}';
    }



}
