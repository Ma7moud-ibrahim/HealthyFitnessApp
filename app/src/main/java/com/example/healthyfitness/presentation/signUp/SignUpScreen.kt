package com.example.healthyfitness.presentation.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.common_components.shimmer.MyButton
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun SignUpScreen(
    signUp: () -> Unit,
    signIn: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
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
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                modifier = Modifier.padding(start = 37.dp, top = 30.dp)
            )
            val offset = Offset(10f, 10f)
            Text(
                text = stringResource(R.string.shape_your_muscles),
                style = TextStyle(
                    fontSize = 42.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Justify,
                    shadow = Shadow(
                        color = MaterialTheme.colorScheme.primary,
                        offset = offset,
                        blurRadius = 30f,
                    ),

                ),
                modifier = Modifier.padding(top = 37.dp, bottom = 20.dp),
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
                    style =MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 45.dp)
                )
                CustomInput(hint = "Full Name", prefix = R.drawable.export_2)
                CustomInput(hint = "Enter Your Email", prefix = R.drawable.email_open)
                CustomInput(
                    hint = "Password",
                    prefix = R.drawable.lock,
                    suffix = R.drawable.ic_eye_slash_icon
                )
                CustomInput(
                    hint = "Confirm Password",
                    prefix = R.drawable.lock,
                    suffix = R.drawable.ic_eye_slash_icon,
                )
                Text(
                    text = "Forget Password?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                MyButton(
                    textId = R.string.sign_up,
                    onClick = { signUp() },
                    modifier = Modifier.width(175.dp)
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        ) {
                            append(stringResource(R.string.already_have_an_account))
                        }
                        withStyle(

                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append(stringResource(R.string.sign_in))
                        }
                    },
                    modifier = Modifier.clickable { signIn() }

                )
            }
           Spacer(modifier = Modifier.width(30.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    HealthyFitnessTheme {
        SignUpScreen(
            signUp = {}
        ) {}
    }
}