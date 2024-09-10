package com.example.healthyfitness.presentation.screen.home2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R

@Composable
fun ItemCard(modifier: Modifier, exerciseItemDataModel: ExerciseItemDataModel) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        modifier = modifier
            .size(width = 127.dp, height = 162.dp)
            .clickable {
                exerciseItemDataModel.onItemClicked()
            }

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = exerciseItemDataModel.imageId),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(width = 37.dp, height = 35.dp)
            )
            Text(
                text = stringResource(exerciseItemDataModel.bodyTextId),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .width(93.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )

            Spacer(modifier = Modifier.weight(1f)) // automatic spacing

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 9.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_clock_icon),
                    contentDescription = "",
                    modifier = Modifier.size(width = 24.dp, height = 24.dp)
                )

                Spacer(modifier = Modifier.width(3.dp))

                Text(
                    text = "${exerciseItemDataModel.hours}Hr ${exerciseItemDataModel.minutes}Min",
                    modifier = Modifier.height(17.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            }

        }
    }

}

