package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import cl.inacap.carroproductos.dto.Producto;

public class VerProductoActivity extends AppCompatActivity {
    private TextView nombreTxt;
    private Toolbar toolbar;
    private ImageView imagenProd;
    private TextView descProd;
    private TextView precioProd;
    private TextView tituloToolbar;


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto2);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.nombreTxt = findViewById(R.id.nombreProdTxt);
        this.imagenProd = findViewById(R.id.image_prod_view);
        this.descProd = findViewById(R.id.desc_prod_view);
        this.precioProd = findViewById(R.id.precio_prod_view);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.tituloToolbar = findViewById(R.id.titulo_toolbar);
        if(getIntent() != null){
            // Se envían cosas y vengo de otro activity
            Producto producto = (Producto) getIntent().getSerializableExtra("producto");
            this.tituloToolbar.setText(producto.getNombre());
            this.nombreTxt.setText(producto.getNombre());
            Picasso.get().load(producto.getFoto()).resize(500,500).centerCrop().into(this.imagenProd);
            this.descProd.setText(producto.getDescripcion());
            this.precioProd.setText("$" + producto.getPrecio());
        }
    }
}