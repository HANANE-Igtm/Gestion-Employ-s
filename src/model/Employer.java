package model;

import enums.*;

public class Employer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private double salary;
    private Role role;    
    private Poste poste; 

    public Employer(int id, String firstName, String lastName, String email, int phoneNumber, double salary, Role role, Poste poste) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.role = role;
        this.poste = poste;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public Role getRole() {
        return role;
    }

    public Poste getPoste() {
        return poste;
    }
}
