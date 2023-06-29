package sg.edu.np.mad.practical6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<User> user_list;
    public Adapter(ArrayList<User> input){
        this.user_list = input;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item;
        if (viewType == 1) {
            item = inflater.inflate(R.layout.layout_special, parent, false);
        } else {
            item = inflater.inflate(R.layout.layout, parent, false);
        }
        return new ViewHolder(item, user_list, viewType);
    }



    public void onBindViewHolder(ViewHolder Holder, int position){
        User user_details = user_list.get(position);
        Holder.name.setText(user_details.getName());
        Holder.desc.setText(user_details.getDescription());

    }
    public int getItemCount(){
        return user_list.size();
    }
    @Override
    public int getItemViewType(int position) {
        String name = user_list.get(position).getName();
        // Get the last digit of the name
        int lastDigit = Integer.parseInt(name.substring(name.length() - 1));

        // Check if the last digit is 7
        if (lastDigit == 7) {
            return 1; // Unique view type for names ending in 7
        } else {
            return 0; // Default view type for other names
        }
    }

}