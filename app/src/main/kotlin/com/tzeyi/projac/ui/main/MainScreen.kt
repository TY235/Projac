package com.tzeyi.projac.ui.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tzeyi.projac.ui.component.TopBar

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {},
    ) {
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
