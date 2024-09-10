import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyfitness.R
import com.example.healthyfitness.presentation.screen.home2.components.PopularExercises
import com.example.healthyfitness.presentation.screen.home2.components.TopAppBarSection
import com.example.healthyfitness.presentation.theme.HealthyFitnessTheme
import com.example.healthyfitness.presentation.screen.home2.components.UserHomeData
import com.example.healthyfitness.presentation.screen.home2.components.fakeExerciseItems

@Composable
fun FitnessAppScreen(userHomeData: UserHomeData, onClickViewAll: () -> Unit) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Mahmoud Ebrahim

            TopAppBarSection(userHomeData)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(351.dp)


            ) {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(309.dp)
                    .padding(horizontal = 10.dp)
                    .background(
                        MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 14.dp)
                    .align(Alignment.BottomCenter)
                    , contentAlignment = Alignment.BottomStart,

                    ) {
                    Column(

                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(151.dp,41.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                            ),
                            shape = RoundedCornerShape(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),

                            ) {
                            Text(
                                stringResource(R.string.entry_level_button),
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.W400),
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(id = R.string.bench_press),
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 35.sp, fontWeight = FontWeight.W700),
                            color = Color.White,

                            )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = stringResource(id = R.string.bench_press_count),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.W400),
                            modifier = Modifier.size(width = 260.dp, height = 50.dp),
                            color = MaterialTheme.colorScheme.primary,

                            )
                        Spacer(modifier = Modifier.height(37.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_play_circle_icon), // Replace with actual icon
                                contentDescription = stringResource(R.string.play_button_description),
                                modifier = Modifier.size(49.dp,49.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "34 Minutes",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 25.sp),
                                modifier = Modifier
                                    .size(width = 182.dp, height = 31.dp)
                                    .padding(start = 15.dp),
                                color = MaterialTheme.colorScheme.primary,


                                )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }



                Image(
                    painter = painterResource(id = R.drawable.ic_yoga_woman),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.TopEnd).size(150.dp,262.dp)
                )

            }



            // Mohamed karam
            Spacer(modifier = Modifier.height(87.dp))

            PopularExercises (fakeExerciseItems, onClickViewAll)

//            Spacer(modifier = Modifier.height(87.dp).)
        }

}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FitnessAppScreenPreview() {
    val sampleData = UserHomeData(
        profileImage = R.drawable.drink_fruit, // Replace with actual drawable
        name = "Wasif",
        description = "GET IN SHAPE"
    )
    HealthyFitnessTheme {
        FitnessAppScreen(userHomeData = sampleData,{})
    }
}
