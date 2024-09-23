package com.example.healthyfitness.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.MyButton
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun WelcomeScreen(
    signUp: () -> Unit,
    signIn: () -> Unit,
)
{
    Box(
        modifier = Modifier.fillMaxSize()
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
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                modifier = Modifier.
                padding(start = 37.dp, top = 55.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(2f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.polygon_1),
                    contentDescription = "back ground",
                    modifier = Modifier.size(350.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.unsplash_qkqwdvrqqy8),
                    contentDescription = "back ground",
                    modifier = Modifier.size(600.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(179.dp)
                    .padding()
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.shapes.medium
                    )
            ){
            Column(
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)
            ) {
                MyButton(textId = R.string.sign_in, onClick = { signIn() })
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        ) {
                            append(stringResource(R.string.don_t_have_an_account))
                        }
                        withStyle(

                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append(stringResource(R.string.sign_up))
                        }
                    },
                    modifier = Modifier.clickable { signUp() }
                        .padding(top = 20.dp, bottom = 10.dp, start = 20.dp, end = 10.dp),
                    //textAlign = TextAlign.Center

                )
            }
        }
    }
     }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    HealthyFitnessTheme {
        WelcomeScreen(
            signUp = {}
        ) {}
    }
}