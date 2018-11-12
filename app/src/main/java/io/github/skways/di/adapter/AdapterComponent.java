package io.github.skways.di.adapter;

import dagger.Subcomponent;

@Subcomponent(modules = { AdapterModule.class }) public interface AdapterComponent {
  @Subcomponent.Builder interface Builder {
    Builder adapterModule(AdapterModule adapterModule);

    AdapterComponent build();
  }
}
