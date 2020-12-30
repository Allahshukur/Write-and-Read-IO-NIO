package com.company.User;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String toString(){
        return "Name = "+getName()+", Surname = "+getSurname();
    }
}
