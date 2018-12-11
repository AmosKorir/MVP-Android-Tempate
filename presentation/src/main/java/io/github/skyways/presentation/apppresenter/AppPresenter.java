package io.github.skyways.presentation.apppresenter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.github.skyways.data.util.RxUtils;
import io.github.skyways.domain.di.DIConstants;
import io.github.skyways.presentation.BasePresenter;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;

public class AppPresenter implements BasePresenter {
  private CompositeDisposable compositeDisposable;
  @Inject @Named(DIConstants.APP) Context context;

  public void setView(MyView view) {
    this.view = view;
  }

  MyView view;
  private List<PackageInfo> installedApps;

  @Inject
  public AppPresenter() {

  }

  public void getApps() {
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);
    Disposable disposable =
        Single.just(new ArrayList<PackageInfo>(getInstalledApps(context)))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::show, view::handleError);
    compositeDisposable.add(disposable);
  }



  @Override
  public void dispose() {
    compositeDisposable.dispose();
  }

  public interface MyView extends BasePresenter.View {
    void show(List<PackageInfo> appFiles);
  }

  public static Set<PackageInfo> getInstalledApps(Context ctx) {
    final PackageManager packageManager = ctx.getPackageManager();
    int flags = PackageManager.GET_META_DATA |
        PackageManager.GET_SHARED_LIBRARY_FILES |
        PackageManager.GET_UNINSTALLED_PACKAGES;

    final List<PackageInfo> allInstalledPackages = packageManager.getInstalledPackages(flags);
    final Set<PackageInfo> filteredPackages = new HashSet();

    for (PackageInfo each : allInstalledPackages) {
      if (ctx.getPackageName().equals(each.packageName)) {
        continue;  // skip own app
      }

      if ((each.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1) {
        // System application
      } else {
        filteredPackages.add(each);
        // Installed by user
      }
    }
    return filteredPackages;
  }
}
