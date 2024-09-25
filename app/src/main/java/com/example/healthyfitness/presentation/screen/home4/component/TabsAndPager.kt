package com.example.healthyfitness.presentation.screen.home4.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.healthyfitness.presentation.screen.home4.preview_data.tabs

@Composable
fun MyPager() {
    var selectedItemIndex by remember { mutableIntStateOf(1) }
    val pager = rememberPagerState {
        tabs.size
    }

    LaunchedEffect(selectedItemIndex) {
        pager.animateScrollToPage(selectedItemIndex)
    }

    LaunchedEffect(pager.currentPage,pager.isScrollInProgress) {
        if(!pager.isScrollInProgress){
            selectedItemIndex = pager.currentPage
        }
    }

    TabRow(selectedTabIndex = selectedItemIndex,modifier = Modifier
        .size(309.dp, 35.dp)
        .clip(RoundedCornerShape(12.dp))) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = index == selectedItemIndex,
                onClick = { selectedItemIndex = index },
                modifier = Modifier
                    .background(if (selectedItemIndex == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary),

                text = {
                    Text(text = item.title, color = if(selectedItemIndex == index ) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary)
                },
            )
        }
    }

    Spacer(modifier = Modifier.height(42.dp))

    HorizontalPager(state = pager,modifier = Modifier.fillMaxSize()) {page->

        TabContentImage(tabs[page].ImgSrc)
    }

}

@Composable
fun TabContentImage(
    imgSrc : Int
) {
    Image(
        painter = painterResource(id = imgSrc),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp)),
        contentScale = ContentScale.Crop
    )
}