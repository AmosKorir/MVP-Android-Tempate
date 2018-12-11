package io.github.skways.di.fragment;

import android.support.v4.app.FragmentManager;
import dagger.Subcomponent;
import io.github.skways.ui.fragments.AppFragment;
import io.github.skways.ui.fragments.BaseFragment;
import io.github.skways.ui.fragments.VideoFragment;
import io.github.skyways.presentation.apppresenter.AppPresenter;

@Subcomponent(modules = { FragmentModule.class }) public interface FragmentComponent {

  void baseInject(BaseFragment baseFragment);


  void inject(AppFragment appFragment);


  @Subcomponent.Builder interface Builder {
    Builder fragmentModule(FragmentModule fragmentModule);

    FragmentComponent build();
  }
}
