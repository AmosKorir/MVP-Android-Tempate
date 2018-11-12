package io.github.skways.di.activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import dagger.Module;
import dagger.Provides;
import io.github.skways.di.adapter.AdapterComponent;
import io.github.skways.ui.activites.BaseActivity;
import io.github.skways.utils.DIConstants;
import io.github.skyways.presentation.di.PresenterModule;
import javax.inject.Named;

/**
 * Created by Korir on 11/2/18.
 */
@Module(includes = PresenterModule.class, subcomponents = { AdapterComponent.class })
public class ActivityModule {
  private final BaseActivity baseActivity;

  public ActivityModule(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }


  @Provides @Named(DIConstants.ACTIVITY) public Context provideActivityContext() {
    return baseActivity;
  }

  @Provides public BaseActivity provideActivity() {
    return baseActivity;
  }

  @Provides public LayoutInflater provideLayoutInflater(@Named(DIConstants.ACTIVITY) Context context) {
    return LayoutInflater.from(context);
  }

  @Provides public FragmentManager provideFragmentManager(BaseActivity activity) {
    return activity.getSupportFragmentManager();
  }
}
