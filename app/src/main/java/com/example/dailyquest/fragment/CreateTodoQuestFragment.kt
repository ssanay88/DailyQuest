package com.example.dailyquest.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.dailyquest.CreateQuestTitle
import com.example.dailyquest.DaysToRepeat
import com.example.dailyquest.LeftIconText
import com.example.dailyquest.R
import com.example.dailyquest.ui.theme.DailyQuestTheme

class CreateTodoQuestFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CreateTodoQuestScreen()
            }
        }
    }

}

@Composable
private fun CreateTodoQuestScreen() {
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
                    text = "할 일 퀘스트 생성"
                )
            }


            CreateQuestTitle(
                textFieldHint = "할 일 퀘스트 제목을 입력하세요.",
                titleIconResource = R.drawable.ic_launcher_foreground,
                modifier = Modifier
            )

            Card(
                colors = CardDefaults.cardColors(
                    contentColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    LeftIconText(
                        text = "체크리스트",
                        icon = R.drawable.ic_launcher_foreground,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                    }
                }

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    // TODO 버튼 클릭 시 할 일 추가하기
                    val testList = mutableListOf("아침먹가", "점심먹기", "저녁 식단")
                    items(items = testList) { todo ->
                        Text(text = todo)
                    }
                }
            }

            DaysToRepeat(titleText = "반복 요일")

            Button(
                onClick = { Log.d("tngur", "퀘스트 생성") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text("할 일 퀘스트 생성")
            }

            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}


@Preview
@Composable
private fun CreateTodoQuestScreenPreview() {
    DailyQuestTheme {
        CreateTodoQuestScreen()
    }
}