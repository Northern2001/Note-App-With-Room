package com.example.noteapp.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.noteapp.screen.SplashScreen
import com.example.noteapp.screen.detail.DetailScreen
import com.example.noteapp.screen.home.HomeScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun NavGraphBuilder.authGraph() {
    navigation(
        startDestination = DestinationName(true).splashScreen,
        route = "AUTH_GRAPH"
    ) {
        composable(DestinationName(true).splashScreen) {
            SplashScreen()
        }
        composable(DestinationName(true).homeScreen) {
            HomeScreen()
        }
        composable(DestinationName(true).detailScreen) {
            DetailScreen(
                it.arguments?.getString(ParamName.ID_FOLDER)?:"",
                it.arguments?.getString(ParamName.ID_FILE)?:""
            )
        }
    }
}