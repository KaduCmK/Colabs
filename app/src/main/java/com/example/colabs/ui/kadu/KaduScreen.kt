package com.example.colabs.ui.kadu

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.colabs.ui.theme.ColabsTheme

@Composable
fun KaduScreen(
    onBackPressed: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    
    VerticalPager(
        state = pagerState
    ) {
        when (it) {
            0 -> Home(onBackPressed)
            1 -> WearTests()
        }
    }
}

@Composable
fun Home(
    onBackPressed: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Home do Kadu")
            Text(text = "para baixo: Wear sandbox")
            Button(onClick = { onBackPressed() }) {
                Text(text = "Voltar")
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview(name = "Light Mode")
@Composable
private fun KaduScreenPreview() {
    ColabsTheme {
        KaduScreen({})
    }
}

