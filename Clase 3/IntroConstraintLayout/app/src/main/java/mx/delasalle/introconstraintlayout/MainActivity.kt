package mx.delasalle.introconstraintlayout

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.channels.Channel
import mx.delasalle.introconstraintlayout.ui.theme.IntroConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroConstraintLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChainExample(){
    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (button1,button2,button3) = createRefs()

        val startGuideLine = createGuidelineFromStart(0.35f)

        Button(onClick = {}, modifier = Modifier.constrainAs(button1){
            start.linkTo(startGuideLine)
        }){
            Text(text = "Button 1")
        }

        Button(onClick = {}, modifier = Modifier.constrainAs(button2){
            top.linkTo(button1.bottom)
            end.linkTo(button1.end)
        }){
            Text(text = "Button 2")
        }

        Button(onClick = {}, modifier = Modifier.constrainAs(button3){
            top.linkTo(button2.bottom)
            end.linkTo(button2.end)
        }){
            Text(text = "Button 3")
        }
        createVerticalChain(button1,button2,button3, chainStyle = ChainStyle.Packed)
    }
}


@Composable
fun GuideLineExample(){
    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (button1,button2) = createRefs()

        val topGuideLine = createGuidelineFromTop(0.50f)
        val startGuideLine = createGuidelineFromStart(0.50f)

        val endGuideLine = createGuidelineFromEnd(0.1f)
        val bottomGuideLine = createGuidelineFromBottom(0.1f)

        Button(onClick = {}, modifier = Modifier.constrainAs(button1){
            top.linkTo(topGuideLine)
            start.linkTo(startGuideLine)
        }){
            Text(text = "Button 1")
        }

        Button(onClick = {}, modifier = Modifier.constrainAs(button2){
            end.linkTo(endGuideLine)
            bottom.linkTo(bottomGuideLine)
        }){
            Text(text = "Button 2")
        }
    }
}

@Composable
fun MyConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // val button1 = createRef()
        // val button2 = createRef()
        val (button1,button2,button3) = createRefs()

        Button(onClick = {}, modifier = Modifier.constrainAs(button1){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }){
            Text(text = "Button 1 ")
        }

        Button(onClick = {}, modifier = Modifier.constrainAs(button2){
            bottom.linkTo(button1.top)
            end.linkTo(button1.start)
        }){
            Text(text = "Button 2 ")
        }

        Button( onClick = {}, modifier = Modifier.constrainAs(button3){
            bottom.linkTo(button1.top)
            start.linkTo(button1.end)
        }){
            Text(text = "Button 3")
        }

    }
}
