package com.example.healthyfitness.presentation.screen.home4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.common_components.shimmer.CustomAppBar
import com.example.healthyfitness.presentation.common_components.shimmer.CustomButton
import com.example.healthyfitness.presentation.screen.home4.component.MyPager
import com.example.healthyfitness.presentation.screen.home4.preview_data.tabs
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme

@Composable
fun MyWorkoutsScreen(
    onClickAddExercise: () -> Unit
) {

    Scaffold(
        topBar = {
            CustomAppBar(
                title = stringResource(id = R.string.workout_title),
                photo = R.drawable.ic_launcher_background
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .height(306.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(40.dp))

                MyPager()
            }

            Spacer(modifier = Modifier.height(51.dp))

            Text(
                modifier = Modifier.size(226.dp, 57.dp),
                text = stringResource(id = R.string.workout_text),
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.bodyMedium.copy(
                    lineHeight = 18.5.sp,
                    fontSize = 15.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(94.dp))

            CustomButton(294.0, "Add Exercise", null) { onClickAddExercise() }
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMyWorkout() {
    HealthyFitnessTheme {
        MyWorkoutsScreen({})
    }
}