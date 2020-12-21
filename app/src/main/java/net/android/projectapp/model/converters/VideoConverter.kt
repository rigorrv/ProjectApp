package net.android.projectapp.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.projectapp.model.Video

class VideoConverter {

    @TypeConverter
    fun stringToVideo(string: String?): List<Video>? {
        val type = object : TypeToken<List<Video?>?>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun videoToString(video: List<Video?>?): String? {
        val type = object : TypeToken<List<Video?>?>() {}.type
        return Gson().toJson(video, type)
    }
}