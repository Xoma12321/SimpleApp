package com.mirea.kt.simpleapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private TextView tvTextView;
    private TextView tvFIO;
    private TextView tvGROUP;
    private TextView tvVARIANT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStartActivity);
        tvTextView = findViewById(R.id.tvText);
        btnStart.setOnClickListener(this);
        tvFIO = findViewById(R.id.tvFIO);
        tvGROUP = findViewById(R.id.tvGROUP);
        tvVARIANT = findViewById(R.id.tvVARIANT);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStartActivity) {
            Intent intent = new Intent(this, CalcActivity.class);
            activityResultLaunch.launch(intent);
//            Uri uriLocation = Uri.parse("geo:55.754283,37.62002");
//            Intent newIntent = new Intent(Intent.ACTION_VIEW);
//            newIntent.setData(uriLocation);
//            startActivity(newIntent);
        }
    }


    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null) {
                        ViewGroup parentLayout = findViewById(R.id.parentLayout);
                        parentLayout.removeView(tvVARIANT);
                        parentLayout.removeView(tvFIO);
                        parentLayout.removeView(tvGROUP);
                        double res = result.getData().getDoubleExtra("data", 0);
                        Log.d("simple_app_tag", "Result" + res);
                        tvTextView.setText("Ответ: " + res);
                    }
                }

            });


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 12345){
//            if(data != null){
//                int res = data.getIntExtra("data",0);
//                Log.d("simple_app_tag","Result" + res);
//                tvTextView.setText("Сумма чисел: " + res);
//            }
//        }
//    }
}