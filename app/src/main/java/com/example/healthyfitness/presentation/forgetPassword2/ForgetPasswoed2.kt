package com.example.healthyfitness.presentation.forgetPassword2

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
fun ForgetPassword2(
    verify: () -> Unit,
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
                painter = painterResource(id = R.drawable.group_49022),
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
                    text = stringResource(id = R.string.enter_verification_code_just_sent_to_your_email_address),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    lineHeight = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 45.dp, horizontal = 72.dp)
                )
                CustomInput(
                    hint = stringResource(id = R.string.enter_verification_code),
                    prefix = R.drawable.form_textbox_password
                )

                Text(
                    text = stringResource(id = R.string.resend_code),
                    lineHeight = 10.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.padding(vertical = 30.dp)
                )
                MyButton(
                    textId = R.string.verify,
                    onClick = { verify() },
                    modifier = Modifier.width(175.dp)
                )
            }
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgetPassword2Preview() {
    HealthyFitnessTheme {
        ForgetPassword2 {}
    }
}