/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.colabs.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.TimeText
import com.example.colabs.presentation.home.HomeScreen
import com.example.colabs.presentation.home.LeftScreen
import com.example.colabs.presentation.home.RightScreen
import com.example.colabs.presentation.home.TreinoScreen
import com.example.colabs.presentation.theme.ColabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            val pagerState = rememberPagerState(initialPage = 1, pageCount = { 3 })

            ColabsTheme {
                WearApp(horizontalPagerState = pagerState)
            }
        }
    }
}

@Composable
fun WearApp(horizontalPagerState: PagerState) {
    Scaffold(
        timeText = { TimeText() }
    ) {
        val verticalPagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
        VerticalPager(state = verticalPagerState) {verticalPage ->
            when (verticalPage) {
                0 -> {
                    HorizontalPager(state = horizontalPagerState) {
                        when (it) {
                            0 -> LeftScreen()
                            1 -> HomeScreen()
                            2 -> RightScreen()
                        }

                    }
                }
                1 -> TreinoScreen()
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp(object : PagerState() {
        override val pageCount: Int
            get() = 2

    })
}