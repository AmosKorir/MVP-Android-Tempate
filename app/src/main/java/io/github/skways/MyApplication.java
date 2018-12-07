package io.github.skways;

import android.app.Application;
import io.github.skways.di.activity.ActivityComponent;
import io.github.skways.di.activity.ActivityModule;
import io.github.skways.di.app.AndroidModule;
import io.github.skways.di.app.ApplicationComponent;
import io.github.skways.di.app.ApplicationModule;
import io.github.skways.di.app.DaggerApplicationComponent;
import io.github.skways.ui.activites.BaseActivity;

/**
 * Created by Korir on 11/2/18.
 */
public class MyApplication extends Application {
  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    applicationComponent=DaggerApplicationComponent.builder()
        .androidModule(new AndroidModule(this))
        .applicationModule(new ApplicationModule(this))
        .build();

    applicationComponent.inject(this);
  }

  public ActivityComponent getActivityInjector(BaseActivity baseActivity) {
    return (ActivityComponent) applicationComponent.activityComponentBuilder().activityModule(new ActivityModule(baseActivity)).build();
  }
}
