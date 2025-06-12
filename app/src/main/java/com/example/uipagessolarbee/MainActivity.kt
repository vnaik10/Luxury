package com.example.uipagessolarbee
import InventoryDashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.uipagessolarbee.ui.theme.AppNavigation
import com.example.uipagessolarbee.ui.theme.SolarBeeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SolarBeeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    AppNavigation()
                }
            }
        }
    }
}

