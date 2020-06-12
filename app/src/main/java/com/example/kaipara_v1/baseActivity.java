package com.example.kaipara_v1;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public abstract class baseActivity extends AppCompatActivity {
    private static final String TAG = "progressbar";
    public ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base,null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar);
        getLayoutInflater().inflate(layoutResID,frameLayout,true);
        super.setContentView(layoutResID);
    }

    public void showProgressBar(boolean visibility){
        Log.e(TAG, "showProgressBar: call detected "  );
        mProgressBar.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }
}
