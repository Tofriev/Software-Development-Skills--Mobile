package com.example.part1


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.w3c.dom.Text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument

data class MarketplaceItem(val name: String, val description: String, val price: String, val onClick: () -> Unit)

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.PeachScreen.route)
        {
            ItemScreen(navController, "Peach", R.drawable.peach)
        }
        composable(
            route = Screen.CornScreen.route)
        {
            ItemScreen(navController, "Corn", R.drawable.corn)
        }
        composable(
            route = Screen.KiwiScreen.route)
        {
            ItemScreen(navController, "Kiwi", R.drawable.kiwi)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){

    val items = listOf(
        MarketplaceItem("Peach", "Don't tell Browser!", "$10"){
            navController.navigate(Screen.PeachScreen.route)
        },
        MarketplaceItem("Corn", "This corn is great for BBQ", "$15"){
            navController.navigate(Screen.CornScreen.route)
        },
        MarketplaceItem("Kiwi", "Very rich in Vitamin C!", "$20"){
            navController.navigate(Screen.KiwiScreen.route)
        },

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Marketplace",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
            )
        },
        content = {innerPadding->
            LazyColumn(
                modifier = Modifier.padding(innerPadding)
            ) {
                itemsIndexed(items) { index, item ->
                    // Wrap each row with Modifier.clickable and pass the action lambda
                    MarketplaceItemRow(item = item, onItemClick = item.onClick)
                }
            }
        })
}


@Composable
fun MarketplaceItemRow(item: MarketplaceItem, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick() },
        verticalAlignment = Alignment.Top


    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Item name
            Text(
                text = item.name,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
            )

            // Description
            Text(
                text = item.description,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // Price
        Text(
            text = item.price,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeachScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Peach",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
            )
        },
        content = { innerPadding ->
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ){
                Image(
                    painter = painterResource(id = R.drawable.peach),
                    contentDescription = "Peach Image",
                    modifier = Modifier.size(200.dp)
                )
            }
        })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(navController: NavController, itemName: String, itemResource:Int){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = itemName,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
            )
        },
        content = { innerPadding ->
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ){
                Image(
                    painter = painterResource(id = itemResource),
                    contentDescription = "$itemName Image",
                    modifier = Modifier.size(200.dp)
                )
            }
        })
}
