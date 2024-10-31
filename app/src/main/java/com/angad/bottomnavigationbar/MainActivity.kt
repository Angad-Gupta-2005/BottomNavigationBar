package com.angad.bottomnavigationbar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angad.bottomnavigationbar.databinding.ActivityMainBinding
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

    private fun onClickAlarmMenu() {
        binding.button.setOnClickListener {
            //    Dark toast
            MotionToast.darkToast(this,"Upload Completed! \uD83D\uDE0D",
                "Upload Completed successfully!",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))


        }
    }
}