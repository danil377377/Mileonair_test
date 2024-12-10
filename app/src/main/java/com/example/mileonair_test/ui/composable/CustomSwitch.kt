package com.example.mileonair_test.ui.composable

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit = {}, // Заглушка
    modifier: Modifier = Modifier,
    thumbColor: Color = Color.White,
    trackColorOn: Color = Color.Red,
    trackColorOff: Color = Color.Gray,
    height: Dp = 20.dp,
    width: Dp = 40.dp,
) {
    val density = LocalDensity.current
    val animationSpec = tween<Float>(durationMillis = 200)
    val targetOffsetX = with(density) {
        if (checked) 50f else 0f
    }

    val animatedOffsetX by animateFloatAsState(
        targetValue = targetOffsetX,
        animationSpec = animationSpec
    )

    Row(
        modifier = modifier
            .height(height)
            .width(width)
            .clip(RoundedCornerShape(height / 2))
            .background(if (checked) trackColorOn else trackColorOff)
            .clickable { onCheckedChange(!checked) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(height)
                .graphicsLayer { translationX = animatedOffsetX }
                .clip(CircleShape)
                .background(thumbColor)
        )
    }
}


