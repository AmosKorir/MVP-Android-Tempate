package io.github.skways.ui.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.skways.R;
import io.github.skyways.domain.models.ApkFile;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppViewHolder>{
  List<PackageInfo> apkFileList;
  Context ctx;

  public AppAdapter(List<PackageInfo> apkFileList, Context ctx) {
    this.apkFileList = apkFileList;
    this.ctx = ctx;
  }

  @NonNull @Override public AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view=LayoutInflater.from(ctx).inflate(R.layout.item_app_layout,viewGroup,false);
    return new AppViewHolder(view);
  }

  @Override public void onBindViewHolder(@NonNull AppViewHolder appViewHolder, int i) {

      appViewHolder.AppName.setText(apkFileList.get(i).applicationInfo.loadLabel(ctx.getPackageManager()));
      appViewHolder.AppIcon.setImageDrawable(apkFileList.get(i).applicationInfo.loadIcon(ctx.getPackageManager()));
  }

  @Override public int getItemCount() {
    return apkFileList.size();
  }
}
