package sg.edu.np.mad.practical6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerView extends AppCompatActivity {

    ArrayList<User> user_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        MyDbHandler dbHandler = new MyDbHandler(this, null, null, 1);

        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int name = random.nextInt(Integer.MAX_VALUE - 10000000) + 10000000;
            int desc = random.nextInt(Integer.MAX_VALUE - 10000000) + 10000000;
            User user = new User(String.valueOf(name), String.valueOf(desc), i, false);

            dbHandler.addUser(user);
        }

        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Adapter adapter = new Adapter(dbHandler.getUsers());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}