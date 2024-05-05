package com.example.colabs

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colabs.ui.kadu.KaduScreen
import com.example.colabs.ui.theme.ColabsTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            ColabsTheme {
                NavHost(navController = navController, startDestination = "greeting") {
                    composable("greeting") { Greeting(navController = navController) }
                    composable("kadu") { KaduScreen { navController.popBackStack() } }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(onClick = { navController.navigate("kadu") }) {
                Text(text = "Kadu")
            }

            Text(text = "PV", style = MaterialTheme.typography.titleMedium)
            Text(text = "Pororonga")
            Text(text = "Carlos", style = MaterialTheme.typography.displayLarge)
            Text(text = "Luisa", style = MaterialTheme.typography.displayLarge)
            Text(text = "Luan")
            Text(text = "Yuri")
            Text(text = "Amin", style = MaterialTheme.typography.titleSmall)
            Text(text = "Cucamonga", style = MaterialTheme.typography.titleSmall)

            Text(text = LocalDateTime.now().toString())
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()

    ColabsTheme {
        Greeting(navController)
    }
}