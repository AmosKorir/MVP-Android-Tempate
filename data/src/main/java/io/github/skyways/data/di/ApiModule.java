package io.github.skyways.data.di;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.github.skyways.domain.di.DIConstants;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
  @Provides @Named(DIConstants.DEFAULT) public OkHttpClient provideDefaultOkHtttpClient() {
    return new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(2, TimeUnit.MINUTES)
        .retryOnConnectionFailure(true)
        .build();
  }

  @Provides @Named(DIConstants.DEFAULT)
  public Retrofit provideDefaultRetrofit(Gson gson,
      @Named(DIConstants.DEFAULT) OkHttpClient okHttpClient) {
    return new Retrofit.Builder().baseUrl("vnb")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();
  }
}