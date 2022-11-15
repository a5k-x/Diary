package com.a5k.diary.data.datasource

import com.a5k.diary.data.database.AppDatabase
import com.a5k.diary.domain.entity.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    appDatabase: AppDatabase
): DataSource {

    val db = appDatabase.getTaskDao()

    override fun getTask(id: Int): Task {
        TODO("Not yet implemented")
    }

    override fun getFlowTask(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

    override fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(id: Int) {
        TODO("Not yet implemented")
    }
}