package com.ua.pavliyk.advance

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ua.pavliyk.advance.di.initKoin
import com.ua.pavliyk.advance.presentation.App

fun main() = application {
    initKoin { printLogger() }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Advance",
    ) {
        App()
    }
}