package com.example.healthyfitness.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.theme.onPrimary
import com.example.healthyfitness.presentation.theme.primary

@Composable
fun MyButton(
    textId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = 0,
    shape: CornerBasedShape = MaterialTheme.shapes.large,
    buttonEnable: Boolean = true,
    color: ButtonColors? = ButtonDefaults.buttonColors(primary),
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Button(
        onClick = onClick,
        modifier = modifier.shadow(elevation = 10.dp, spotColor = primary, ambientColor = primary),
        shape = shape,
        enabled = buttonEnable,
        colors = color ?: ButtonDefaults.buttonColors()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = textId),
                textAlign = TextAlign.Center,
                style = textStyle,
                color = onPrimary,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            if (icon != 0) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = onPrimary,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Preview(backgroundColor = 0xFF2E2D2D)
@Composable
private fun MyButtonPreview() {
    HealthyFitnessTheme {
        MyButton(
            textId = R.string.app_name,
            onClick = {},
            modifier = Modifier.padding(16.dp),
            icon = R.drawable.ic_export,
            shape = MaterialTheme.shapes.medium,
            buttonEnable = true,
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}