package com.dennis.covidapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter
import com.dennis.covidappcompose.R

@Composable
fun GlobalStatCard(
    state: CovidDataState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.covidInfo?.covidData?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "World Covid Stats",
                        color = Color.White
                    )
                    Text(
                        text = "${
                            data.date?.format(
                                DateTimeFormatter.ofPattern("HH:mm")
                            )
                        }",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_world),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.confirmed}",
                    fontSize = 50.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Confirmed Cases",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    CovidSecondaryDataDisplay(
                        value = data.fatalityRate.toString(),
                        unit = "Fatality Rate",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_fatality),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    CovidSecondaryDataDisplay(
                        value = data.deaths!!.toString(),
                        unit = "Deaths",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_deaths),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}
