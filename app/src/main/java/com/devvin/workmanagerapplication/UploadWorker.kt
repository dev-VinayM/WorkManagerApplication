package com.devvin.workmanagerapplication

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    private val TAG = "UploadWorker"

    companion object{
        const val KEY_COUNT = "key_count"
        const val KEY_DATE = "key_date"
    }

    override fun doWork(): Result {
        return try {
            val count = inputData.getInt(KEY_COUNT,0)
            for (i in 0..count) {
                Log.i(TAG, "working $i")
            }
            val time = SimpleDateFormat("dd/mm/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            val outputData = Data.Builder()
                .putString(KEY_DATE,currentDate)
                .build()

            Result.success(outputData)
        } catch (e: Exception) {
            Result.failure()
        }
    }
}