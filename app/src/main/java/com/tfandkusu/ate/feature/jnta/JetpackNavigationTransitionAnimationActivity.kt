package com.tfandkusu.ate.feature.jnta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import com.tfandkusu.ate.R

class JetpackNavigationTransitionAnimationActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jetpack_navigation_transition_animation)
    }
}
