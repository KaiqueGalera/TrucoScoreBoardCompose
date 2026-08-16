package br.edu.ifsp.scl.sc3046699.trucoscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import br.edu.ifsp.scl.sc3046699.trucoscoreboard.ui.theme.TrucoScoreBoardTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoreBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PlacarTruco(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PlacarTruco(modifier: Modifier = Modifier) {

    var pontosA by remember { mutableStateOf(0) }
    var pontosB by remember { mutableStateOf(0) }

    val mensagem = when {
        pontosA >= 12 -> "Equipe A venceu!"
        pontosB >= 12 -> "Equipe B venceu!"
        pontosA == 11 -> "Equipe A entrou na mão de 11!"
        pontosB == 11 -> "Equipe B entrou na mão de 11!"
        else -> ""
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Placar de Truco",
            fontSize = 28.sp
        )
    }
}