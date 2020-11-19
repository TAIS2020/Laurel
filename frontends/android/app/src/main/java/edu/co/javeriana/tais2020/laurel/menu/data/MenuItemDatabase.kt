package edu.co.javeriana.tais2020.laurel.menu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.co.javeriana.tais2020.laurel.menu.model.MenuItem

@Database(entities = [MenuItem::class], version = 1, exportSchema = false)
abstract class MenuItemDatabase: RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao

    companion object{
        @Volatile
        private var INSTANCE: MenuItemDatabase? = null

        fun getDatabase(context: Context): MenuItemDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MenuItemDatabase::class.java,
                    "menu_item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}