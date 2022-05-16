package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> userArrayList;
    Context c;
    public UsersAdapter(Context c, ArrayList<User> userArrayList)
    {
        this.userArrayList = userArrayList;
        this.c = c;
    }

    @Override
    public int getItemViewType(int position)
    {
        String name = userArrayList.get(position).Name;
        String lastNumber = name.substring(name.length()-1);
        if (lastNumber.equals("7"))
        {
            return 1;
        }
        return 0;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View item = null;
        if (viewType == 1)
        {
            item=LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.list_layout_7thver,
                    null,
                    false);
        }
        else
        {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.list_layout,
                    parent,
                    false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder (@NonNull UserViewHolder holder, int position)
    {
        User u = userArrayList.get(position);
        holder.name.setText(u.Name);
        holder.desc.setText(u.Description);

        ImageView list_icon = holder.icon;
        list_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder imageAB = new AlertDialog.Builder(c);

                imageAB.setTitle("Profile");
                imageAB.setMessage(u.Name);
                imageAB.setCancelable(true);
                imageAB.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Intent mainActivity = new Intent(c, MainActivity.class);
                        mainActivity.putExtra("user", u);
                        c.startActivity(mainActivity);
                    }
                });
                imageAB.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });

                AlertDialog imageAlert = imageAB.create();
                imageAB.show();

            }
        });
    }

    @Override
    public int getItemCount() { return userArrayList.size(); }
}
