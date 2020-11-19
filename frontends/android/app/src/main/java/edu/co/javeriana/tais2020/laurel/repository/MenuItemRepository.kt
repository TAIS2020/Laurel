package edu.co.javeriana.tais2020.laurel.repository

import androidx.lifecycle.LiveData
import edu.co.javeriana.tais2020.laurel.menu.data.MenuItemDao
import edu.co.javeriana.tais2020.laurel.menu.model.MenuItem

class MenuItemRepository(private val menuItemDao: MenuItemDao) {
    val readAllData: LiveData<List<MenuItem>> = menuItemDao.readAllData()

    suspend fun addMenuItem(menuItem: MenuItem) {
        menuItemDao.addMenuItem(menuItem)
    }
}