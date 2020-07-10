package org.senac.boaviagem.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.senac.boaviagem.domain.Viagem
import org.senac.gabrielkraetzer.boaviagem.data.Dao.ViagemDao


@Database(
    entities = arrayOf(Viagem::class),
    version = 1, exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    abstract fun viagemDao() : ViagemDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDataBase(context: Context) : DataBase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            } else {
                synchronized(this){
                    val instance  = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "BoaViagem_db"
                    ).build()
                    INSTANCE = instance

                    return instance;
                }
            }
        }
    }
}