package com.dennis.covidapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dennis.covidappcompose.R

@Composable
fun RegionStatusDisplay(
    state: CovidDataState,
    modifier: Modifier = Modifier
) {
    state.covidInfo?.covidData?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Australia",
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CovidSecondaryDataDisplay(
                    value = data.confirmed.toString(),
                    unit = "Confirmed",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_confirmed),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
                CovidSecondaryDataDisplay(
                    value = data.fatalityRate.toString(),
                    unit = "Fatality",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_fatality),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
                CovidSecondaryDataDisplay(
                    value = data.deaths.toString(),
                    unit = "Deaths",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_deaths),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
            }
        }
    }
}