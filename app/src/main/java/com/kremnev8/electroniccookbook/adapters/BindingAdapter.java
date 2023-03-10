package com.kremnev8.electroniccookbook.adapters;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.kremnev8.electroniccookbook.MainActivity;
import com.kremnev8.electroniccookbook.R;

import java.util.List;

public class BindingAdapter {

    private static final RequestOptions requestOptions;

    static {
        requestOptions = new RequestOptions().transform(new CenterCrop(), new RoundedCorners(16));
    }

    @androidx.databinding.BindingAdapter("itemViewModels")
    public static <T, VT extends ItemViewModel<T>> void bindItemViewModels(RecyclerView recyclerView, List<VT> itemViewModels) {
        BindableRecyclerViewAdapter<T, VT> adapter = getOrCreateAdapter(recyclerView);
        adapter.updateItems(itemViewModels);
    }

    @SuppressWarnings("unchecked")
    public static <T, VT extends ItemViewModel<T>> BindableRecyclerViewAdapter<T, VT> getOrCreateAdapter(RecyclerView recyclerView) {
        if (recyclerView.getAdapter() != null && recyclerView.getAdapter() instanceof BindableRecyclerViewAdapter) {
           return (BindableRecyclerViewAdapter<T, VT>)recyclerView.getAdapter();
        } else {
            BindableRecyclerViewAdapter<T, VT> bindableRecyclerAdapter = new BindableRecyclerViewAdapter<>();
            recyclerView.setAdapter(bindableRecyclerAdapter);
            return bindableRecyclerAdapter;
        }
    }

    @androidx.databinding.BindingAdapter("roundedImage")
    public static void loadRoundedImage(ImageView view, String imageUrl) {
        Glide
                .with(MainActivity.Instance)
                .load(imageUrl)
                .placeholder(R.drawable.empty_placeholder)
                .apply(requestOptions)
                .into(view);
    }

    @androidx.databinding.BindingAdapter("circleImage")
    public static void loadCircularImage(ImageView view, String imageUrl) {
        Glide
                .with(MainActivity.Instance)
                .load(imageUrl)
                .placeholder(R.drawable.empty_round_placeholder)
                .circleCrop()
                .into(view);

    }
}
