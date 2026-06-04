package com.ua.pavliyk.advance.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ua.pavliyk.advance.ui.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App(
    viewModel: AppViewModel = koinViewModel(),
) {
    AppTheme {

        val state by viewModel.state.collectAsStateWithLifecycle()

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .systemBarsPadding()
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppContent(
                state = state,
                onGet = { viewModel.fetchPosts() },
                onPost = { viewModel.createPost() },
                onPut = { viewModel.updatePost() },
                onDelete = { viewModel.deletePost() }
            )
        }
    }
}

@Composable
private fun AppContent(
    state: AppState,
    onGet: () -> Unit,
    onPost: () -> Unit,
    onPut: () -> Unit,
    onDelete: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                modifier = Modifier.weight(1F),
                onClick = { onGet() }
            ) {
                Text("GET")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier.weight(1F),
                onClick = { onPost() }
            ) {
                Text("POST")
            }


        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                modifier = Modifier.weight(1F),
                onClick = { onPut() }
            ) {
                Text("PUT")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier.weight(1F),
                onClick = { onDelete() }
            ) {
                Text("DELETE")
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        if (state.isProgressVisible) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        state.result?.let {
            val scrollState = rememberScrollState()
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                text = it,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        state.error?.let {
            val scrollState = rememberScrollState()
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red,
                text = it
            )
        }
    }
}

@Preview
@Composable
private fun AppContentPreview() {
    AppContent(AppState(), {}, {}, {}, {})
}