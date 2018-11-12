package io.github.skyways.data.util;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Korir on 11/2/18.
 */
public class RxUtils {
  public static CompositeDisposable initDisposables(CompositeDisposable compositeDisposable) {
    if (compositeDisposable == null || (compositeDisposable != null && compositeDisposable.isDisposed())) {
      return new CompositeDisposable();
    }

    return compositeDisposable;
  }

  public static void dispose(CompositeDisposable compositeDisposable) {
    if (compositeDisposable != null) {
      compositeDisposable.dispose();
    }
  }
}