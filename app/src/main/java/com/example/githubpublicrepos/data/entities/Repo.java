package com.example.githubpublicrepos.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Github repository entity.
 */

public class Repo {

    private String id;
    private String name;
    @SerializedName("full_name") private String repoFullname;

    private Owner owner;
    private String description;
    private String url;

    public Repo(String id, String name, String repoFullname, Owner owner, String description, String url) {
        this.id = id;
        this.name = name;
        this.repoFullname = repoFullname;
        this.owner = owner;
        this.description = description;
        this.url = url;
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

    public String getRepoFullname() {
        return repoFullname;
    }

    public void setRepoFullname(String repoFullname) {
        this.repoFullname = repoFullname;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}