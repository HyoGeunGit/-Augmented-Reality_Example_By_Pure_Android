package com.shimhg02.hyogeunexample.artodo;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Display;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Shimhg02.
 */
public class MyCurrentLocation extends Context implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

        private GoogleApiClient mGoogleApiClient;
        private Location mLastLocation;
        private LocationRequest mLocationRequest;
        private OnLocationChangedListener onLocationChangedListener;

        public MyCurrentLocation(OnLocationChangedListener onLocationChangedListener) {
                this.onLocationChangedListener = onLocationChangedListener;
        }

        protected synchronized void buildGoogleApiClient(Context context) {
                mGoogleApiClient = new GoogleApiClient.Builder(context)
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build();

                mLocationRequest = LocationRequest.create()
                        .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
                        .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                        .setFastestInterval(1 * 1000); // 1 second, in milliseconds
        }

        public void start() {
                mGoogleApiClient.connect();
        }

        public void stop() {
                mGoogleApiClient.disconnect();
        }

        @Override
        public void onConnected(Bundle bundle) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        // 퍼미션 자동생성자
                        return;
                }
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        // 퍼미션 자동생성자
                        return;
                }
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);
                if (mLastLocation != null) {
                        onLocationChangedListener.onLocationChanged(mLastLocation);
                }
        }

        @Override
        public void onConnectionSuspended(int i) {

        }

        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {
                Log.e("MyApp", "Location services connection failed with code " + connectionResult.getErrorCode());
        }

        @Override
        public void onLocationChanged(Location location) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        // 퍼미션 자동생성자
                        return;
                }
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);
                if (mLastLocation != null) {
                        onLocationChangedListener.onLocationChanged(mLastLocation);
                }
        }

        @Override
        public AssetManager getAssets() {
                return null;
        }

        @Override
        public Resources getResources() {
                return null;
        }

        @Override
        public PackageManager getPackageManager() {
                return null;
        }

        @Override
        public ContentResolver getContentResolver() {
                return null;
        }

        @Override
        public Looper getMainLooper() {
                return null;
        }

        @Override
        public Context getApplicationContext() {
                return null;
        }

        @Override
        public void setTheme(int resid) {

        }

        @Override
        public Resources.Theme getTheme() {
                return null;
        }

        @Override
        public ClassLoader getClassLoader() {
                return null;
        }

        @Override
        public String getPackageName() {
                return null;
        }

        @Override
        public ApplicationInfo getApplicationInfo() {
                return null;
        }

        @Override
        public String getPackageResourcePath() {
                return null;
        }

        @Override
        public String getPackageCodePath() {
                return null;
        }

        @Override
        public SharedPreferences getSharedPreferences(String name, int mode) {
                return null;
        }

        @Override
        public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
                return false;
        }

        @Override
        public boolean deleteSharedPreferences(String name) {
                return false;
        }

        @Override
        public FileInputStream openFileInput(String name) throws FileNotFoundException {
                return null;
        }

        @Override
        public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
                return null;
        }

        @Override
        public boolean deleteFile(String name) {
                return false;
        }

        @Override
        public File getFileStreamPath(String name) {
                return null;
        }

        @Override
        public File getDataDir() {
                return null;
        }

        @Override
        public File getFilesDir() {
                return null;
        }

        @Override
        public File getNoBackupFilesDir() {
                return null;
        }

        @Nullable
        @Override
        public File getExternalFilesDir(@Nullable String type) {
                return null;
        }

        @Override
        public File[] getExternalFilesDirs(String type) {
                return new File[0];
        }

        @Override
        public File getObbDir() {
                return null;
        }

        @Override
        public File[] getObbDirs() {
                return new File[0];
        }

        @Override
        public File getCacheDir() {
                return null;
        }

        @Override
        public File getCodeCacheDir() {
                return null;
        }

        @Nullable
        @Override
        public File getExternalCacheDir() {
                return null;
        }

        @Override
        public File[] getExternalCacheDirs() {
                return new File[0];
        }

        @Override
        public File[] getExternalMediaDirs() {
                return new File[0];
        }

        @Override
        public String[] fileList() {
                return new String[0];
        }

        @Override
        public File getDir(String name, int mode) {
                return null;
        }

        @Override
        public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
                return null;
        }

        @Override
        public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, @Nullable DatabaseErrorHandler errorHandler) {
                return null;
        }

        @Override
        public boolean moveDatabaseFrom(Context sourceContext, String name) {
                return false;
        }

        @Override
        public boolean deleteDatabase(String name) {
                return false;
        }

        @Override
        public File getDatabasePath(String name) {
                return null;
        }

        @Override
        public String[] databaseList() {
                return new String[0];
        }

        @Override
        public Drawable getWallpaper() {
                return null;
        }

        @Override
        public Drawable peekWallpaper() {
                return null;
        }

        @Override
        public int getWallpaperDesiredMinimumWidth() {
                return 0;
        }

        @Override
        public int getWallpaperDesiredMinimumHeight() {
                return 0;
        }

        @Override
        public void setWallpaper(Bitmap bitmap) throws IOException {

        }

        @Override
        public void setWallpaper(InputStream data) throws IOException {

        }

        @Override
        public void clearWallpaper() throws IOException {

        }

        @Override
        public void startActivity(Intent intent) {

        }

        @Override
        public void startActivity(Intent intent, @Nullable Bundle options) {

        }

        @Override
        public void startActivities(Intent[] intents) {

        }

        @Override
        public void startActivities(Intent[] intents, Bundle options) {

        }

        @Override
        public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

        }

        @Override
        public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {

        }

        @Override
        public void sendBroadcast(Intent intent) {

        }

        @Override
        public void sendBroadcast(Intent intent, @Nullable String receiverPermission) {

        }

        @Override
        public void sendOrderedBroadcast(Intent intent, @Nullable String receiverPermission) {

        }

        @Override
        public void sendOrderedBroadcast(@NonNull Intent intent, @Nullable String receiverPermission, @Nullable BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

        }

        @Override
        public void sendBroadcastAsUser(Intent intent, UserHandle user) {

        }

        @Override
        public void sendBroadcastAsUser(Intent intent, UserHandle user, @Nullable String receiverPermission) {

        }

        @Override
        public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, @Nullable String receiverPermission, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

        }

        @Override
        public void sendStickyBroadcast(Intent intent) {

        }

        @Override
        public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

        }

        @Override
        public void removeStickyBroadcast(Intent intent) {

        }

        @Override
        public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {

        }

        @Override
        public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

        }

        @Override
        public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {

        }

        @Nullable
        @Override
        public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
                return null;
        }

        @Nullable
        @Override
        public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter, int flags) {
                return null;
        }

        @Nullable
        @Override
        public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
                return null;
        }

        @Nullable
        @Override
        public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
                return null;
        }

        @Override
        public void unregisterReceiver(BroadcastReceiver receiver) {

        }

        @Nullable
        @Override
        public ComponentName startService(Intent service) {
                return null;
        }

        @Nullable
        @Override
        public ComponentName startForegroundService(Intent service) {
                return null;
        }

        @Override
        public boolean stopService(Intent service) {
                return false;
        }

        @Override
        public boolean bindService(Intent service, @NonNull ServiceConnection conn, int flags) {
                return false;
        }

        @Override
        public void unbindService(@NonNull ServiceConnection conn) {

        }

        @Override
        public boolean startInstrumentation(@NonNull ComponentName className, @Nullable String profileFile, @Nullable Bundle arguments) {
                return false;
        }

        @Nullable
        @Override
        public Object getSystemService(@NonNull String name) {
                return null;
        }

        @Nullable
        @Override
        public String getSystemServiceName(@NonNull Class<?> serviceClass) {
                return null;
        }

        @Override
        public int checkPermission(@NonNull String permission, int pid, int uid) {
                return 0;
        }

        @Override
        public int checkCallingPermission(@NonNull String permission) {
                return 0;
        }

        @Override
        public int checkCallingOrSelfPermission(@NonNull String permission) {
                return 0;
        }

        @Override
        public int checkSelfPermission(@NonNull String permission) {
                return 0;
        }

        @Override
        public void enforcePermission(@NonNull String permission, int pid, int uid, @Nullable String message) {

        }

        @Override
        public void enforceCallingPermission(@NonNull String permission, @Nullable String message) {

        }

        @Override
        public void enforceCallingOrSelfPermission(@NonNull String permission, @Nullable String message) {

        }

        @Override
        public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {

        }

        @Override
        public void revokeUriPermission(Uri uri, int modeFlags) {

        }

        @Override
        public void revokeUriPermission(String toPackage, Uri uri, int modeFlags) {

        }

        @Override
        public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
                return 0;
        }

        @Override
        public int checkCallingUriPermission(Uri uri, int modeFlags) {
                return 0;
        }

        @Override
        public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
                return 0;
        }

        @Override
        public int checkUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags) {
                return 0;
        }

        @Override
        public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {

        }

        @Override
        public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {

        }

        @Override
        public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {

        }

        @Override
        public void enforceUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags, @Nullable String message) {

        }

        @Override
        public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
                return null;
        }

        @Override
        public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
                return null;
        }

        @Override
        public Context createConfigurationContext(@NonNull Configuration overrideConfiguration) {
                return null;
        }

        @Override
        public Context createDisplayContext(@NonNull Display display) {
                return null;
        }

        @Override
        public Context createDeviceProtectedStorageContext() {
                return null;
        }

        @Override
        public boolean isDeviceProtectedStorage() {
                return false;
        }
}