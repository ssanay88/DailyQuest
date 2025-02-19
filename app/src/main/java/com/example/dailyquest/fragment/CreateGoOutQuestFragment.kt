package com.example.dailyquest.fragment

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.dailyquest.CreateQuestTitle
import com.example.dailyquest.DaysToRepeat
import com.example.dailyquest.LeftIconText
import com.example.dailyquest.R
import com.example.dailyquest.ui.theme.DailyQuestTheme

class CreateGoOutQuestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CreateGoOutQuestScreen()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateGoOutQuestScreen() {
    DailyQuestTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
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
                    text = "외출 퀘스트 생성"
                )
            }

            CreateQuestTitle(
                textFieldHint = "외출 퀘스트 제목을 입력하세요.",
                titleIconResource = R.drawable.ic_launcher_foreground,
                modifier = Modifier
            )

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
                        text = "외출 데드라인",
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
                }
            }

            DaysToRepeat(titleText = "반복 요일")
            
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
                        text = "집 위치",
                        icon = R.drawable.ic_launcher_foreground,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Box(
                        modifier = Modifier.fillMaxWidth().height(300.dp)
                    )
                }
            }

            Button(
                onClick = { Log.d("tngur", "퀘스트 생성") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text("외출 퀘스트 생성")
            }

            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}




@Preview
@Composable
private fun CreateGoOutQuestScreenPreview() {
    DailyQuestTheme {
        CreateGoOutQuestScreen()
    }
}
