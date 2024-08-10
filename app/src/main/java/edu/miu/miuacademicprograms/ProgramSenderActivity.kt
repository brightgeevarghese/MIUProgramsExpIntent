package edu.miu.miuacademicprograms

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.miu.miuacademicprograms.ui.theme.MIUAcademicProgramsTheme

class ProgramSenderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MIUAcademicProgramsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProgramSenderScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProgramSenderScreen(modifier: Modifier) {

    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, ProgramReceiverActivity::class.java).apply {
                putExtra("PROGRAM_NAME", "MS")
                putExtra("PROGRAM_DURATION", "2 years")
                putExtra("PROGRAM_IS_ONLINE", false)
            }
            context.startActivity(intent)
        },
        modifier = modifier.padding(100.dp)
    ) {
        Text(text = "Send Program Data")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MIUAcademicProgramsTheme {
//        Greeting("Android")
    }
}