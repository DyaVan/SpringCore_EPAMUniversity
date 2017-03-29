package com.diachuk.sspring.app;

/**
 * Created by VA-N_ on 15.03.2017.
 */
public class Client {

    private int id;

    private String fullName;
    private String greeting;

    public Client() {
    }

    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}