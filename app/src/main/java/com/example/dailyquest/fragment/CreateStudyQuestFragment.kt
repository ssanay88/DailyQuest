package com.example.dailyquest.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.dailyquest.CreateQuestTitle
import com.example.dailyquest.DaysToRepeat
import com.example.dailyquest.LeftIconText
import com.example.dailyquest.R
import com.example.dailyquest.ui.theme.DailyQuestTheme

class CreateStudyQuestFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CreateStudyQuestScreen()
            }
        }
    }

}

@Composable
private fun CreateStudyQuestScreen() {
    DailyQuestTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { Log.d("tngur", "뒤로가기 : ")}
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
                Text(
                    text = "학습 퀘스트 생성"
                )
            }

            CreateQuestTitle(
                textFieldHint = "학습할 내용을 입력하세요",
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
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    LeftIconText(
                        text = "뽀모도로 설정",
                        icon = R.drawable.ic_launcher_foreground,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Column {
                        LeftIconText(
                            text = "학습 시간 (분)",
                            icon = R.drawable.ic_launcher_foreground,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Row {
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("15분", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("25분", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("35분", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("45분", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("1시간", fontSize = 12.sp)
                            }
                        }

                        LeftIconText(
                            text = "휴식 시간 (분)",
                            icon = R.drawable.ic_launcher_foreground,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Row {
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("5분", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("10분", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("15분", fontSize = 12.sp)
                            }
                        }

                        LeftIconText(
                            text = "목표 반복 횟수",
                            icon = R.drawable.ic_launcher_foreground,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Row {
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("2회", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("4회", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("6회", fontSize = 12.sp)
                            }
                            FilledTonalButton(onClick = {}, modifier = Modifier.weight(1f).padding(horizontal = 2.dp)) {
                                Text("8회", fontSize = 12.sp)
                            }
                        }

                        Text(
                            text = "총 학습 시간 : "
                        )
                    }
                }

            }

            DaysToRepeat("학습 요일")

            Button(
                onClick = { Log.d("tngur", "퀘스트 생성") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text("방문 퀘스트 생성")
            }

            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}



@Preview
@Composable
private fun CreateStudyQuestScreenPreview() {
    DailyQuestTheme {
        CreateStudyQuestScreen()
    }
}