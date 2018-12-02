package io.github.skways.ui.activites;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import butterknife.ButterKnife;
import io.github.skways.MyApplication;
import io.github.skways.di.activity.ActivityComponent;
import io.github.skyways.data.util.RxUtils;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Korir on 11/2/18.
 */
public class BaseActivity extends AppCompatActivity {
  protected CompositeDisposable compositeDisposable;
  protected ProgressDialog progressDialog;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void onStart() {
    super.onStart();
    ButterKnife.bind(this);
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);
  }



  public ActivityComponent injector(){
    return ((MyApplication) getApplicationContext()).getActivityInjector(this);
  }

  public void handleError(Throwable throwable) {
    if (!TextUtils.isEmpty(throwable.getMessage())) {
      dismissProgressDialog();
      Toast.makeText(getBaseContext(), "Oops something is wrong", Toast.LENGTH_LONG).show();
    }
  }

  public void showProgressDialog() {
    progressDialog = new ProgressDialog(this);
    progressDialog.setMessage("Please wait..");
    progressDialog.show();
  }

  public void dismissProgressDialog() {
    if (progressDialog != null) {
      progressDialog.dismiss();
    }
  }
  protected void dispose() {
    RxUtils.dispose(compositeDisposable);
  }

}
