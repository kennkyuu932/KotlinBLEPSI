package com.example.kotlinblepsi

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.kotlinblepsi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        Log.d(TAG, "LibTest: "+LibTest())
    }

    /**
     * A native method that is implemented by the 'kotlinblepsi' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun LibTest(): Int

    companion object {
        // Used to load the 'kotlinblepsi' library on application startup.
        init {
            System.loadLibrary("kotlinblepsi")
        }
    }
}