package io.github.skways.ui.fragments;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.skways.R;
import io.github.skways.ui.adapter.AppAdapter;
import io.github.skyways.presentation.apppresenter.AppPresenter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class AppFragment extends BaseFragment implements AppPresenter.MyView {
  private static final ArrayList<PackageInfo> ARG_PARAM1 = new ArrayList<PackageInfo>();
  private static final String ARG_PARAM2 = "param2";
  @Inject AppPresenter appPresenter;

  private RecyclerView appList;

  private OnFragmentInteractionListener mListener;

  public AppFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_app, container, false);
    injector().inject(AppFragment.this);
    appList = view.findViewById(R.id.applist);
    return view;
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public void onStart() {
    super.onStart();
    appPresenter.setView(this);
    appPresenter.getApps();
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override public void show(List<PackageInfo> appFiles) {
    appList.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    appList.setAdapter(new AppAdapter(appFiles, getActivity()));
  }


  public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
