package br.edu.ifsp.scl.sc3046699.trucoscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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

    val jogoFinalizado = pontosA >= 12 || pontosB >= 12

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

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Equipe A",
            fontSize = 24.sp
        )

        Text(
            text = pontosA.toString(),
            fontSize = 48.sp
        )

        Row {
            Button(
                onClick = {
                    if (!jogoFinalizado) {
                        pontosA = minOf(pontosA + 1, 12)
                    }
                }
            ) {
                Text("+1")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    if (!jogoFinalizado) {
                        pontosA = minOf(pontosA + 3, 12)
                    }
                }
            ) {
                Text("+3")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Equipe B",
            fontSize = 24.sp
        )

        Text(
            text = pontosB.toString(),
            fontSize = 48.sp
        )

        Row {
            Button(
                onClick = {
                    if (!jogoFinalizado) {
                        pontosB += 1
                    }
                }
            ) {
                Text("+1")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    if (!jogoFinalizado) {
                        pontosB += 3
                    }
                }
            ) {
                Text("+3")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        if (mensagem.isNotEmpty()) {
            Text(
                text = mensagem,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                pontosA = 0
                pontosB = 0
            }
        ) {
            Text("Reiniciar")
        }
    }
}


