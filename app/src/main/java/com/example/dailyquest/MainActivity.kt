package com.example.dailyquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyquest.ui.theme.DailyQuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyQuestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DailyQuestApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DailyQuestApp(
    modifier: Modifier
) {

}

@Composable
fun MainCreateQuestFloatingBtn() {
    FloatingActionButton(
        onClick = {
            // 클릭 이벤트
        }
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DailyQuestAppPreview() {
    DailyQuestTheme {
        DailyQuestApp(modifier = Modifier)
    }
}