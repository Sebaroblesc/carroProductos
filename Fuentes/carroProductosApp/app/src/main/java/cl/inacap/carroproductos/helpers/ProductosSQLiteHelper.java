package cl.inacap.carroproductos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductosSQLiteHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE " +
            "productos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
            ",nombre TEXT" +
            ",descripcion TEXT" +
            ",foto TEXT" +
            ",precio INTEGER)";

    public ProductosSQLiteHelper(@Nullable Context context, @Nullable String name
            , @Nullable SQLiteDatabase.CursorFactory factory
            , int version) {
        super(context, name, factory, version);
    }

    /**
     * Creacion de la tabla productos (una sola vez)
      * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(sqlCreate);
    db.execSQL("INSERT INTO productos (nombre,descripcion,precio,foto)" +
            "VALUES('Coca-Cola Zero','Coca Pulenta', 1000, 'https://img1.freepng.es/20180629/foh/kisspng-coca-cola-fizzy-drinks-diet-coke-fanta-coca-cola-zero-5b36222872f3c1.5500892715302743444709.jpg')");
    db.execSQL("INSERT INTO productos (nombre,descripcion,precio,foto)" +
            "VALUES ('Helado Savory','Desde la bd',400,'https://www.savory.cl/sites/default/files/mega_manjar-galletas.png')");

    }

    /**
     * Aqui se hacen los cambios necesarios cuando hay un cambio de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS productos");
    db.execSQL(sqlCreate);
    }
}
