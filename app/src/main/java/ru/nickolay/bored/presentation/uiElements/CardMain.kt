package ru.nickolay.bored.presentation.uiElements

import android.content.res.Resources
import android.widget.ToggleButton
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nickolay.bored.R
import ru.nickolay.bored.domain.model.Activity
import ru.nickolay.bored.presentation.feature.availabilityForString
import ru.nickolay.bored.presentation.feature.formatParticipants
import ru.nickolay.bored.presentation.feature.priceOrFree

@Composable
fun MainCard(activity: Activity, toggleFavorite: ()-> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color.Black.copy(alpha = 0.1f),
                spotColor = Color.Black.copy(alpha = 0.15f)
            ),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.mockito)),
    ) {
        Box(modifier = Modifier
            .padding(16.dp)) {
            Column() {
                TopHeader(activity, toggleFavorite)
                Spacer(modifier= Modifier.height(16.dp))
                EducationRow(activity)
                Spacer(modifier = Modifier.height(16.dp))
                InformationRow(activity)
                Spacer(modifier = Modifier.height(16.dp))
                PriceAndAvailability(activity)
            }
        }
    }
}

@Composable
fun TopHeader(
    activity: Activity,
    toggleFavorite: ()-> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top

        ) {
        Text(
            text = activity.activity,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.light_green),
            modifier = Modifier.weight(1f)
            )
        IconButton(onClick = toggleFavorite, modifier = Modifier.size(40.dp)) {
            Icon(
                imageVector = if (!activity.isFavorite) {
                    Icons.Filled.Star
                }else {
                    Icons.Outlined.Star
                },
                tint = if (!activity.isFavorite) {
                    colorResource(R.color.mockito)
                } else {
                    colorResource(R.color.light_green)
                },
                modifier = Modifier.size(28.dp),
                contentDescription = if (!activity.isFavorite) "It's filled button" else "It's favorite button"
            )
        }
    }
}

@Composable
fun EducationRow(activity: Activity){
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = colorResource(R.color.mojito),
            modifier = Modifier.wrapContentWidth()
        ) {
            Text(
                text = activity.type,
                style = MaterialTheme.typography.labelLarge,
                color = colorResource(id = R.color.dark_green),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}

@Composable
fun InformationRow(activity: Activity){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        ActivityInfoRow(
            icon = Icons.Outlined.Info,
            label = activity.accessibility,
            color = colorResource(R.color.light_green)
        )
        ActivityInfoRow(
            icon = Icons.Outlined.Refresh,
            label = activity.duration,
            color = colorResource(R.color.light_green)
        )
        ActivityInfoRow(
            icon = Icons.Outlined.Person,
            label = formatParticipants(activity.participants),
            color = colorResource(R.color.light_green)
        )
    }
}

@Composable
fun ActivityInfoRow(icon: ImageVector, label: String, color: Color){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(R.color.dark_green),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun PriceAndAvailability(activity: Activity){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = colorResource(R.color.mojito),
            modifier = Modifier.wrapContentWidth()
        ) {
            Row(modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = priceOrFree(activity.price),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.dark_green)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = activity.price.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.dark_green)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.dark_green)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = availabilityForString(0.0),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.dark_green)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = activity.availability.toString(),
                color = colorResource(R.color.light_blue),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
