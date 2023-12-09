package com.tfandkusu.ate.feature.keyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
            var text by remember { mutableStateOf("") }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Absolute.spacedBy(16.dp),
            ) {
                item {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = text, onValueChange = {
                            text = it
                        }, maxLines = 1
                    )
                }
            }
        }
    }
}
