package com.devvin.workmanagerapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.devvin.workmanagerapplication.UploadWorker.Companion.KEY_COUNT
import com.devvin.workmanagerapplication.UploadWorker.Companion.KEY_DATE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_start).setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest() {
        val workManager = WorkManager.getInstance(applicationContext)

        val constraints = Constraints.Builder()     //specify the execution conditions
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val data = Data.Builder()       //pass to WorkRequest
            .putInt(KEY_COUNT,23)
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .addTag("oneTimeWorkRequest")
            .setInputData(data)
            .build()

        workManager.enqueue(oneTimeWorkRequest)
        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, Observer {
                findViewById<TextView>(R.id.tv_workState).text = it.state.name
                if(it.state.isFinished){
                    val data = it.outputData
                    val msg = data.getString(KEY_DATE)
                    Log.i("MainActivity",msg!!)
                    Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
                }
            })
    }
}