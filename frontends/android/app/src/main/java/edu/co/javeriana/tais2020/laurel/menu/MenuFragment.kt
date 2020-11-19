package edu.co.javeriana.tais2020.laurel.menu

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.javeriana.tais2020.laurel.R
import edu.co.javeriana.tais2020.laurel.login.LoginActivity
import edu.co.javeriana.tais2020.laurel.login.viewmodel.LoginViewModelFactory
import edu.co.javeriana.tais2020.laurel.menu.model.MenuItem
import edu.co.javeriana.tais2020.laurel.menu.viewmodel.MenuViewModel

class MenuFragment : Fragment(), MenuItemsAdapter.OnMenuItemClickListener {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var menuItems: List<MenuItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val adapter = MenuItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        menuItems = listOf(
                MenuItem(1, "Inicio", "ic_outline_home_24dp", 0),
                MenuItem(2, "Buscar", "ic_outline_loupe_24dp", 0),
                MenuItem(3, "Notificaciones", "ic_outline_notifications_24dp", 1),
                MenuItem(4, "Mis compras", "ic_outline_shopping_bag_24dp", 0),
                MenuItem(5, "Mi cuenta", "ic_outline_user_24dp", 0),
                MenuItem(6, "Vender", "ic_outline_tag_24dp", 0),
                MenuItem(7, "Cerrar sesión", "ic_outline_power_button_24dp", 0)
        )

        adapter.setMenuItems(menuItems)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        // MenuViewModel
//        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

    }

    override fun onMenuItemClick(menuItem: MenuItem) {
        when (menuItem.id) {
            7 -> {
                Log.d("HELLO", "Se ha elegido deslogear")
                val intent = Intent(this.context, LoginActivity::class.java)
                intent.putExtra("forceLogout", true)
                startActivity(intent)
                activity?.finish()
            }
            else -> Log.d("HELLO", "Se ha elegido ir a un fragment")
        }
    }

}