package edu.co.javeriana.tais2020.laurel.menu.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import edu.co.javeriana.tais2020.laurel.menu.model.MenuItem
import edu.co.javeriana.tais2020.laurel.menu.data.MenuItemDatabase
import edu.co.javeriana.tais2020.laurel.repository.MenuItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<MenuItem>>
    private val repository: MenuItemRepository

    init {
        val menuItemDao = MenuItemDatabase.getDatabase(application).menuItemDao()
        repository = MenuItemRepository(menuItemDao)
        readAllData = repository.readAllData
    }

    fun addMenuItem(menuItem: MenuItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMenuItem(menuItem)
        }
    }
}