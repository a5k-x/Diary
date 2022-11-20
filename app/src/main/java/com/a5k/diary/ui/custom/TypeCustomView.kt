package com.a5k.diary.ui.custom

interface TypeCustomView {

    fun getType(): CustomType
}

enum class CustomType{
    CALENDAR,
    TASK
}