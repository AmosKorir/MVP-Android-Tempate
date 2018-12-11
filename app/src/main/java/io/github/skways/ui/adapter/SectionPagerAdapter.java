package io.github.skways.ui.adapter;

import android.content.pm.PackageInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import io.github.skways.ui.fragments.AppFragment;
import io.github.skways.ui.fragments.FilesFragment;
import io.github.skways.ui.fragments.ImagesFragment;
import io.github.skways.ui.fragments.VideoFragment;
import java.util.ArrayList;
import java.util.List;

public class SectionPagerAdapter extends FragmentPagerAdapter {
  ArrayList<PackageInfo> apps;
  public SectionPagerAdapter(FragmentManager fm,ArrayList<PackageInfo> packageInfos) {
    super(fm);
    apps=packageInfos;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return  new AppFragment();
      case 1:
        return  new AppFragment();
      case 2:
        return  new AppFragment();
      case 3:
        return  new AppFragment();
    }
  return new AppFragment();
  }

  @Override
  public int getCount() {

    return 4;
  }
}

