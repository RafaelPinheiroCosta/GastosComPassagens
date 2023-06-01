package com.example.gastoscompassagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.gastoscompassagens.ui.theme.GastosComPassagensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GastosComPassagensTheme {
                AppPassagens()
            }
        }
    }
}
@Preview
@Composable
fun AppPassagens(){

    var qtdDiasDeViagem by remember { mutableStateOf("")}
    var qtdDePassagens by remember { mutableStateOf("")}

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Gastos com Passagem por Mês",
            textAlign = Alignment.CenterHorizontally
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QtdDiasPassagens(
                value = qtdDiasDeViagem,
                onValueChange = {qtdDiasDeViagem = it},
                label = "Quantidade de Viagens"
            )
            QtdDiasPassagens(
                value = qtdDePassagens,
                onValueChange = {qtdDePassagens = it},
                label = "Quantidade de Passagens"
            )
        }

    }
}
@Composable
fun QtdDiasPassagens(
    value:String,
    onValueChange:()->Unit,
    label:String
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label)}
    )
}
@Composable
fun ValorDasPassagens(
    qtdPassagens:Int
){
    var valorDaPassagem by remember { mutableStateOf(0)}

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        for(x in 1..qtdPassagens){
            valorDaPassagem += QtdPassagens(x)
        }
    }
}

@Composable
fun QtdPassagens(
    passagemAtual:Double
):Int{
    var valorIda by remember { mutableStateOf("")}
    var valorVolta by remember { mutableStateOf("")}
    Text(text = "Passagem $passagemAtual")
    Row() {
        TextField(
            value = valorIda,
            onValueChange ={valorIda = it},
            label = { Text(text = "Ida")}
        )
        TextField(
            value = valorVolta,
            onValueChange = {valorVolta = it},
            label = { Text(text = "Volta")}
        )
    }
    return valorIda + valorVolta
}