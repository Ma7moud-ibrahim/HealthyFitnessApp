package com.example.healthyfitness.presentation.screens.recipe_details_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screens.utils.WIDTH

@Composable
fun StepsSection(
    instructions: List<String>,
    modifier: Modifier = Modifier,
    lemonGreenTextColor: Color = MaterialTheme.colorScheme.primary,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth(WIDTH)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Step by Step",
            modifier = Modifier.width(IntrinsicSize.Max),
            color = lemonGreenTextColor
        )
        instructions.forEachIndexed { index, instruction ->
            InstructionStep(
                stepNumber = index + 1,
                stepInstruction = instruction,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}