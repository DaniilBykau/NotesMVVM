package com.example.notes.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.models.AppNote

@Database(entities = [AppNote::class], version = 1)
abstract class AppRoomDatabase:RoomDatabase() {

    abstract fun getAppRoomDao():AppRoomDao


    companion object{

        @Volatile
        private var database:AppRoomDatabase?=null

        @Synchronized
        fun getInstance(context: Context):AppRoomDatabase{
            return if(database==null){
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                ).build()
                return database as AppRoomDatabase
            } else return database as AppRoomDatabase
        }
    }
}