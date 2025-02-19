package com.example.dailyquest

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LeftIconText(
    text: String,
    @DrawableRes icon: Int,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
    }
}


@Composable
fun CreateQuestTitle(
    textFieldHint: String,
    titleIconResource: Int,
    modifier: Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            LeftIconText(
                text = "퀘스트 제목",
                icon = R.drawable.ic_launcher_foreground,
                modifier = Modifier.fillMaxWidth()
            )

            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = textFieldHint) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun DaysToRepeat(
    titleText: String
) {
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            LeftIconText(
                text = titleText,
                icon = R.drawable.ic_launcher_foreground,
                modifier = Modifier.fillMaxWidth()
            )
            Row {
                OutlinedButton(onClick = { Log.d("tngur", "월") },modifier = Modifier.weight(1f)) {
                    Text(text = "월", textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { Log.d("tngur", "화") },modifier = Modifier.weight(1f)) {
                    Text(text = "화", textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { Log.d("tngur", "수") },modifier = Modifier.weight(1f)) {
                    Text(text = "수", textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { Log.d("tngur", "목") },modifier = Modifier.weight(1f)) {
                    Text(text = "목", textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { Log.d("tngur", "금") },modifier = Modifier.weight(1f)) {
                    Text(text = "금", textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { Log.d("tngur", "토") },modifier = Modifier.weight(1f)) {
                    Text(text = "토", textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { Log.d("tngur", "일") },modifier = Modifier.weight(1f)) {
                    Text(text = "일", textAlign = TextAlign.Center)
                }
            }
        }
    }
}