package com.example.loginpagewithintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpagewithintent.ui.theme.LoginPageWithIntentTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageWithIntentTheme{
                LoginPageWithIntent()
            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun LoginPageWithIntent() {
    var username by remember { mutableStateOf(" ") }
    var password by remember { mutableStateOf(" ") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "LOGIN",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF476810)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Username TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "USERNAME") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "PASSWORD") },
            keyboardActions = KeyboardActions(
                onDone = {
                    //Handle Login Here
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(16.dp))
        //LOGIN Button
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors( containerColor = Color.Green, contentColor = Color.Black),
            modifier = Modifier.size(height = 35.dp, width = 150.dp)
        )
        { Text("LOG IN") }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "OPEN WEBSITES",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Red
            )
        )
        Button(
            onClick = {
                //Create an intent to open Amazon's website
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.amazon.com")
                //Check if there is an Activity that can handle the intent
                try{
                    //Attempt to start the activity for opening the link
                    context.startActivity(intent)
                }
                catch(e: ActivityNotFoundException) {
                    //Handle the case when no web browser is available
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(text = "OPEN AMAZON",color = Color.Yellow)
        }
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com")
                try{ context.startActivity(intent) }
                catch(e: ActivityNotFoundException) {}
            },
            modifier = Modifier.fillMaxWidth()
        )
        { Text("OPEN GOOGLE",color = Color.Yellow) }
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.yahoo.com")
                try{ context.startActivity(intent) }
                catch(e: ActivityNotFoundException) {}
            },
            modifier = Modifier.fillMaxWidth()
        )
        { Text("OPEN YAHOO",color = Color.Yellow) }
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.facebook.com")
                try{ context.startActivity(intent) }
                catch(e: ActivityNotFoundException) {}
            },
            modifier = Modifier.fillMaxWidth()
        )
        { Text("OPEN FACEBOOK",color = Color.Yellow) }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginPageWithIntentPreview() {
    LoginPageWithIntentTheme {
        LoginPageWithIntent()
    }
}