package com.example.healthyfitness.presentation.screens.home_page1_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R


@Composable
fun CalenderTopBar(
    dayName: String,
    dayNum: String,
    @DrawableRes userImgId: Int
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = stringResource(id = R.string.navigate_back),
            Modifier.size(34.dp),
            tint = Color.White
        )
        Text(
            text = "$dayName, $dayNum",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )


        Card(
            modifier = Modifier
                .size(56.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
        )
        {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = userImgId),
                    contentDescription = stringResource(R.string.user_image),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }
    }
}