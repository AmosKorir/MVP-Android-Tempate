package io.github.skyways.data.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.github.skyways.data.sql.AppNameDatabase;
import io.github.skyways.domain.di.DIConstants;
import javax.inject.Named;

@Module public class DatabaseModule {
  @Provides
  public AppNameDatabase providemvpNewsDatabase(@Named(DIConstants.APP) Context context) {
    return Room.databaseBuilder(context, AppNameDatabase.class, "mvp").build();
  }
}
