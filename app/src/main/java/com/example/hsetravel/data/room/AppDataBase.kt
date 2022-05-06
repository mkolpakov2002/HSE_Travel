package com.example.hsetravel.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hsetravel.Constants.Companion.DATABASE_NAME
import com.example.hsetravel.data.ExcursionObject
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [
        ExcursionObject::class
    ],
    version = 1
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun excursionDao() : ExcursionDao

    abstract fun travelDao() : TravelDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DATABASE_NAME
                )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}
