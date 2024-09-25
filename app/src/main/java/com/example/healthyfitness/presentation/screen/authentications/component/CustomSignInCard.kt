package com.example.healthyfitness.presentation.screen.authentications.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomButton
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.utils.Dimens.mediumPadding1
import com.example.healthyfitness.presentation.utils.Dimens.mediumPadding2
import com.example.healthyfitness.presentation.utils.Dimens.mediumPadding3

@Composable
fun SignInCard(
    modifier: Modifier = Modifier,
//               onClickListenerSignIn: () -> Unit
) {
    Column(
        modifier
            .fillMaxWidth()
            .height(490.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 2.dp, // Border width
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .background(MaterialTheme.colorScheme.surface),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(vertical = mediumPadding3),
                text = "Sign In to your Account",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
//

        TextField(
            value = "",
            onValueChange = {},

            label = {
                Text(
                    text = "Enter your Email",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "Email Icon",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            modifier = Modifier
                .fillMaxWidth(fraction = .95f)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.tertiary),
        )
        Spacer(modifier = Modifier.height(mediumPadding2))

        TextField(
            value = "",
            onValueChange = {},

            label = {
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Email Icon",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            modifier = Modifier
                .fillMaxWidth(fraction = .95f)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.tertiary),
        )
        Spacer(modifier = Modifier.height(mediumPadding2))

        Text(

            text = "Forget Password ?",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.tertiary
        )
        Spacer(modifier = Modifier.height(mediumPadding1))
//
        CustomButton(buttonText = "Sign In", icon = { Text(text = "Sign In")}, onClick = {})
        Spacer(modifier = Modifier.height(mediumPadding2))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = mediumPadding3)
        ) {
            Divider(
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
            Text(
                modifier = Modifier.padding(horizontal = mediumPadding1),
                text = "Sign in with",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary

            )
            Divider(
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
        }
        Spacer(modifier = modifier.height(mediumPadding2))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
        ) {
            Image(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = null)
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Image(painter = painterResource(id = R.drawable.linkedin), contentDescription = null)
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Image(painter = painterResource(id = R.drawable.google), contentDescription = null)
        }


    }

}

@Preview
@Composable
private fun PreviewSignInCard() {
    HealthyFitnessTheme {
        SignInCard(

        )
    }
}