package com.angad.bottomnavigationbar

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angad.bottomnavigationbar.databinding.ActivityMainBinding
import nl.joery.timerangepicker.TimeRangePicker
import render.animations.Attention
import render.animations.Bounce
import render.animations.Render
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class MainActivity : AppCompatActivity() {

//    Creating an instance of binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        On click alarm menu of bottom
        onClickAlarmMenu()

//        Time range picker
        binding.picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
            override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "Start time: $startTime")
            }

            override fun onEndTimeChange(endTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "End time: " + endTime.hour)
            }

            override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                Log.d("TimeRangePicker", "Duration: " + duration.hour)
            }
        })

    }

//    private fun onClickAlarmMenu() {
//        binding.button.setOnClickListener {
//            MotionToast.createToast(this,
//                "No Internet 😍",
//                "Please check your connection",
//                MotionToastStyle.NO_INTERNET,
//                MotionToast.GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
//                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))
//
//        }
//    }

//    private fun onClickAlarmMenu() {
//        binding.button.setOnClickListener {
//            //    Dark toast
//            MotionToast.darkToast(this,"Upload Completed! \uD83D\uDE0D",
//                "Upload Completed successfully!",
//                MotionToastStyle.SUCCESS,
//                MotionToast.GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
//                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))
//
//        }
//    }


//    Android Animation
    private fun onClickAlarmMenu() {
        binding.button.setOnClickListener {
        // Create Render Class
            val render = Render(this)

        // Set Animation
            render.setAnimation(Attention().Shake(binding.button))
            render.start()

        }
    }

}