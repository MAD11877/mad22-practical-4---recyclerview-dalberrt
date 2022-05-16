package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView desc;
    ImageView icon;

    public UserViewHolder(View itemView)
    {
        super(itemView);
        name = itemView.findViewById(R.id.list_name);
        desc = itemView.findViewById(R.id.list_desc);
        icon = itemView.findViewById(R.id.list_icon);
    }
}
