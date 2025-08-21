package com.example.androidbasicui.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
data class ListItemData(
    val id: Int,
    val icon: ImageVector,
    val title: String,
    val subtitle: String,
    val category: String,
    val timestamp: String,
    val iconColor: Color = Color.Unspecified // For custom icon background
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier.fillMaxSize()) {

    val sampleItems = listOf(
        ListItemData(1, Icons.Filled.Add, "The Future of Jetpack Compose", "An in-depth look at upcoming features and trends.", "Technology", "2h ago", iconColor = Color(0xFF4CAF50)),
        ListItemData(2, Icons.Filled.Build, "Mastering Color Theory", "Learn how to choose and combine colors effectively in your designs.", "Design", "Yesterday", iconColor = Color(0xFF2196F3)),
        ListItemData(3, Icons.Filled.Call, "Kotlin Coroutines Best Practices", "Optimize your asynchronous code with these tips.", "Development", "3d ago", iconColor = Color(0xFFFFC107)),
        ListItemData(4, Icons.Filled.Done, "Startup Funding Guide", "Navigating the venture capital landscape in 2024.", "Business", "1w ago", iconColor = Color(0xFFE91E63)),
        ListItemData(5, Icons.Filled.Edit, "Advanced Machine Learning", "A new course covering deep learning and neural networks.", "Education", "Mar 10", iconColor = Color(0xFF9C27B0)),
        ListItemData(6, Icons.Filled.Favorite, "Urban Living Trends", "How cities are evolving to meet modern demands.", "Lifestyle", "Mar 5", iconColor = Color(0xFF795548)),
        ListItemData(7, Icons.Filled.Settings, "DIY Home Renovation", "Tips and tricks for your next big project.", "Home", "Feb 28", iconColor = Color(0xFF009688)),
        ListItemData(8, Icons.Filled.Share, "Social Media Strategies", "Boosting engagement and reach.", "Marketing", "Feb 25", iconColor = Color(0xFF607D8B))
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceBright), // Brighter background for content area
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sampleItems, key = { it.id }) { item ->
            ListItemCard(item = item)
        }
    }}