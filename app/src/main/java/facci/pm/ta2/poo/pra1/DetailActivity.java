package facci.pm.ta2.poo.pra1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import facci.pm.ta2.poo.datalevel.DataException;
import facci.pm.ta2.poo.datalevel.DataObject;
import facci.pm.ta2.poo.datalevel.DataQuery;
import facci.pm.ta2.poo.datalevel.GetCallback;

public class DetailActivity extends AppCompatActivity {

    TextView price,description,serie1,marca2,modelo3,sistema4;
    ImageView thumbnail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Aqui cambio
        price = findViewById(R.id.price);

        serie1 = findViewById(R.id.serie1);
        marca2 = findViewById(R.id.marca2);
        modelo3 = findViewById(R.id.modelo3);
        sistema4 = findViewById(R.id.sistema4);

        description = findViewById(R.id.description);
        thumbnail = findViewById(R.id.thumbnail);







        //Fin
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PR1 :: Detail");


        //Aqui cambie

        String object_id = getIntent().getStringExtra("object_id");

        DataQuery query = DataQuery.get("item");
        query.getInBackground(object_id , new GetCallback<DataObject>() {
            @Override
            public void done(DataObject object, DataException e) {
                if (e == null) {
                    String prices = object.get("price")+"$";
                    String desc = (String)object.get("description");

                    String serie = (String)object.get("serie");
                    String marca = (String)object.get("marca");
                    String modelo = (String)object.get("modelo");


                    description.setText(desc);
                    price.setText(prices);
                    serie1.setText(serie);
                    marca2.setText(marca);
                    modelo3.setText(modelo);
                    thumbnail.setImageBitmap((Bitmap) object.get("image"));
                } else {
                    Toast.makeText(DetailActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    // Error
                }
            }
        });

        //Fin

    }

}
