package br.edu.ifsp.scl.sc3046699.trucoscoreboard

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
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
                            .background(Color(0xff121826))
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
    val maoDeOnzeA      = pontosA == 11
    val maoDeOnzeB      = pontosB == 11

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Placar de Truco",
            fontSize = 41.sp,
            modifier = Modifier.padding(top = 40.dp),
            color = Color(0xFFF8FAFC)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
            Text(
                text = "Equipe A",
                fontSize = 35.sp,
                color = Color(0xFFF8FAFC)
            )

            Text(
                text = pontosA.toString(),
                fontSize = 45.sp,
                color = Color(0xFFF8FAFC)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Button(
                    onClick = {
                        if (!jogoFinalizado) {
                            pontosA ++
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff2563EB)
                    )
                ) {
                    Text("+1",
                        fontSize = 20.sp)
                }

                Button(
                    onClick = {
                        if (!jogoFinalizado && !maoDeOnzeA) {
                            pontosA += 3
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff2563EB)
                    )
                ) {
                    Text("+3",
                        fontSize = 20.sp)
                }
            }
        }

        Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                text = "Equipe B",
                fontSize = 35.sp,
                color = Color(0xFFF8FAFC)
            )

            Text(
                text = pontosB.toString(),
                fontSize = 45.sp,
                color = Color(0xFFF8FAFC)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Button(
                    onClick = {
                        if (!jogoFinalizado) {
                            pontosB ++
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff2563EB)
                    )
                ) {
                    Text("+1",
                        fontSize = 20.sp)
                }
                Button(
                    onClick = {
                        if (!jogoFinalizado && !maoDeOnzeB) {
                            pontosB += 3
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff2563EB)
                    )
                ) {
                    Text(
                        text = "+3",
                        fontSize = 20.sp)
                }
            }
        }

        if (mensagem.isNotEmpty()) {
            Text(
                text = mensagem,
                fontSize = 20.sp,
                color = Color(0xff2563EB)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Button(
                onClick = {
                    pontosA = 0
                    pontosB = 0
                },
                modifier = Modifier.padding(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFeab34d)
                )
            ) {
                Text("Reiniciar",
                    fontSize = 20.sp,
                    color = Color(0xff0F172A))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlacarTrucoPreview() {
    TrucoScoreBoardTheme {
        PlacarTruco()
    }
}