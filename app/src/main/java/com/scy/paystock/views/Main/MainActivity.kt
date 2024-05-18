package com.scy.paystock.views.Main
import android.os.Handler
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.scy.paystock.R
import com.scy.paystock.views.Main.ui.theme.PayStockTheme
import com.scy.paystock.views.renterCode.RenterCodeActivity


class MainActivity : ComponentActivity() {
    private val SPLASH_DELAY: Long = 2000 // 2 seconds delay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PayStockTheme {
                SplashScreen()
            }
        }
        navigateToHomeActivityWithDelay()
    }

    private fun navigateToHomeActivityWithDelay() {

        Handler().postDelayed({
            val intent = Intent(this, RenterCodeActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}

@Composable
fun SplashScreen() {
    Image(
        painter = painterResource(id = R.drawable.splash_image), // Replace R.drawable.splash_image with your image resource
        contentDescription = null, // Content description for accessibility
        modifier = Modifier.fillMaxSize() // Fill the entire screen
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PayStockTheme {
       SplashScreen()
    }
}