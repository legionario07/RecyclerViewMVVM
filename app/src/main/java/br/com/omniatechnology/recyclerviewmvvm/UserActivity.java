package br.com.omniatechnology.recyclerviewmvvm;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import br.com.omniatechnology.recyclerviewmvvm.databinding.UserActivityBinding;

public class UserActivity extends AppCompatActivity {

    private UserActivityBinding userBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userBinding = DataBindingUtil.setContentView(this, R.layout.user_activity);
        userBinding.setViewModel(new UserViewModel());

        hasUser();

        userBinding.executePendingBindings();

    }

    @BindingAdapter({"toastMessage"})
    public static void toastMessage(View view, String msg){
        Toast.makeText(view.getContext(), msg, Toast.LENGTH_LONG).show();

    }

    @BindingAdapter({"isSaveSuccess"})
    public static void saveSuccess(View view, boolean isSaveSucess){

        if(isSaveSucess) {

            Intent intent = new Intent(view.getContext(), MainActivity.class);
            view.getContext().startActivity(intent);
        }


    }


    private void hasUser() {

        if(getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey("user")){
            userBinding.getViewModel().setUser((User) getIntent().getExtras().get("user"));
        }
    }
}
