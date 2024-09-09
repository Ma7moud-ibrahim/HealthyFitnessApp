package com.example.healthyfitness.presentation.screens.home_page1_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screens.home_page1_screen.model.ActivityType
import com.example.healthyfitness.presentation.screens.home_page1_screen.model.FitnessActivity
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun ActivityItem(activity: FitnessActivity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp,10.dp,12.dp,0.dp)
            .background(
                color = MaterialTheme.colorScheme.surface, shape =MaterialTheme.shapes.extraLarge
            ), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(29.dp,18.dp,29.dp,18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = activity.type.iconImg),
                    contentDescription = null,
                    modifier = Modifier.size(44.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text =stringResource(id = activity.type.label), color = Color.White)
            }
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Row (verticalAlignment = Alignment.CenterVertically,){
                    Text(
                        text = activity.value,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize =30.sp,fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = activity.valueType,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize =17.sp )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.large)
                    .padding(14.dp,4.dp,14.dp,4.dp)) { Text(
                    text = activity.time,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp)
                ) }
            }
        }
    }
}
//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    name = "pixel" ,
//    device = Devices.PIXEL_4
//)
//@Composable
//fun ActivityItemPreview(){
//    MaterialTheme { ActivityItem(activity =  FitnessActivity(ActivityType.Cycling, "17","Km", "Today 09:00 AM")) }
//
//}
