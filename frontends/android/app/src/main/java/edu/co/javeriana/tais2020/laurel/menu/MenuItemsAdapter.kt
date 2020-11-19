package edu.co.javeriana.tais2020.laurel.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.javeriana.tais2020.laurel.R
import edu.co.javeriana.tais2020.laurel.menu.model.MenuItem

class MenuItemsAdapter(private val clickListener: OnMenuItemClickListener): RecyclerView.Adapter<MenuItemsAdapter.MyViewHolder>() {

    private var menuItemList = emptyList<MenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false))
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(menuItemList[position])
        holder.itemView.setOnClickListener{
            clickListener?.onMenuItemClick(menuItemList[position])
        }
    }

    fun setMenuItems(menuItems: List<MenuItem>) {
        this.menuItemList = menuItems
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var menuItemTextView: TextView? = null
        private var alertCountTextView: TextView? = null

        init {
            menuItemTextView = itemView.findViewById(R.id.menu_item_tx)
            alertCountTextView = itemView.findViewById(R.id.alert_badge)
        }

        fun bind(menuItem: MenuItem) {
            val identifier = itemView.resources.getIdentifier(menuItem.icon, "drawable", itemView.context.packageName)
            menuItemTextView?.text = menuItem.name
            menuItemTextView?.setCompoundDrawablesWithIntrinsicBounds(identifier, 0, 0, 0);

            if (menuItem.alertCount == 0) {
                alertCountTextView?.visibility= View.INVISIBLE
            } else {
                alertCountTextView?.visibility= View.VISIBLE
                alertCountTextView?.text = menuItem.alertCount.toString()
            }
        }
    }

    interface OnMenuItemClickListener {
        fun onMenuItemClick(menuItem: MenuItem)
    }
}