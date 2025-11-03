package tw.edu.pu.csim.tcyang.mole

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tw.edu.pu.csim.tcyang.mole.ui.theme.MoleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoleTheme {
                MoleScreen()
            }
        }
    }
}

@Composable
fun MoleScreen(moleViewModel: MoleViewModel = viewModel) {
    val counter by moleViewModel.counter.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mole),
            contentDescription = "地鼠",
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(150.dp)
                .clickable { moleViewModel.incrementCounter() }
        )

        Text(
            text = counter.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize(),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoleTheme {
        MoleScreen()
    }
}