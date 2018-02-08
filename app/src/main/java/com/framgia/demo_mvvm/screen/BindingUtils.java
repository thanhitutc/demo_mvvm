package com.framgia.demo_mvvm.screen;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by admin on 2/8/2018.
 */

public class BindingUtils {
    @BindingAdapter({"app:adapter"})
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
