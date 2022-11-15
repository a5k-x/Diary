package com.a5k.diary.data.datasource

import androidx.room.Dao
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.a5k.diary.data.model.TaskDb
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task WHERE id = :id")
    fun getTask(id: Int): TaskDb

    @Query("SELECT * FROM task")
    fun getFlowTask(): Flow<List<TaskDb>>

    @Update(onConflict = REPLACE)
    fun updateTask(task: TaskDb)

    @Query("DELETE FROM task WHERE id = :id")
    fun deleteTask(id: Int)
}