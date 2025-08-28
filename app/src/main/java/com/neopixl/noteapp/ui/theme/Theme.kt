package com.neopixl.noteapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple500,
    onPrimary = Color.Green,
    background = Color.White,
    secondary = Black200,
    onSecondary = Color.Black,
    surface = Color.White,
    onSurface = Purple600,
    outlineVariant = Purple400,
    surfaceContainerHighest = Color.White,
    tertiary = Orange400,
    onTertiary = Black900,
    outline = Purple700,
    scrim = Purple200
)

private val LightColorScheme = lightColorScheme(
    primary = Purple500,
    onPrimary = Color.White,
    background = Color.White,
    secondary = Black200,
    surfaceContainerHighest = Color.White,
    onSecondary = Color.Black,
    tertiary = Orange400,
    onTertiary = Black900,
    outline = Purple700,
    surface = Purple50,
    onSurface = Purple600,
    outlineVariant = Purple400,
    scrim = Purple200
)

@Composable
fun NoteAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}