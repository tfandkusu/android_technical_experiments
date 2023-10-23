package com.tfandkusu.ate.feature.jnta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialSharedAxis
import com.tfandkusu.ate.R
import com.tfandkusu.ate.component.MyTopAppBar
import com.tfandkusu.ate.feature.jnta.args.EnumArgument
import com.tfandkusu.ate.feature.jnta.args.ParcelableArgument
import com.tfandkusu.ate.theme.MyTheme

class Screen1Fragment : Fragment() {

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
                                    Text(text = stringResource(id = R.string.screen_n, 1))
                                },
                                hasBack = true,
                                onBackPressed = {
                                    requireActivity().finish()
                                },
                            )
                        },
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .padding(16.dp),
                            verticalArrangement = spacedBy(16.dp),
                        ) {
                            Button(
                                onClick = {
                                    exitTransition = null
                                    reenterTransition = null
                                    findNavController().navigate(
                                        Screen1FragmentDirections.actionScreen2(
                                            EnumArgument.Melon,
                                        ),
                                    )
                                },
                            ) {
                                Text(text = stringResource(id = R.string.open_screen_n, 2))
                            }
                            Button(
                                onClick = {
                                    exitTransition = MaterialSharedAxis(
                                        MaterialSharedAxis.X, true,
                                    )
                                    reenterTransition = MaterialSharedAxis(
                                        MaterialSharedAxis.X, false,
                                    )
                                    findNavController().navigate(
                                        Screen1FragmentDirections.actionScreen3(
                                            ParcelableArgument(
                                                id = 7,
                                                name = "Pear",
                                            ),
                                        ),
                                    )
                                },
                            ) {
                                Text(text = stringResource(id = R.string.open_screen_n, 3))
                            }
                        }
                    }
                }
            }
        }
    }
}
