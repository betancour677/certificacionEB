package com.example.zapateria_unica.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat



private lateinit var binding:

 fun onCreate(savedInstanceState: Bundle?) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
}