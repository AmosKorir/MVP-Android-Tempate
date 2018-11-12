package io.github.skyways.presentation;

/**
 * Created by Korir on 11/2/18.
 */
public interface BasePresenter {

  void dispose();

  interface View {
    void handleError(Throwable throwable);
  }
}
