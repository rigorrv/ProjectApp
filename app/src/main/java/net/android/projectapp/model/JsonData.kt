package net.android.projectapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class JsonData(
    @PrimaryKey
    val video: List<Video>,
    val visit: Visit
):Parcelable