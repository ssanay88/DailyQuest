package com.example.dailyquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquest.ui.theme.DailyQuestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyQuestTheme {
                DailyQuestApp()
            }
        }
    }

}

@Composable
fun DailyQuestApp() {
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // 메인 화면 Floating Button
        floatingActionButton = {
            CreateQuestFloatingBtn(onCreateBtnClicked = {
                showBottomSheet = !showBottomSheet
            })
        }
    ) { innerPadding ->
        // 메인 화면
        MainScreen(modifier = Modifier.padding(innerPadding))

        if (showBottomSheet) {
            CreateQuestBottomSheet(onDismiss = { showBottomSheet = !showBottomSheet })
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 36.dp)
        ) {
            Text(
                text = "퀘스트 로그",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(44.dp)
            )
            Text(
                text = "320 포인트"
            )
        }
        DailyQuestSection()
    }
}

@Composable
fun CreateQuestFloatingBtn(onCreateBtnClicked: () -> Unit) {
    FloatingActionButton(
        onClick = onCreateBtnClicked
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateQuestBottomSheet(onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.select_quest_category),
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = {
                        scope.launch {
                            sheetState.hide()
                        }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                onDismiss.invoke()
                            }
                        }
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(3)
            ) {
                // 퀘스트 유형 생성
                items(10) { item ->
                    QuestCategoryElement()
                }
            }
        }

    }
}

@Composable
fun QuestCategoryElement() {
    Surface(
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp).border(
                width = 1.dp, // 너비 5dp
                color = Color.Black,
                shape = MaterialTheme.shapes.medium // 네모 모양
            )
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = "카테고리",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun DailyQuestSection() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(10) { item ->
            DailyQuest()
        }
    }
}

// TODO 추후에 파라미터 추가 필요
//    @DrawableRes icon: Int = ,
//    title: String,
//    @StringRes category: Int,
//    point: Int
@Composable
fun DailyQuest() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .border(
            width = 1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium)
            .padding(horizontal = 12.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(88.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "제목",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "카테고리",
                style = MaterialTheme.typography.titleSmall
            )
        }
        LeftIconText(
            text = "10",
            icon = R.drawable.ic_launcher_foreground,
            modifier = Modifier
        )
    }
}

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

// Preview
@Preview(showBackground = true)
@Composable
fun DailyQuestAppPreview() {
    DailyQuestTheme {
        DailyQuestApp()
    }
}

@Preview
@Composable
fun CreateQuestFloatingBtnPreview() {
    DailyQuestTheme {
        CreateQuestFloatingBtn(onCreateBtnClicked = {})
    }
}

@Preview
@Composable
fun CreateQuestBottomSheetPreview() {
    DailyQuestTheme {
        CreateQuestBottomSheet(onDismiss = {})
    }
}


