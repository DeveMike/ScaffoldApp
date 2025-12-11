package com.devemike.scaffoldapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.TopAppBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(title: String, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { /* optional */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Info") },
                    onClick = {
                        expanded = false
                        navController.navigate("info")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        expanded = false
                        navController.navigate("settings")
                    }
                )
            }
        }
    )
}