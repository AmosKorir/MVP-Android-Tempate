package io.github.skways.di.activity;

import dagger.Subcomponent;
import io.github.skways.di.fragment.FragmentComponent;
import io.github.skways.ui.activites.DashBoard;

import javax.inject.Inject;

/**
 * Created by Korir on 11/2/18.
 */
@ActivityScope @Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

  FragmentComponent.Builder fragmentBuilder();

  void inject(DashBoard dashBoard);

  @Subcomponent.Builder interface Builder {

    Builder activityModule(ActivityModule activityModule);

    ActivityComponent build();
  }
}
