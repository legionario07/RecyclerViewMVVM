package br.com.omniatechnology.recyclerviewmvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.omniatechnology.recyclerviewmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding mainBinding;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerview.setHasFixedSize(true);

        userAdapter = new UserAdapter(this, initUsers());
        mainBinding.recyclerview.setAdapter(userAdapter);


    }


    private List<User> initUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User("João", "joao@joao");
        User user2 = new User("Mario", "mario@mario");
        User user3 = new User("Pedro", "pedro@pedro");
        User user4 = new User("Paulo", "paulo@paulo");
        User user5 = new User("José", "jose@jose");
        User user6 = new User("Marcos", "marcos@marcos");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        return users;

    }

}
