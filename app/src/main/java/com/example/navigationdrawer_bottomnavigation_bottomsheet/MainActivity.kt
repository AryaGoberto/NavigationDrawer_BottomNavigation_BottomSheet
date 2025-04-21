package com.example.navigationdrawer_bottomnavigation_bottomsheet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer_bottomnavigation_bottomsheet.ui.theme.Blacky
import com.example.navigationdrawer_bottomnavigation_bottomsheet.ui.theme.NavigationDrawer_BottomNavigation_BottomSheetTheme
import com.example.navigationdrawer_bottomnavigation_bottomsheet.ui.theme.Oranye
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationDrawer_BottomNavigation_BottomSheetTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize()//
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnNavBotSheet()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavBotSheet() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    val selected = remember{
        mutableStateOf(Icons.Default.Home)
    }
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet by remember {
        mutableStateOf(false)
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Blacky)
                    .height(150.dp)
                ){
                    Text(text = "")
                }
                Divider()
                //Home
                NavigationDrawerItem(
                    label = {Text(text = "Home", color = Oranye)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Home, contentDescription = null, tint = Oranye)},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screens){
                            popUpTo(0)
                        }
                    }
                )
                //Profile
                NavigationDrawerItem(
                    label = {Text(text = "Profile", color = Oranye)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Oranye)},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screens){
                            popUpTo(0)
                        }
                    }
                )
                //Settings
                NavigationDrawerItem(
                    label = {Text(text = "Settings", color = Oranye)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Settings, contentDescription = null, tint = Oranye)},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screens){
                            popUpTo(0)
                        }
                    }
                )
                //Logout
                NavigationDrawerItem(
                    label = {Text(text = "Logout", color = Oranye)},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null, tint = Oranye)},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Log out", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        },

    ) {
        Scaffold (
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = {Text(text = "Whatsapp")},
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Blacky,
                        titleContentColor = Oranye,
                        navigationIconContentColor = Oranye
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Rounded.Menu, contentDescription = "MenuButton")
                        }
                    }
                )
            }
        ){
            //BottomBar
        }
    }
}

