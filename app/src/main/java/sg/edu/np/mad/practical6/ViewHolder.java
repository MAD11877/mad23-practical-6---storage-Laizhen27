package sg.edu.np.mad.practical6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    TextView name;
    TextView desc;
    ImageView pfp;

    ArrayList<User> user_list;



    public ViewHolder(View itemView, ArrayList<User> user_list, int viewType) {
        super(itemView);
        this.user_list = user_list;
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.desc);
        pfp = itemView.findViewById(R.id.profilepic);

        // Set additional properties for the special layout
        if (viewType == 1) {
            ImageView specialImageView = itemView.findViewById(R.id.bigpfp);
            // Set properties for the special ImageView
            // (occupy width of the screen, 1:1 width-to-height ratio, etc.)
            specialImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialog(user_list);
                }
            });
        }

        pfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(user_list);
            }
        });

    }
    private void showAlertDialog(ArrayList<User> user_list) {
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        User selectedUser = user_list.get(getAdapterPosition());
        builder.setTitle("Profile");
        builder.setMessage("Name: " + selectedUser.getName());
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    User selectedUser = user_list.get(getAdapterPosition());
                    Intent profileIntent = new Intent(itemView.getContext(), MainActivity.class);
                    profileIntent.putExtra("selected_user", selectedUser);
                    itemView.getContext().startActivity(profileIntent);
                }
            }
        });
        builder.setNegativeButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }




}
