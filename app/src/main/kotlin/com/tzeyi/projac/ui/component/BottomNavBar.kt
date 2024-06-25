package com.tzeyi.projac.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(
    tabBarItems: List<TabBarItem>,
    navController: NavController,
) {
    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        // looping over each tab to generate the views and navigation for each item
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(selected = selectedTabIndex == index, onClick = {
                selectedTabIndex = index
                navController.navigate(tabBarItem.title)
            }, icon = {
                TabBarIconView(
                    isSelected = selectedTabIndex == index,
                    selectedIcon = tabBarItem.selectedIcon,
                    unselectedIcon = tabBarItem.unselectedIcon,
                    title = tabBarItem.title,
                )
            }, label = { Text(tabBarItem.title) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    title: String,
) {
    Icon(
        imageVector =
            if (isSelected) {
                selectedIcon
            } else {
                unselectedIcon
            },
        contentDescription = title,
    )
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    val mapTab =
        TabBarItem(
            title = "Map View",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        )
    val incidentTab =
        TabBarItem(
            title = "Current Incident",
            selectedIcon = Icons.Filled.LocationOn,
            unselectedIcon = Icons.Outlined.LocationOn,
        )
    val accountTab =
        TabBarItem(
            title = "Account",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
        )

    // creating a list of all the tabs
    val tabBarItems = listOf(mapTab, incidentTab, accountTab)

    // creating our navController
    val navController = rememberNavController()

    BottomBar(tabBarItems, navController)
}
