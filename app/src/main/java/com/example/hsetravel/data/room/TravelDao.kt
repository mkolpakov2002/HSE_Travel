package com.example.hsetravel.data.room

import androidx.room.*
import com.example.hsetravel.Constants
import com.example.hsetravel.data.ExcursionObject
import com.example.hsetravel.data.TravelObject
import kotlinx.coroutines.flow.Flow

@Dao
interface TravelDao {

    @Query("SELECT * FROM ${Constants.TRAVEL_TABLE_NAME}")
    fun getExcursionsData(): Flow<List<TravelObject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(excursionObject: TravelObject)

    @Update
    fun update(excursionObject: TravelObject)

    @Delete
    fun delete(excursionObject: TravelObject)

    @Query("DELETE FROM ${Constants.TRAVEL_TABLE_NAME}")
    suspend fun deleteAll()

}