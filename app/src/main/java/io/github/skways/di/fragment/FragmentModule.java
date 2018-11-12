package io.github.skways.di.fragment;

import dagger.Module;
import io.github.skways.ui.fragments.BaseFragment;

/**
 * Created by Korir on 11/2/18.
 */
@Module public class FragmentModule {
  private BaseFragment baseFragment;

  public FragmentModule(BaseFragment baseFragment) {
    this.baseFragment = baseFragment;
  }
}
