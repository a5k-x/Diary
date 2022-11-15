package com.a5k.diary.data.datasource

import com.a5k.diary.domain.entity.Task
import kotlinx.coroutines.flow.Flow

interface DataSource {

    fun getTask(id: Int): Task

    fun getFlowTask(): Flow<List<Task>>

    fun updateTask(task: Task)

    fun deleteTask(id: Int)
}