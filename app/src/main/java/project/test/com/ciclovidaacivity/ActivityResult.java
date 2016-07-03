package project.test.com.ciclovidaacivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_result);

        String wmensaje= getIntent().getStringExtra(MainActivity.ENTRADA).toString();
        TextView textView=(TextView) findViewById(R.id.mensaje);
        textView.setText("Se ingreso = " + wmensaje);
    }


    public void devolverrespuesta(View view) {
        Intent intent=new Intent();
        intent.putExtra(MainActivity.RESPUESTA,"respuesta");
        setResult(RESULT_OK,intent);
        finish();
    }
}
