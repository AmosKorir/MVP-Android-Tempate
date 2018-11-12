package io.github.skways.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import io.github.skways.di.activity.ActivityComponent;
import io.github.skways.di.fragment.FragmentComponent;
import io.github.skways.di.fragment.FragmentModule;
import io.github.skways.ui.activites.BaseActivity;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Korir on 11/2/18.
 */
public class BaseFragment extends Fragment {
  private static final int NO_LAYOUT = -1;
  private CompositeDisposable compositeDisposable;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().baseInject(this);
  }

  public int getLayoutId() {
    return NO_LAYOUT;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (getLayoutId() != NO_LAYOUT) {
      View view = inflater.inflate(getLayoutId(), container, false);
      ButterKnife.bind(this, view);
      return view;
    } else {
      return super.onCreateView(inflater, container, savedInstanceState);
    }
  }

  public void handleError(Throwable throwable) {
    Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
  }

  protected FragmentComponent injector() {
    return activityInjector().fragmentBuilder().fragmentModule(new FragmentModule(this)).build();
  }

  protected ActivityComponent activityInjector() {
    return ((BaseActivity) getActivity()).injector();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    dispose();
  }

  protected void dispose() {
    //RxUtil.dispose(compositeDisposable);
  }
}