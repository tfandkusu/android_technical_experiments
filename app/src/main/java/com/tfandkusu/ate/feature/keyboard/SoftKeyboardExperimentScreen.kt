package com.tfandkusu.ate.feature.keyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Absolute.spacedBy(16.dp),
            ) {
            }
        }
    }
}
