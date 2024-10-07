package mx.delasalle.introcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.delasalle.introcompose.ui.theme.IntroComposeTheme

val baseUrl = BuildConfig.BASE_URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyComponent()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyComponent(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "URL $baseUrl")
    }
}


@Composable
fun ColumnExample1() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Texto ", modifier = Modifier
                .fillMaxWidth()
                .weight(25f)
                .background(Color.Green)
        )
        Text(
            text = "Texto 2", modifier = Modifier
                .fillMaxWidth()
                .weight(25f)
                .background(Color.White)
        )
        Text(
            text = "Texto 3", modifier = Modifier
                .fillMaxWidth()
                .weight(50f)
                .background(Color.Red)
        )
    }
}


@Composable
fun ProfileCard(
    name: String = "Hugo Gomez Arenas",
    title: String = "Mobile Developer",
    email: String = "hugo@galagox.com"
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFACD370))
            .padding(16.dp)
            .border(1.dp, Color(0xFF213600))
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.DarkGray, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Text(
                    text = name,
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                )
                Text(
                    text = title,
                    style = TextStyle(fontSize = 16.sp, fontStyle = FontStyle.Italic)
                )
                Text(text = "Email: $email", style = TextStyle(fontSize = 14.sp))
            }
        }
    }
}


@Composable
fun RowExample1() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            text = "Text 1",
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .background(Color.Green)
        )
        Text(
            text = "Text 2",
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .background(Color.White)
        )
        Text(
            text = "Text 3",
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .background(Color.Red)
        )
        Text(
            text = "Text 3",
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .background(Color.Red)
        )

    }
}


@Composable
fun BoxExample() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Blue)
        ) {

        }
    }
}

