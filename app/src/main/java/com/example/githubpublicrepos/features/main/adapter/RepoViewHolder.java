package com.example.githubpublicrepos.features.main.adapter;

import com.example.githubpublicrepos.base.BaseViewHolder;
import com.example.githubpublicrepos.data.entities.Repo;
import com.example.githubpublicrepos.databinding.ItemRepoBinding;

/**
 * View holder pattern for {@link Repo} items.
 */

class RepoViewHolder extends BaseViewHolder<RepoViewModel> {

    private final ItemRepoBinding binding;

    RepoViewHolder(ItemRepoBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void setViewModel(RepoViewModel viewModel) {
        binding.setRepo(viewModel);
    }
}
