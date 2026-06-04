package com.ua.pavliyk.advance.presentation

import androidx.compose.runtime.Immutable
import com.ua.pavliyk.advance.data.posts.model.responses.Post

@Immutable
internal data class AppState(
    val isProgressVisible: Boolean = false,
    val posts: List<Post> = emptyList(),
    val result: String? = null,
    val error: String? = null,
)