package edu.co.javeriana.tais2020.laurel.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.co.javeriana.tais2020.laurel.model.MenuItem

@Dao
interface MenuItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMenuItem(menuItem: MenuItem)

    @Query("SELECT * FROM menu_items ORDER BY id ASC")
    fun readAllData(): LiveData<List<MenuItem>>
}