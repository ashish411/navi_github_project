package com.example.naviGithubProject.utils

import android.text.TextUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Utility {

    private const val TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    fun convertTimeToReadableFormat(time: String?): String{
        if (TextUtils.isEmpty(time))
            return "NA"
        val pattern = DateTimeFormatter.ofPattern(TIME_FORMAT)
        return LocalDate.parse(time,pattern).toString()
    }

}