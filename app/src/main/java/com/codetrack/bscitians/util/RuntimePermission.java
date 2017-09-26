package com.codetrack.bscitians.util;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.View;


public abstract class RuntimePermission extends AppCompatActivity {

    private SparseIntArray mErrorString;
    protected void onCreate(Bundle savesIntanceState){
        super.onCreate(savesIntanceState);
        mErrorString=new SparseIntArray();

    }

    public abstract void onPermmissionGranted(int requestCode);

    public void requestAppPermission(final String[]requestedPermissions,final int stringid,final int requestCode){
        mErrorString.put(requestCode,stringid);
        int permissionCheck= PackageManager.PERMISSION_GRANTED;
        boolean showRequestPermission=false;
        for(String permission:requestedPermissions){
            permissionCheck=permissionCheck+ ContextCompat.checkSelfPermission(this,permission);
            showRequestPermission=showRequestPermission|| ActivityCompat.shouldShowRequestPermissionRationale(this,permission);

        }

        if (permissionCheck!=PackageManager.PERMISSION_GRANTED){
            if (showRequestPermission){
                Snackbar.make(findViewById(android.R.id.content),stringid,Snackbar.LENGTH_INDEFINITE).setAction("GRANT", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    ActivityCompat.requestPermissions(RuntimePermission.this,requestedPermissions,requestCode);
                    }
                }).show();
            }else {
                ActivityCompat.requestPermissions(this,requestedPermissions,requestCode);
            }
        }else {
            onPermmissionGranted(requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        int permissionCheck=PackageManager.PERMISSION_GRANTED;
        for (int permission : grantResults)
        {
            permissionCheck=permissionCheck+permission;
        }
        if((grantResults.length > 0)&& PackageManager.PERMISSION_GRANTED==permissionCheck){
            onPermmissionGranted(requestCode);
        }else {
            Snackbar.make(findViewById(android.R.id.content),mErrorString.get(requestCode),Snackbar.LENGTH_INDEFINITE).setAction("ENABLE", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent();
                    i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    i.setData(Uri.parse("package:"+getPackageName()));
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(i);

                }
            }).show();
        }
    }
}
