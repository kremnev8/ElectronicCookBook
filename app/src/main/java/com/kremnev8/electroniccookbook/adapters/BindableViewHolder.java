package com.kremnev8.electroniccookbook.adapters;

import android.content.ClipData;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.kremnev8.electroniccookbook.BR;

class BindableViewHolder<T, VT extends ItemViewModel<T>> extends RecyclerView.ViewHolder {

    public ViewDataBinding binding;

    public BindableViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(VT itemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel);
    }
}
