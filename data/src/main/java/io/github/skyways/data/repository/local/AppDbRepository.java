package io.github.skyways.data.repository.local;

import android.content.Context;


import io.github.skyways.domain.models.ApkFile;
import java.util.List;

import javax.inject.Inject;

import io.github.skyways.domain.repository.AppRepository;
import io.reactivex.Single;

public class AppDbRepository implements AppRepository {
    @Inject
   Context context;

    @Override
    public Single<List<ApkFile>> getAppS() {
        return null;
    }
}
