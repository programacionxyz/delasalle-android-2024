package mx.delasalle.intomutablestate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.delasalle.intomutablestate.ui.theme.IntoMutableStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntoMutableStateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MutableStateExample3()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MutableStateExample3() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 128.dp)
    ) {
        TextField(value = text,
            onValueChange = { newText -> text = newText },
            label = {Text("Enter text")},
            modifier =  Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "You typed : $text")
    }
}


@Composable
fun ParentComponent() {
    val pressed = remember { mutableStateOf(10) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 128.dp)
    ) {
        Text("You have pressed this button ${pressed.value} times")
        ChildComponent(pressed.value) { myValue ->
            pressed.value = myValue
        }
        //ChildComponent(pressed.value,::test)
    }
}

fun test(myValue: Int) {
    val res = myValue
}

@Composable
fun ChildComponent(pressed: Int, updateCounter: (Int) -> Unit) {
    Button(onClick = {
        updateCounter(pressed + 1)
    }) { Text("Press the button") }
}


@Composable
fun MutableStateExample() {
    //var pressed by remember{ mutableStateOf(10) }
    val pressed = remember { mutableStateOf(10) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 128.dp)
    ) {
        Button(onClick = {
            //pressed += 1
            //Log.d("MYAPP","times $pressed")
            pressed.value += 1
        }) {
            //Text(text = " You have pressed this button $pressed times")
            Text(text = " You have pressed this button ${pressed.value} times")
        }
    }
}
