package com.example.dailyquest.fragment

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.dailyquest.LeftIconText
import com.example.dailyquest.R
import com.example.dailyquest.ui.theme.DailyQuestTheme

class CreateWorkoutQuestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CreateWorkoutQuestScreen()
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateWorkoutQuestScreen() {
    DailyQuestTheme {
        Column(

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { Log.d("tngur", "뒤로가기 : ") }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
                Text(
                    text = "운동 퀘스트 생성"
                )
            }

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
                        placeholder = { Text("운동 퀘스트 제목을 입력하세요.") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

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
                        text = "목표 운동 시간",
                        icon = R.drawable.ic_launcher_foreground,
                        modifier = Modifier.fillMaxWidth()
                    )

                    val currentTime = Calendar.getInstance()
                    val timePickerState = rememberTimePickerState(
                        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
                        initialMinute = currentTime.get(Calendar.MINUTE),
                        is24Hour = true
                    )

                    TimeInput(
                        state = timePickerState,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "목표로 하는 운동 시간을 설정하세요",
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

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
                        text = "운동 요일",
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
            Spacer(modifier = Modifier.height(8.dp))

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
                        text = "헬스장 위치",
                        icon = R.drawable.ic_launcher_foreground,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Box(
                        modifier = Modifier.fillMaxWidth().height(300.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { Log.d("tngur", "퀘스트 생성") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text("운동 퀘스트 생성")
            }

            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}




@Preview
@Composable
private fun CreateWorkoutQuestScreenPreview() {
    DailyQuestTheme {
        CreateWorkoutQuestScreen()
    }
}
