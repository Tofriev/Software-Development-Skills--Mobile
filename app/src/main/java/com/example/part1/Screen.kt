package com.example.part1

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object HelloScreen : Screen("hello_screen")

}
