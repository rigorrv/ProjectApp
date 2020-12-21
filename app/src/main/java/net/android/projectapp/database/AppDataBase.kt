package net.android.projectapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.android.projectapp.model.JsonData
import net.android.projectapp.model.converters.VideoConverter
import net.android.projectapp.model.converters.VisitConverters

@Database(entities = [JsonData::class], version = 1)
@TypeConverters(
    VisitConverters::class,
    VideoConverter::class
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun postDao(): PostDao
}