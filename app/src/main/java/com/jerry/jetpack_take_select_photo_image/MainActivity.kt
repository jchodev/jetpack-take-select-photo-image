package com.jerry.jetpack_take_select_photo_image

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.jerry.jetpack_take_select_photo_image.components.MyImageArea
import com.jerry.jetpack_take_select_photo_image.ui.theme.JetpacktakeselectphotoimageTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            JetpacktakeselectphotoimageTheme {

                Scaffold { paddingValues ->
                    Box (
                        modifier = Modifier
                            .padding(paddingValues)
                    ){
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {

                            val uri = remember { mutableStateOf<Uri?>(null) }

                            //image to show bottom sheet
                            MyImageArea(
                                directory = File(cacheDir, "images"),
                                uri = uri.value,
                                onSetUri = {
                                    uri.value = it
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

