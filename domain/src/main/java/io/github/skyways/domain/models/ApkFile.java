package io.github.skyways.domain.models;

import com.sun.jndi.toolkit.url.Uri;

import java.io.File;

public class ApkFile {
    private String appName;
    private String packageName;
    private File filepath;
    private File imageFile;


  public ApkFile() {
  }

  private ApkFile(Builder builder) {
    setAppName(builder.appName);
    setPackageName(builder.packageName);
    setFilepath(builder.filepath);
    setImageFile(builder.imageFile);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public File getFilepath() {
    return filepath;
  }

  public void setFilepath(File filepath) {
    this.filepath = filepath;
  }

  public File getImageFile() {
    return imageFile;
  }

  public void setImageFile(File imageFile) {
    this.imageFile = imageFile;
  }

  public static final class Builder {
    private String appName;
    private String packageName;
    private File filepath;
    private File imageFile;

    private Builder() {
    }

    public Builder withAppName(String val) {
      appName = val;
      return this;
    }

    public Builder withPackageName(String val) {
      packageName = val;
      return this;
    }

    public Builder withFilepath(File val) {
      filepath = val;
      return this;
    }

    public Builder withImageFile(File val) {
      imageFile = val;
      return this;
    }

    public ApkFile build() {
      return new ApkFile(this);
    }
  }
}
