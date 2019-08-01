package com.example.sqlite;

public class Model {
    String name;

    public Model(String name, String cls) {
        this.name = name;
        this.cls = cls;
    }

    public Model() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    String cls;
}
