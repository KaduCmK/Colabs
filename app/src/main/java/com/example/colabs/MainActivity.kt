package com.example.colabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colabs.ui.theme.ColabsTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column (modifier = Modifier.weight(1f)){
            Text(text = "PV", style = MaterialTheme.typography.titleMedium)
            Text(text = "Kadu", style = MaterialTheme.typography.titleMedium)
            Text(text = "Pororonga")
            Text(text = "Carlos")
            Text(text = "Luan")
            Text(text = "Yuri")
            Text(text = "Amin", style = MaterialTheme.typography.titleSmall)
            Text(text = "Cucamonga", style = MaterialTheme.typography.titleSmall)

            Text(text = LocalDateTime.now().toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColabsTheme {
        Greeting("Android")
    }
}