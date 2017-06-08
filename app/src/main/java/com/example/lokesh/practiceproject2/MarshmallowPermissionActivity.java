package com.example.lokesh.practiceproject2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MarshmallowPermissionActivity extends AppCompatActivity {

    private String TAG="LokeshMPA";
    private Button btClickButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marshmallow_permission);

    }


    public void checkPermission(View ve) {
        // here checking permissions, following block will be true when permission is not granted
        // you can also check multiple permissions wether permission is granted or not. I checked only one permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            //Following if block will be executed when permission canceled by user after firsttime.
            //Note: First time the following if block will not be executed.
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                // here you can give your dialog with ok and canel buttons,when ok clicked,again request(ask) permission
                //i.e.,  ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
            }
        }else{

            // request permissions
            // you can also request two or more permissions in String[]{1,2,3,4}. Here I gave only one permission
            // i.e.    new String[1]
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
        }
    }


    // this method will be called after permissions dialog closed.
    // If permission granted ,permissions results will be sent to 'grantResult' parameter in following method.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults.length > 0  & grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted for "+permissions[i], Toast.LENGTH_SHORT).show();
                }
            }

        }
    }


}
