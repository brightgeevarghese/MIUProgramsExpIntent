package edu.miu.miuacademicprograms

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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

class ProgramReceiverActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MIUAcademicProgramsTheme {
                var intent = intent
                // Retrieve program data from the intent
                val programName = intent.getStringExtra("PROGRAM_NAME") ?: "Unknown Program"
                val programDuration = intent.getIntExtra("PROGRAM_DURATION", -1)  // Default value if not found
                val isOnline = intent.getBooleanExtra("PROGRAM_IS_ONLINE", false)  // Default value if not found
                ProgramReceiverScreen(programName, programDuration, isOnline, Modifier)
            }
        }
    }
}

@Composable
fun ProgramReceiverScreen(
    programName: String,
    programDuration: Int,
    isOnline: Boolean,
    modifier: Modifier
) {
    val context = LocalContext.current
    Scaffold(modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(text = "Program: $programName")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Duration: $programDuration years")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Online Program: $isOnline")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { (context as ComponentActivity).finish() }) {
                Text(text = "Back to Sender")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MIUAcademicProgramsTheme {
//        Greeting("Android")
    }
}