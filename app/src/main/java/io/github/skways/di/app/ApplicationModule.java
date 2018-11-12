package io.github.skways.di.app;

import android.content.Context;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import io.github.skways.MyApplication;
import io.github.skways.di.activity.ActivityComponent;
import io.github.skways.utils.DIConstants;
import javax.inject.Named;
import com.google.gson.GsonBuilder;

/**
 * Created by Korir on 11/2/18.
 */
@Module(includes = AndroidModule.class, subcomponents = { ActivityComponent.class })
public class ApplicationModule {
  private final MyApplication myApplication;

  public ApplicationModule(MyApplication myApplication) {
    this.myApplication = myApplication;
  }

  @Provides @Named(DIConstants.APP) public Context provideAppContext() {
    return myApplication;
  }

  @Provides public Gson provideGson() {
    return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
  }
}
