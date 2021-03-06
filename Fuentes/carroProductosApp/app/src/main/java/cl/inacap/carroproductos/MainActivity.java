package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.inacap.carroproductos.adapters.ProductosArrayAdapter;
import cl.inacap.carroproductos.dao.ProductosDAO;
import cl.inacap.carroproductos.dao.ProductosDAOLista;
import cl.inacap.carroproductos.dao.ProductosDAOSQLite;
import cl.inacap.carroproductos.dto.Producto;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton agregarBtn;
    private ListView productosLv;
    private List<Producto> productos;
    private ProductosArrayAdapter adaptador;
    private ProductosDAO productosDAO = new ProductosDAOSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.agregarBtn = findViewById(R.id.agregar_btn_fb);
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CrearProductoActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        productos = productosDAO.getAll();
        adaptador = new ProductosArrayAdapter(this, R.layout.productos_list, productos);
        productosLv = findViewById(R.id.productos_lv);
        productosLv.setAdapter(adaptador);
        productosLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(MainActivity.this, VerProductoActivity.class);

                // En cual se hace Click
                Producto prodActual = productos.get(i);


                // Como se le pasa el producto
                intent.putExtra("producto", prodActual);


                startActivity(intent);
            }
        });
    }
}