package io.github.skways.di.app;

import dagger.Component;
import io.github.skways.MyApplication;
import javax.inject.Singleton;

/**
 * Created by Korir on 11/2/18.
 */
@Singleton @Component(modules = ApplicationModule.class)public interface ApplicationComponent {
  void inject(MyApplication myApplication);
}
