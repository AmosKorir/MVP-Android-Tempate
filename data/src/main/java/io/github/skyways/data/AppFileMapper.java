package io.github.skyways.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import io.github.skyways.domain.di.DIConstants;
import io.github.skyways.domain.models.ApkFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;

public class AppFileMapper {
    public static ApkFile transform(PackageInfo packageInfo, Context context) throws IOException {
      return ApkFile.newBuilder()
          .withAppName(packageInfo.applicationInfo.name)
          .withPackageName(packageInfo.packageName)
          .withFilepath(new File(packageInfo.applicationInfo.sourceDir))
          .withImageFile(getFile(packageInfo.applicationInfo.loadIcon(context.getPackageManager()),context))
          .build();

    }
    public static File getFile(Drawable drawable,Context context) throws IOException {
    UUID uuid=UUID.randomUUID();
      Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
      File file = new File(context.getFilesDir()+"/"+"xnd"+uuid.toString());
      OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
      os.close();
      return file;
}


}
