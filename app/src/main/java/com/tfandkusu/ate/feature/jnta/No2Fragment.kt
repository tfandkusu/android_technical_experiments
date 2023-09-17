package com.tfandkusu.ate.feature.jnta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.tfandkusu.ate.R
import com.tfandkusu.ate.component.MyTopAppBar
import com.tfandkusu.ate.theme.MyTheme

class No2Fragment : Fragment() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed,
            )
            setContent {
                MyTheme {
                    Scaffold(
                        topBar = {
                            MyTopAppBar(
                                title = {
                                    Text(text = stringResource(id = R.string.screen_n, 2))
                                },
                                hasBack = true,
                                onBackPressed = {
                                    requireActivity().finish()
                                },
                            )
                        },
                    ) { innerPadding ->
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .padding(16.dp),
                            text = stringResource(id = R.string.screen_n, 2),
                        )
                    }
                }
            }
        }
    }
}
