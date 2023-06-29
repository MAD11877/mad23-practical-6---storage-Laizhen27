package sg.edu.np.mad.practical6;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "on Create!!");

        TextView UserID= findViewById(R.id.UserID);
        Intent intent= getIntent();
        User user = (User) intent.getSerializableExtra("selected_user");
        MyDbHandler dbHandler = new MyDbHandler(this, null, null, 1);
        if (user != null) {
            UserID.setText("Name" + user.getName());
            Log.v("User ID", String.valueOf(user.getUserID()));
            Button follow = findViewById(R.id.follow);
            if(user.Followed == false){
                follow.setText("Follow");
            }
            else{
                follow.setText("Unfollow");
            }
            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(user.Followed == false){
                        follow.setText("UnFollow");
                        user.Followed=true;
                        dbHandler.updateUser(user);
                    }
                    else
                    {
                        user.Followed=false;
                        follow.setText("Follow");
                        dbHandler.updateUser(user);
                    }
                }
            });
        }

    }
}