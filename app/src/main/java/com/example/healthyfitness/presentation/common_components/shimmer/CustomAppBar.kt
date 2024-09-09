package com.example.healthyfitness.presentation.common_components.shimmer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.theme.DarkGreen
import com.example.healthyfitness.presentation.theme.LemonGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(title:String,photo:Int) {
    TopAppBar(

        navigationIcon = {
            IconButton(onClick = { }) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_right_icon), contentDescription = "")
            }
        },
        title = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    title,
                    style = MaterialTheme.typography.headlineLarge.copy(color = LemonGreen)
                )
            }
        }
,
        actions = {
            Image(painter = painterResource(id = photo), // Replace with your image name
                contentDescription = "Description of the image",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape), // Set the size of the image
                contentScale = ContentScale.Crop,
//                colorFilter = ColorFilter.tint(DarkGreen),

                )
        }
    )
}

@Preview
@Composable
fun PreviewCustomAppBar() {
    CustomAppBar("Notifications",R.drawable.ic_launcher_background)
}