package com.framgia.demo_mvvm.screen;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.framgia.demo_mvvm.R;
import com.framgia.demo_mvvm.data.model.User;
import com.framgia.demo_mvvm.databinding.ItemRecyclerBinding;

import java.util.List;

/**
 * Created by admin on 2/7/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private List<User> mUsers;

    public MainAdapter(List<User> users) {
        mUsers = users;
    }

    public List<User> getUsers() {
        return mUsers;
    }

    public void setUsers(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecyclerBinding itemRecyclerBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_recycler, parent, false);
        return new MainHolder(itemRecyclerBinding);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        holder.binData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerBinding mRecyclerBinding;

        public MainHolder(ItemRecyclerBinding itemView) {
            super(itemView.getRoot());
            mRecyclerBinding = itemView;
        }

        public void binData(User user) {
            if (user == null) {
                return;
            }
            mRecyclerBinding.setUser(user);
            mRecyclerBinding.executePendingBindings();
        }
    }
}
