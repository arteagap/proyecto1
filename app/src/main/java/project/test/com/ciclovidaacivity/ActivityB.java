package project.test.com.ciclovidaacivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);
        Log.d("CiclodeVida", this.getLocalClassName() + " - onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CiclodeVida", this.getLocalClassName() + " - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CiclodeVida",this.getLocalClassName() + " - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CiclodeVida",this.getLocalClassName() + " - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CiclodeVida", this.getLocalClassName() + " - onDestroy");
    }

}
