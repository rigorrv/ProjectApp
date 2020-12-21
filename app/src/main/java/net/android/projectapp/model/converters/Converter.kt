package net.android.projectapp.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromString(string: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromArrayListToString(list: List<String>): String {
        return Gson().toJson(list)
    }
}