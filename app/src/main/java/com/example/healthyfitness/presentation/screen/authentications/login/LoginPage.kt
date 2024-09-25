package com.example.healthyfitness.presentation.screen.authentications.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screen.authentications.component.SignInCard
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.utils.Dimens.mediumPadding1
import com.example.healthyfitness.presentation.utils.Dimens.mediumPadding2

@Composable
fun LoginPage(modifier: Modifier = Modifier) {

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = mediumPadding1, vertical = 40.dp)

    ) {
        Spacer(modifier = Modifier.height(mediumPadding2))
        Image(
            painter = painterResource(id = R.drawable.ic_logo), contentDescription = null,
            modifier = Modifier.padding(mediumPadding2)

        )
        Spacer(modifier = Modifier.height(mediumPadding1))
        Text(
            text = "Be,",
            modifier = Modifier.padding(horizontal = mediumPadding1),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "Yourself",
            modifier = Modifier.padding(horizontal = mediumPadding1),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(mediumPadding1))
        SignInCard()


    }

}


@Preview
@Composable
private fun PreviewLoginPage() {
    HealthyFitnessTheme {
        LoginPage()
    }

}