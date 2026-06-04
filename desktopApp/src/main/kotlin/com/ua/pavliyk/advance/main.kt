package com.ua.pavliyk.advance

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ua.pavliyk.advance.di.initKoin
import com.ua.pavliyk.advance.presentation.App
import com.ua.pavliyk.advance.ui.theme.AppTheme


fun main() = application {
        initKoin { printLogger() }
        Window(
            onCloseRequest = ::exitApplication,
            title = "Advance",
        ) {
            App()
        }
}