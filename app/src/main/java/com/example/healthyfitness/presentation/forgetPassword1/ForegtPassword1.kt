package com.example.healthyfitness.presentation.forgetPassword1

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.common_components.shimmer.MyButton
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun ForgetPassword1(
    send: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dumble_icon),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.lock_square),
                contentDescription = "image description",
                modifier = Modifier
                    .size(250.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 13.dp)
                    .fillMaxWidth()
                    .weight(2f)
                    .padding()
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.shapes.medium
                    )
            ) {
                Text(
                    text = "Please Enter Your Email Address To Receive a Verification Code",
                    lineHeight = 25.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 45.dp, horizontal = 72.dp)
                )
                CustomInput(hint = "Enter Your Email", prefix = R.drawable.email_open)

                Text(
                    text = "Try Another Way",

                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.padding(vertical = 30.dp)
                )
                MyButton(
                    textId = R.string.send,
                    onClick = { send() },
                    modifier = Modifier.width(175.dp)
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgetPassword1Preview() {
    HealthyFitnessTheme {
        ForgetPassword1 {}
    }
}