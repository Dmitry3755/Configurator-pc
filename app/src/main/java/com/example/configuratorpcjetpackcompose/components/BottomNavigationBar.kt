package com.example.configuratorpcjetpackcompose.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.configuratorpcjetpackcompose.navigation.BottomNavigationGraph
import com.example.configuratorpcjetpackcompose.navigation.BottomNavigationItem
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navigationItems = listOf(
        BottomNavigationItem.ConfigurationScreen,
        BottomNavigationItem.FavoriteScreen,
        BottomNavigationItem.SearchScreen,
        BottomNavigationItem.SettingsScreen,
        BottomNavigationItem.AccountScreen
    )

    BottomNavigation(
        backgroundColor = AppTheme.colors.backgroundMainScreenColor,
        contentColor = AppTheme.colors.textMainColor
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navigationItems.forEach { item ->
            BottomNavigationItem( // TODO: Сделать выравнивание по тексту, а не по иконке (чтоб весь текст влезал)
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                selectedContentColor = AppTheme.colors.borderConfigurationColor,
                unselectedContentColor = AppTheme.colors.textMainColor,
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        BottomNavigationBar(navController)
    }
}