package com.example.githubpublicrepos.data.mappers;

import com.example.githubpublicrepos.data.entities.Repo;
import com.example.githubpublicrepos.features.main.adapter.RepoViewModel;

/**
 * Helper class to map a {@link Repo} to a {@link RepoViewModel}.
 */

public class RepoMapper {

    public RepoMapper() {
    }

    public static RepoViewModel from(Repo repo) {
        return new RepoViewModel(repo.getName(), repo.getRepoFullname(), repo.getOwner().getLogin());
    }

}
