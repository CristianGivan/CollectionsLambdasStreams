package Exercises.Helper;

import java.util.List;

public class Department {
    private String name;
    private String cod;
    private List<Employee> employees;

    public Department(String name, String cod, List<Employee> employees) {
        this.name = name;
        this.cod = cod;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", cod='" + cod + '\'' +
                ", employees=" + employees +
                '}';
    }
}
