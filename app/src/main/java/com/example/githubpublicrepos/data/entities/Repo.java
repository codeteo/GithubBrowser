package com.example.githubpublicrepos.data.entities;

/**
 * Github repository entity.
 */

public class Repo {

    private String id;
    private String name;
    private String full_name;

    public Repo(String id, String name, String owner) {
        this.id = id;
        this.name = name;
        this.full_name = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}