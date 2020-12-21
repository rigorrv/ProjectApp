package net.android.projectapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Visit(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val background: String,
    val image: String,
    val info: String,
    val title: String
) : Parcelable