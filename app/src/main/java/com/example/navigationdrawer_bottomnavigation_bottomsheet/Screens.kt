package com.example.navigationdrawer_bottomnavigation_bottomsheet

sealed class Screens(val screens: String){
    data object Home: Screens("home")
    data object Profile: Screens("profile")
    data object Notification: Screens("notification")
    data object Post: Screens("post")
    data object Settings: Screens("settings")
    data object Search: Screens("search")
}