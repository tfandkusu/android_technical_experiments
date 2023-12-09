package com.tfandkusu.ate.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfandkusu.ate.R
import com.tfandkusu.ate.component.FeatureTextButton
import com.tfandkusu.ate.component.MyTopAppBar
import com.tfandkusu.ate.feature.jnta.JetpackNavigationTransitionAnimationActivity
import com.tfandkusu.ate.feature.keyboard.SoftKeyboardExperimentActivity
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
                        verticalArrangement = spacedBy(8.dp),
                    ) {
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            FeatureTextButton(
                                nameStringResId = R.string.jetpack_navigation_transition_animation,
                                onClick = {
                                    callJetpackNavigationTransitionAnimationActivity()
                                },
                            )
                        }
                        item {
                            FeatureTextButton(
                                nameStringResId = R.string.soft_keyboard_experiment,
                                onClick = {
                                    callSoftKeyboardExperimentActivity()
                                },
                            )
                        }
                    }
                }
            }
        }
    }

    private fun callJetpackNavigationTransitionAnimationActivity() {
        val intent = Intent(
            this,
            JetpackNavigationTransitionAnimationActivity::class.java,
        )
        startActivity(intent)
    }

    private fun callSoftKeyboardExperimentActivity() {
        val intent = Intent(
            this,
            SoftKeyboardExperimentActivity::class.java,
        )
        startActivity(intent)
    }
}
