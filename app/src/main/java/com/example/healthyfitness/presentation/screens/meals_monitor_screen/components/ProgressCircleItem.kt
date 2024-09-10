package com.example.healthyfitness.presentation.screens.meals_monitor_screen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthyfitness.presentation.theme.LemonGreen
import com.example.healthyfitness.presentation.theme.White

@Composable
fun ProgressCircle(
    progress: State<Float>,
    strokeWidth: Float,
    trackColor: Color,
    progressColor: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val arcRadius = (canvasWidth / 2)

        drawCircle(
            color = trackColor,
            radius = arcRadius,
            center = Offset(canvasWidth / 2, canvasHeight / 2),
            style = Stroke(width = strokeWidth)
        )
        drawArc(
            color = progressColor,
            startAngle = -90f,
            sweepAngle = 360 * progress.value,
            useCenter = false,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
            topLeft = Offset((canvasWidth / 2) - arcRadius, (canvasHeight / 2) - arcRadius),
            size = Size(arcRadius * 2, arcRadius * 2)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true)
@Composable
private fun ProgressCirclePreview() {
    ProgressCircle(
        progress = mutableFloatStateOf(.5f),
        strokeWidth = 20f,
        trackColor = White,
        progressColor = LemonGreen,
        modifier = Modifier.fillMaxSize()
    )
}