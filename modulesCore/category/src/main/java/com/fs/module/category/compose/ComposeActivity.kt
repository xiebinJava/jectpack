package com.fs.module.category.compose

import android.content.res.Resources.Theme
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alibaba.android.arouter.facade.annotation.Route
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.libutils.constants.RoutConstant
import com.fs.module.category.ui.theme.JectpackTheme


@Route(path = RoutConstant.Activity.COMPOSE_ACTIVITY)
class ComposeActivity : BaseComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JectpackTheme (darkTheme = false ){
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "我是按钮")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JectpackTheme {
        Greeting("Android")
    }
}