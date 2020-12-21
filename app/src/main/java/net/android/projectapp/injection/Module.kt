package net.android.projectapp.injection

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import net.android.projectapp.database.AppDataBase
import net.android.projectapp.database.PostDao
import net.android.projectapp.network.Api
import net.android.projectapp.viewmodel.MyViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    fun apiProvider(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
    single {
        apiProvider(get())
    }
}

val networkModule = module {

    fun networkProvider(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl("https://notificationapp-20f51.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    single {
        networkProvider()
    }
}

val dataBaseModule = module {

    fun appdataBaseProvider(application: Application): AppDataBase {
        return Room.databaseBuilder(application, AppDataBase::class.java, "post")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun postDaoProvider(appDataBase: AppDataBase): PostDao {
        return appDataBase.postDao()
    }
    single { appdataBaseProvider(androidApplication()) }
    single { postDaoProvider(get()) }
}

val viewModelModule = module {

    viewModel {
        MyViewModel(get(), get())
    }
}

