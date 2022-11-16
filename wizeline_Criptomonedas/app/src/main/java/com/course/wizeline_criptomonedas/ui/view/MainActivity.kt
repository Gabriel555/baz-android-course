package com.course.wizeline_criptomonedas.ui.view

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.databinding.ActivityMainBinding
import com.course.wizeline_criptomonedas.ui.viewmodel.BitsoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private val bitsoViewModel: BitsoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screenSplash = installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        navHostFragment = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView))
            as NavHostFragment
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition { false }

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (bitsoViewModel.isLoading.value == false) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }
}
