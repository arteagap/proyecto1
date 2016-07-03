package project.test.com.ciclovidaacivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String ENTRADA="ENTRADA";
    public static final int REQUES_CAPTURA_IMAGEN = 123;
    public static final int REQUEST_CONSULTA = 345;
    public static final String RESPUESTA = "RESPUESTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void llamarAcivity2(View view) {
        Intent intent=new Intent(getApplicationContext(),ActivityB.class);
        startActivity(intent);
    }

    public void tomarfoto(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUES_CAPTURA_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("Camara","requesCode " + requestCode );
        Log.d("Camara","resultCode " + resultCode );

        switch (requestCode)
        {
            case REQUES_CAPTURA_IMAGEN:
                if (resultCode==RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.imgCamara);
                    imageView.setImageBitmap(bitmap);
                }
                break;
            case REQUEST_CONSULTA:
                if (resultCode==RESULT_OK){
                    Log.d("","Respuesta de Activiy C: " + data.getStringExtra(RESPUESTA));
                }
                break;
        }


    }

    public void llamarAcivityResult(View view) {
        EditText editText=(EditText) findViewById(R.id.txt1);
        String campoEntrada=editText.getText().toString();

        Intent intent=new Intent(getApplicationContext(),ActivityResult.class);
        intent.putExtra(ENTRADA,campoEntrada);
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_CONSULTA);
    }
}
