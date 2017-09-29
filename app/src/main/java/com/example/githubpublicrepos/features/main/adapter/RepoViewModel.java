package com.example.githubpublicrepos.features.main.adapter;

/**
 * View model for repo items.
 */

public class RepoViewModel {

    private String userLogin;
    private String name;
    private String repoFullname;

    public RepoViewModel(String name, String fullname, String userLogin) {
        this.name = name;
        this.repoFullname = fullname;
        this.userLogin = userLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepoFullname() {
        return repoFullname;
    }

    public void setRepoFullname(String repoFullname) {
        this.repoFullname = repoFullname;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
