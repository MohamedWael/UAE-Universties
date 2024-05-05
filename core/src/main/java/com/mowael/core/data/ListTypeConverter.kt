package com.mowael.core.data

import androidx.room.TypeConverter
import com.google.gson.Gson

object ListTypeConverter {
    @TypeConverter
    fun fromSource(source: List<String>?): String? {
        if (source == null) return null
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSource(source: String?): List<String>? {
        if (source == null) return null
        return Gson().fromJson(source, Array<String>::class.java).toList()
    }
}
