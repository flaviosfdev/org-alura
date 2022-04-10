package br.dev.flaviosf.org_alura.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.dev.flaviosf.org_alura.database.converter.Converters
import br.dev.flaviosf.org_alura.database.dao.ProductDao
import br.dev.flaviosf.org_alura.model.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao

    companion object {
        fun instance(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "orgs.db"
            ).allowMainThreadQueries()
                .build()
        }
    }

}