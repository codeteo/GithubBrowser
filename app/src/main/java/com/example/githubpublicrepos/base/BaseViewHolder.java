package com.example.githubpublicrepos.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Base class implementing {@link RecyclerView.ViewHolder}.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setViewModel(T viewModel);
}