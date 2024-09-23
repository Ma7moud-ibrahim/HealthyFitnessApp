package com.example.healthyfitness.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.common_components.shimmer.MyButton
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun LoginScreen(
    signIn: () -> Unit,
    forgetPassword :()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dumble_icon),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                modifier = Modifier.padding(start = 37.dp, top = 30.dp)
            )
            val offset = Offset(10f, 10f)
            Text(
                text = stringResource(id = R.string.be_yourself),
                style = TextStyle(
                    fontSize = 42.sp,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.primary,
                    shadow = Shadow(
                        color = MaterialTheme.colorScheme.primary,
                        offset = offset,
                        blurRadius = 30f,
                    ),
                ),
                modifier = Modifier.padding(top = 37.dp, bottom = 20.dp)

            )
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier

                    .fillMaxWidth()
                    .padding()
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.shapes.medium
                    )
            ) {
                Text(
                    text = "Sign Up to create Account",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 58.dp, bottom = 14.dp)
                )
                CustomInput(hint = "Enter Your Email", prefix = R.drawable.email_open)
                CustomInput(
                    hint = "Password",
                    prefix = R.drawable.lock,
                    suffix = R.drawable.ic_eye_slash_icon
                )

                Text(
                    text = "Forget Password?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.clickable { forgetPassword() }
                )
                MyButton(
                    textId = R.string.sign_in,
                    onClick = { signIn() },
                    modifier = Modifier.width(175.dp)
                )

                Row(
                   horizontalArrangement = Arrangement.spacedBy(9.dp),
                    modifier = Modifier
                        //.fillMaxWidth()
                        .height(30.dp)
                        .padding(vertical = 20.dp)
                ) {
                    HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiary)
                    Text(
                        text = stringResource(R.string.sign_in_with),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    HorizontalDivider(thickness = 1.dp,color = MaterialTheme.colorScheme.tertiary)

                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook_f),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "",
                        modifier = Modifier.padding(horizontal = 17.dp),
                        tint = MaterialTheme.colorScheme.primary

                    )
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary

                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    HealthyFitnessTheme {
        LoginScreen(
         signIn = {}
        ) {}
    }
}