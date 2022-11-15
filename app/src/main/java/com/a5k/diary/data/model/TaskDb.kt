package com.a5k.diary.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskDb(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "data_start")val date_start: String,
    @ColumnInfo(name = "date_finish")val date_finish: String,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "description")val description: String
)
