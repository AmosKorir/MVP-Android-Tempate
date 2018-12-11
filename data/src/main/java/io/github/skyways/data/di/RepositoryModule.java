package io.github.skyways.data.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.github.skyways.data.repository.local.AppDbRepository;
import io.github.skyways.domain.di.DIConstants;
import io.github.skyways.domain.repository.AppRepository;

@Module
public class RepositoryModule {
    @Provides
    @Named(DIConstants.DB)
    public AppRepository provideAppRepository() {
        return new AppDbRepository();
    }
}

