package com.tfandkusu.ate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfandkusu.ate.component.MyTopAppBar
import com.tfandkusu.ate.theme.MyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                Scaffold(
                    topBar = {
                        MyTopAppBar(title = {
                            Text(text = stringResource(id = R.string.app_name))
                        })
                    },
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = innerPadding,
                    ) {
                        items(20) {
                            Text(
                                text = "Item $it",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}
