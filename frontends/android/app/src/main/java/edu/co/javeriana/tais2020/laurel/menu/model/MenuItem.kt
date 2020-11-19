package edu.co.javeriana.tais2020.laurel.menu.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "menu_items")
data class MenuItem(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val icon: String,
        val alertCount: Int
): Parcelable