package br.com.omniatechnology.recyclerviewmvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.omniatechnology.recyclerviewmvvm.databinding.ItemUsersBinding;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> users;
    private Context context;


    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemUsersBinding itemUsersBinding = DataBindingUtil.inflate(

                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_users,
                viewGroup, false
        );


        return new UserViewHolder(itemUsersBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder viewHolder, int i) {

        User user = users.get(i);

        viewHolder.itemUsersBinding.setUser(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ItemUsersBinding itemUsersBinding;
        private Context context;

        public UserViewHolder(@NonNull final ItemUsersBinding itemView) {
            super(itemView.getRoot());
            this.itemUsersBinding = itemView;
            this.context = itemView.getRoot().getContext();

            itemUsersBinding.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, UserActivity.class);
                    intent.putExtra("user", itemUsersBinding.getUser());
                    context.startActivity(intent);
                }
            });
        }


    }

}
