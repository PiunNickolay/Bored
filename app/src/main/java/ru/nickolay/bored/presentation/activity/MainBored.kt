package ru.nickolay.bored.presentation.activity

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import ru.nickolay.bored.R
import ru.nickolay.bored.presentation.feature.NavigationItems
import ru.nickolay.bored.presentation.uiElements.MainCard
import ru.nickolay.bored.presentation.viewModel.MainActivityViewModel


@Composable
fun MainBored(viewModel: MainActivityViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.deep_blue),
                        colorResource(id = R.color.light_blue).copy(alpha = 0.7f),
                        colorResource(id = R.color.light_blue).copy(alpha = 0.5f)
                    )
                )
            )
    ) {
        val bored by viewModel.state.collectAsState()
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Right,

                ) {
                FloatingActionButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(end = 24.dp, top = 48.dp),
                    containerColor = colorResource(R.color.mockito),
                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation(8.dp)

                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = "filter",
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxHeight(0.65f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MainCard()
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.mojito)
                    ),
                    elevation = ButtonDefaults.buttonElevation(8.dp)
                ) {
                    Text(
                        "Найти занятие",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 24.dp)
            ){
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    color = colorResource(id = R.color.light_mockito).copy(alpha = 0.95f),
                    shadowElevation = 16.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NavigationBarItem(
                            selected = true,
                            onClick = { /* Home */ },
                            icon = {
                                Icon(Icons.Default.Home, "Главная",
                                    tint = colorResource(id = R.color.dark_green))
                            },
                            label = { Text("Главная",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(id = R.color.dark_green))
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Transparent
                            )
                        )
                        NavigationBarItem(
                            selected = false,
                            onClick = { /* Favorites */ },
                            icon = {
                                Icon(Icons.Default.FavoriteBorder, "Избранное",
                                    tint = colorResource(id = R.color.dark_green))
                            },
                            label = { Text("Избранное",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(id = R.color.dark_green))
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Transparent
                            )
                        )
                        NavigationBarItem(
                            selected = false,
                            onClick = { /* Settings */ },
                            icon = {
                                Icon(Icons.Default.Settings, "Настройки",
                                    tint = colorResource(id = R.color.dark_green))
                            },
                            label = { Text("Настройки",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(id = R.color.dark_green))
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Transparent
                            )
                        )
                    }
                }
            }

        }

    }
}

@Preview
@Composable
fun PreviewMainBored() {
    MainBored()
}
