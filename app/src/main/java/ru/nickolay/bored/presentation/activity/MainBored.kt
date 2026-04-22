package ru.nickolay.bored.presentation.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import ru.nickolay.bored.R
import ru.nickolay.bored.presentation.feature.NavigationItems


@Composable
fun MainBored() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.deep_blue),
                    colorResource(id = R.color.light_blue).copy(alpha=0.7f),
                    colorResource(id = R.color.light_blue).copy(alpha=0.5f)
                )
            ))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .align(Alignment.Center),

        ) { }
    }
}

@Preview
@Composable
fun PreviewMainBored() {
    MainBored()
}