package com.example.uipagessolarbee.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

// Light Theme Color Scheme
private val LightColorScheme = lightColorScheme(
    // Primary Colors
    primary = SolarOrange,
    onPrimary = Color.White,
    primaryContainer = SolarOrange.copy(alpha = 0.1f),
    onPrimaryContainer = SolarOrangeDark,

    // Secondary Colors
    secondary = DeepBlue,
    onSecondary = Color.White,
    secondaryContainer = DeepBlue.copy(alpha = 0.1f),
    onSecondaryContainer = DeepBlue,

    // Tertiary Colors
    tertiary = SolarGold,
    onTertiary = Color.White,
    tertiaryContainer = SolarGold.copy(alpha = 0.1f),
    onTertiaryContainer = SolarGold,

    // Error Colors
    error = ErrorRed,
    onError = Color.White,
    errorContainer = ErrorRed.copy(alpha = 0.1f),
    onErrorContainer = ErrorRed,

    // Background Colors
    background = BackgroundLight,
    onBackground = NeutralBlack,

    // Surface Colors
    surface = SurfaceLight,
    onSurface = NeutralBlack,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = TechGray,

    // Outline Colors
    outline = NeutralMedium,
    outlineVariant = NeutralLight,

    // Other Colors
    scrim = Color.Black.copy(alpha = 0.32f),
    inverseSurface = NeutralDark,
    inverseOnSurface = NeutralLight,
    inversePrimary = SolarOrange.copy(alpha = 0.8f),
    surfaceTint = SolarOrange
)

// Dark Theme Color Scheme
private val DarkColorScheme = darkColorScheme(
    // Primary Colors
    primary = SolarOrange,
    onPrimary = Color.Black,
    primaryContainer = SolarOrangeDark,
    onPrimaryContainer = SolarOrange.copy(alpha = 0.9f),

    // Secondary Colors
    secondary = LightBlue,
    onSecondary = Color.Black,
    secondaryContainer = DeepBlue,
    onSecondaryContainer = LightBlue,

    // Tertiary Colors
    tertiary = SolarYellow,
    onTertiary = Color.Black,
    tertiaryContainer = SolarGold,
    onTertiaryContainer = SolarYellow,

    // Error Colors
    error = ErrorRed.copy(alpha = 0.9f),
    onError = Color.White,
    errorContainer = ErrorRed.copy(alpha = 0.3f),
    onErrorContainer = ErrorRed.copy(alpha = 0.9f),

    // Background Colors
    background = BackgroundDark,
    onBackground = NeutralLight,

    // Surface Colors
    surface = SurfaceDark,
    onSurface = NeutralLight,
    surfaceVariant = Color(0xFF2C2C2E),
    onSurfaceVariant = SoftGray,

    // Outline Colors
    outline = NeutralDark,
    outlineVariant = Color(0xFF3C3C3E),

    // Other Colors
    scrim = Color.Black.copy(alpha = 0.5f),
    inverseSurface = NeutralLight,
    inverseOnSurface = NeutralDark,
    inversePrimary = SolarOrangeDark,
    surfaceTint = SolarOrange
)

// Custom Typography for Professional Business App
val SolarBeeTypography = Typography(
    // Display Styles
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),

    // Headline Styles
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),

    // Title Styles
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    // Body Styles
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // Label Styles
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun SolarBeeTheme(
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

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}