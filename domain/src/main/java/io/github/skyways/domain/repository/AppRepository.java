package io.github.skyways.domain.repository;

import io.github.skyways.domain.models.ApkFile;
import java.util.List;

import io.reactivex.Single;

public interface AppRepository {

    Single<List<ApkFile>> getAppS();
}
