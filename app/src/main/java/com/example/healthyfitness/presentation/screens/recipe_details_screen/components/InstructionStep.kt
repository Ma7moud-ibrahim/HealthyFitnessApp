package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.recipe_details_screen.preview_data.fakeRecipeDetails
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@SuppressLint("DefaultLocale")
@Composable
fun InstructionStep(
    stepNumber: Int,
    stepInstruction: String,
    modifier: Modifier = Modifier,
    tintColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    stepTextStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    instructionTextStyle: TextStyle = MaterialTheme.typography.bodySmall
) {
    Row(
        modifier = modifier.height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = String.format("%02d", stepNumber),
            color = textColor,
            style = stepTextStyle
        )
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.circle_dot),
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = tintColor
            )
            DashedVerticalDivider(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxHeight(),
                color = tintColor
            )
        }
        Column(modifier = Modifier.height(IntrinsicSize.Max)) {
            Text(
                text = "Step $stepNumber",
                color = textColor,
                style = stepTextStyle
            )
            Text(
                text = stepInstruction,
                modifier = Modifier.padding(vertical = 8.dp),
                color = textColor.copy(alpha = .7f),
                style = instructionTextStyle
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun InstructionStepPreview() {
    HealthyFitnessTheme(dynamicColor = false) {
        InstructionStep(
            stepNumber = 1,
            stepInstruction = fakeRecipeDetails.instructions[0],
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
        )
    }
}