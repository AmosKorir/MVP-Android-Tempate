package io.github.skways.di.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import io.github.skways.R;
import io.github.skways.utils.DIConstants;
import javax.inject.Named;

/**
 * Created by Korir on 11/2/18.
 */
@Module public class AndroidModule {
  private final Context context;

  public AndroidModule(Context context) {
    this.context = context;
  }

  @Provides
  public SharedPreferences provideSharedPreference(@Named(DIConstants.APP) Context contex) {
    return contex.getSharedPreferences(contex.getString(R.string.sharepreference_tag),
        Context.MODE_PRIVATE);
  }

  @Provides public Resources provideResources(@Named(DIConstants.APP) Context context) {
    return context.getResources();
  }
}
