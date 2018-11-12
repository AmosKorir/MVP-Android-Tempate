package io.github.skways.di.fragment;

import android.support.v4.app.FragmentManager;
import dagger.Subcomponent;
import io.github.skways.ui.fragments.BaseFragment;

@Subcomponent(modules = { FragmentModule.class }) public interface FragmentComponent {

  void baseInject(BaseFragment baseFragment);

  @Subcomponent.Builder interface Builder {
    Builder fragmentModule(FragmentModule fragmentModule);

    FragmentComponent build();
  }
}
