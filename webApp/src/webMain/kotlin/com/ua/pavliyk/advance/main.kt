package com.ua.pavliyk.advance

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.ua.pavliyk.advance.di.initKoin
import com.ua.pavliyk.advance.presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin { printLogger() }
    ComposeViewport {
        App()
    }
}