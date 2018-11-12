package io.github.skways.ui.activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import io.github.skways.MyApplication;
import io.github.skways.di.activity.ActivityComponent;

/**
 * Created by Korir on 11/2/18.
 */
public class BaseActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void onStart() {
    super.onStart();
  }



  public ActivityComponent injector(){
    return ((MyApplication) getApplicationContext()).getActivityInjector(this);
  }
}
