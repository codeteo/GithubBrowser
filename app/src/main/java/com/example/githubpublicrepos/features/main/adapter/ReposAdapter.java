package com.example.githubpublicrepos.features.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.githubpublicrepos.databinding.ItemRepoBinding;
import com.example.githubpublicrepos.features.main.MainActivity;

import java.util.List;

/**
 * Adapter class for list of repos in {@link MainActivity}.
 */

public class ReposAdapter extends RecyclerView.Adapter<RepoViewHolder>{

    private List<RepoViewModel> dataset;

    public ReposAdapter(List<RepoViewModel> dataset) {
        this.dataset = dataset;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRepoBinding binding = ItemRepoBinding.inflate(inflater, parent, false);

        return new RepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        final RepoViewModel repoViewModel = dataset.get(position);
        holder.setViewModel(repoViewModel);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
