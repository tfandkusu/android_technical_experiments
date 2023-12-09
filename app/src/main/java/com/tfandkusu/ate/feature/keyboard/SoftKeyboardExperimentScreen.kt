package com.tfandkusu.ate.feature.keyboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfandkusu.ate.R
import com.tfandkusu.ate.component.MyTopAppBar
import com.tfandkusu.ate.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoftKeyboardExperimentScreen(
    finish: () -> Unit,
) {
    MyTheme {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.soft_keyboard_experiment))
                    },
                    hasBack = true,
                    onBackPressed = finish,
                )
            },
        ) { innerPadding ->
            val density = LocalDensity.current
            val isKeyboardVisible = WindowInsets.ime.getBottom(density) > 0
            var text by remember { mutableStateOf("") }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .imePadding(),
                verticalArrangement = Arrangement.Absolute.spacedBy(16.dp),
                contentPadding = innerPadding,
            ) {
                items(20, key = { it }) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Item $it",
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = if (isKeyboardVisible) {
                            stringResource(R.string.soft_keyboard_show)
                        } else {
                            stringResource(R.string.soft_keyboard_hide)
                        },
                    )
                }
                item {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        maxLines = 1,
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = stringResource(R.string.supporting_text),
                    )
                }
            }
        }
    }
}
