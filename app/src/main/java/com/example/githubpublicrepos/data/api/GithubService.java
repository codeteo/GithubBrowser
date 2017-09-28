package com.example.githubpublicrepos.data.api;

import com.example.githubpublicrepos.data.entities.Repo;
import com.example.githubpublicrepos.data.entities.User;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit interface to get data from Github.
 */

public interface GithubService {

    @GET("/users/{user}")
    Flowable<User> getUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Flowable<List<Repo>> listRepos(@Path("user") String user);

}
