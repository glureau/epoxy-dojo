package com.glureau.epoxy.dojo.data

import android.content.Context
import com.glureau.epoxy.dojo.R
import com.glureau.epoxy.dojo.data.dto.Launch
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.BufferedReader
import java.io.InputStreamReader

class DataRepository {
    fun getSpaceXLaunches(context: Context): List<Launch>? {
        val inputStream = context.resources.openRawResource(R.raw.spacex)
        val inputStreamReader = InputStreamReader(inputStream)
        val json = BufferedReader(inputStreamReader).readText()

        val moshi = Moshi.Builder().build()
        val parameterizedType = Types.newParameterizedType(List::class.java, Launch::class.java)
        val adapter = moshi.adapter<List<Launch>>(parameterizedType)

        return adapter.fromJson(json)
    }
}