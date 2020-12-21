package net.android.projectapp.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.projectapp.model.Visit

class VisitConverters {

    @TypeConverter
    fun stringToVisit(string: String): Visit {
        val type = object : TypeToken<Visit>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun visitToString(visit: Visit): String {
        val type = object : TypeToken<Visit>() {}.type
        return Gson().toJson(visit, type)
    }
}