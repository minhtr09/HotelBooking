package com.example.hotelbooking.view.properties

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelbooking.R
import com.example.hotelbooking.navigation.Route
import com.example.hotelbooking.ui.utility.AppBar
import com.example.hotelbooking.ui.utility.CheckboxWithDescription
import com.example.hotelbooking.ui.utility.TextFieldWithIncrement

@Composable
fun PropertiesDetailScreen() {
    var nofRoom: Int by remember { mutableStateOf(1) }
    var nofAdult: Int by remember { mutableStateOf(1) }
    var nofChildren: Int by remember { mutableStateOf(0) }

    var nofSingleBedBedRoom: Int by remember { mutableStateOf(1) }
    var nofDoubleSingleBedBedRoom: Int by remember { mutableStateOf(1) }
    var nofDoubleBedBedRoom: Int by remember { mutableStateOf(1) }

    val botRoom: Int = 1;
    val botAdult: Int = 1;
    val botChildren: Int = 0;

    val botSingleBedBedRoom: Int = 0;
    val botDoubleSingleBedBedRoom: Int = 0;
    val botDoubleBedBedRoom: Int = 0;

    var roomDisabled: Boolean by remember { mutableStateOf(true) }
    var adultDisabled: Boolean by remember { mutableStateOf(true) }
    var childrenDisabled: Boolean by remember { mutableStateOf(true) }

    var SingleBedBedRoomDisabled: Boolean by remember { mutableStateOf(false) }
    var DoubleSingleBedBedRoomDisabled: Boolean by remember { mutableStateOf(false) }
    var DoubleBedBedRoomDisabled: Boolean by remember { mutableStateOf(false) }

    var airConditioner: Boolean by remember { mutableStateOf(false) }
    var tv: Boolean by remember { mutableStateOf(false) }
    var showerChamber: Boolean by remember { mutableStateOf(false) }
    var shower: Boolean by remember { mutableStateOf(false) }
    var hotColdMachine: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = Route.PropertiesScreen,
                currentScreenName = stringResource(id = R.string.propertiesDetails_screen),
                canNavigateBack = false,
                navigateUp = { /*TODO*/ })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(dimensionResource(R.dimen.screenPadding))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.columnPadding))
        ) {
            Column {
                CommonBodyText(text = "Số lượng của loại hình này")
                Spacer(Modifier.height(4.dp))
                TextFieldWithIncrement(
                    value = nofRoom,
                    onIncrementClick = {
                        nofRoom += 1
                        roomDisabled = false
                    },
                    onDecrementClick = {
                        if (nofRoom > botRoom) {
                            nofRoom -= 1;
                            if (nofRoom == botRoom) {
                                roomDisabled = true;
                            }
                        }
                    },
                    isDecDisable = roomDisabled
                )
            }
            Column {
                CommonBodyText(text = "Số người lớn có thể ở")
                Spacer(Modifier.height(4.dp))
                TextFieldWithIncrement(
                    value = nofAdult,
                    onIncrementClick = {
                        nofAdult += 1
                        adultDisabled = false
                    },
                    onDecrementClick = {
                        if (nofAdult > botAdult) {
                            nofAdult -= 1;
                            if (nofAdult == botAdult) {
                                adultDisabled = true;
                            }
                        }
                    },
                    isDecDisable = adultDisabled
                )
            }
            Column {
                CommonBodyText(text = "Số trẻ em có thể ở")
                Spacer(Modifier.height(4.dp))
                TextFieldWithIncrement(
                    value = nofChildren,
                    onIncrementClick = {
                        nofChildren += 1
                        childrenDisabled = false
                    },
                    onDecrementClick = {
                        if (nofChildren > botChildren) {
                            nofChildren -= 1;
                            if (nofChildren == botChildren) {
                                childrenDisabled = true;
                            }
                        }
                    },
                    isDecDisable = childrenDisabled
                )
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Phòng",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                CommonRowWithTextField(
                    description = "Phòng ngủ\n( 1 giường đơn) ",
                    value = nofSingleBedBedRoom,
                    onIncrementClick = {
                        nofSingleBedBedRoom += 1
                        SingleBedBedRoomDisabled = false
                    },
                    onDecrementClick = {
                        if (nofSingleBedBedRoom > botSingleBedBedRoom) {
                            nofSingleBedBedRoom -= 1;
                            if (nofSingleBedBedRoom == botSingleBedBedRoom) {
                                SingleBedBedRoomDisabled = true;
                            }
                        }
                    },
                    isDisabled = SingleBedBedRoomDisabled
                )
                CommonRowWithTextField(
                    description = "Phòng ngủ\n( 2 giường đơn) ",
                    value = nofDoubleSingleBedBedRoom,
                    onIncrementClick = {
                        nofDoubleBedBedRoom += 1
                        DoubleBedBedRoomDisabled = false
                    },
                    onDecrementClick = {
                        if (nofDoubleBedBedRoom > botDoubleBedBedRoom) {
                            nofDoubleBedBedRoom -= 1;
                            if (nofDoubleBedBedRoom == botDoubleBedBedRoom) {
                                DoubleBedBedRoomDisabled = true;
                            }
                        }
                    },
                    isDisabled = DoubleBedBedRoomDisabled
                )
                CommonRowWithTextField(
                    description = "Phòng ngủ\n( 1 giường đôi) ",
                    value = nofDoubleBedBedRoom,
                    onIncrementClick = {
                        nofDoubleBedBedRoom += 1
                        DoubleBedBedRoomDisabled = false
                    },
                    onDecrementClick = {
                        if (nofDoubleBedBedRoom > botDoubleBedBedRoom) {
                            nofDoubleBedBedRoom -= 1;
                            if (nofDoubleBedBedRoom == botDoubleBedBedRoom) {
                                DoubleBedBedRoomDisabled = true;
                            }
                        }
                    },
                    isDisabled = DoubleBedBedRoomDisabled
                )
            }

            Spacer(Modifier.height(4.dp))
            Text(
                text = "Nội thất",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))

            Column() {
                CheckboxWithDescription(
                    checked = airConditioner,
                    onCheckedChange = { airConditioner = it },
                    description = "Điều hòa"
                )
                CheckboxWithDescription(
                    checked = tv,
                    onCheckedChange = { tv = it },
                    description = "Tivi"
                )
                CheckboxWithDescription(
                    checked = showerChamber,
                    onCheckedChange = { showerChamber = it },
                    description = "Bồn tắm"
                )
                CheckboxWithDescription(
                    checked = shower,
                    onCheckedChange = { shower = it },
                    description = "Bãi đậu xe miễn phí"
                )
                CheckboxWithDescription(
                    checked = hotColdMachine,
                    onCheckedChange = { hotColdMachine = it },
                    description = "Máy nóng lạnh"
                )
            }
        }

    }
}

@Composable
fun CommonBodyText(text: String, color: Color = colorResource(id = R.color.black), modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier,
        color = color
    )
}

@Composable
fun CommonHeaderText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun CommonRowWithTextField(
    modifier: Modifier = Modifier,
    description: String,
    onIncrementClick: () -> (Unit),
    onDecrementClick: () -> (Unit),
    isDisabled: Boolean = false,
    value: Int,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CommonBodyText(text = description)
        Spacer(Modifier.weight(1f))
        TextFieldWithIncrement(
            value = value,
            onIncrementClick = onIncrementClick,
            onDecrementClick = onDecrementClick,
            isDecDisable = isDisabled
        )
    }
}