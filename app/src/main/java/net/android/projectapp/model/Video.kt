package net.android.projectapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Video(
    @PrimaryKey(autoGenerate = true)val id : Int,
    val image: String,
    val title: String,
    val type: String,
    val video: String
):Parcelable