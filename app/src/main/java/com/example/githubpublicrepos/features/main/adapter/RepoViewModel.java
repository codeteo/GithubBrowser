package com.example.githubpublicrepos.features.main.adapter;

/**
 * View model for repo items.
 */

public class RepoViewModel {

    private String name;
    private String fullname;

    public RepoViewModel(String name, String fullname) {
        this.name = name;
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
