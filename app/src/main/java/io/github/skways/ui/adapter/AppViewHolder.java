package io.github.skways.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.skways.R;

public class AppViewHolder extends RecyclerView.ViewHolder {
  public ImageView AppIcon;
  public TextView AppName;

  public AppViewHolder(@NonNull View itemView) {
    super(itemView);
    AppIcon = itemView.findViewById(R.id.itemAppIcon);
    AppName = itemView.findViewById(R.id.itemAppName);
  }
}
