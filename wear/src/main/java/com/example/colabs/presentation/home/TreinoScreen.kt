package com.example.colabs.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.colabs.presentation.theme.ColabsTheme

@Composable
fun TreinoScreen(modifier: Modifier = Modifier) {
    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        items(8) {
            Chip(
                modifier = Modifier
                    .width(140.dp)
                    .padding(top = 4.dp),
                icon = {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                },
                label = {
                    Text(text = "Item $it")
                },
                onClick = {}
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
private fun TreinoScreenPreview() {
    ColabsTheme {
        TreinoScreen()
    }
}