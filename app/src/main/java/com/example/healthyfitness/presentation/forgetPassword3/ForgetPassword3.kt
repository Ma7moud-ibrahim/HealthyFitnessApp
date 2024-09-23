package com.example.healthyfitness.presentation.forgetPassword3

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomInput
import com.example.healthyfitness.presentation.common_components.shimmer.MyButton
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun ForgetPassword3(
    save: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
                painter = painterResource(id = R.drawable.group_lock),
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
                    text = stringResource(R.string.your_new_password_must_be_different_from_your_old_password),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    lineHeight = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 45.dp, horizontal = 72.dp)
                )
                CustomInput(
                    hint = "Password",
                    prefix = R.drawable.lock,
                    suffix = R.drawable.ic_eye_slash_icon
                )
                CustomInput(
                    hint = "Confirm Password",
                    prefix = R.drawable.lock,
                    suffix = R.drawable.ic_eye_slash_icon
                )
                MyButton(
                    textId = R.string.send,
                    onClick = { save() },
                    modifier = Modifier.width(175.dp)
                )
            }
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgetPassword3Preview() {
    HealthyFitnessTheme {
        ForgetPassword3 {}
    }
}