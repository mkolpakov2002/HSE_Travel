package com.example.hsetravel.data.room

import androidx.room.*
import com.example.hsetravel.Constants.Companion.EXCURSION_TABLE_NAME
import com.example.hsetravel.data.ExcursionObject
import kotlinx.coroutines.flow.Flow

@Dao
interface ExcursionDao {

    @Query("SELECT * FROM $EXCURSION_TABLE_NAME")
    fun getExcursionsData(): Flow<List<ExcursionObject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(excursionObject: ExcursionObject)

    @Update
    fun update(excursionObject: ExcursionObject)

    @Delete
    fun delete(excursionObject: ExcursionObject)

    @Query("DELETE FROM $EXCURSION_TABLE_NAME")
    suspend fun deleteAll()


}
