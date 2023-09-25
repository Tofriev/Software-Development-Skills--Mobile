package com.example.part1

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object PeachScreen : Screen("peach_screen")
    object CornScreen : Screen("corn_screen")
    object KiwiScreen : Screen("kiwi_screen")

}
