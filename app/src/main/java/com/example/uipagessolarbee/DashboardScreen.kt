package com.example.uipagessolarbee

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Engineering
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Engineering
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {

    Scaffold(
        topBar = { DashboardTopBar() },
        bottomBar = { DashboardBottomNavigation() },
        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item { QuickActionsSection() }
            item { PerformanceOverview() }
            item { RecentActivity() }
            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp)
            ) {
                Icon(
                    Icons.Default.WbSunny,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Solar Bee",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            )
            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
        navigationIcon = {
            IconButton(onClick = { /* Handle menu */ }) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        actions = {
            IconButton(onClick = { /*...*/ }, modifier = Modifier.size(50.dp)) {
                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = MaterialTheme.colorScheme.error,
                            contentColor = MaterialTheme.colorScheme.onError,
                            modifier = Modifier
                                .wrapContentWidth()
                            // .defaultMinSize(minWidth = 24.dp) // increase so "9+" fits
                            // optional extra padding


                        ) {
                            Text(
                                text = "999+",
                                style = MaterialTheme.typography.labelSmall,
                                maxLines = 1
                            )
                        }
                    },
                    modifier = Modifier
                    // give more size so badge isn’t clipped by parent bounds

                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(26.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
}


@Composable
fun QuickActionsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
        ActionGrid()
    }
}

@Composable
fun ActionGrid() {
    val actions = listOf(
        ActionItem("Add Customer", Icons.Default.PersonAdd, MaterialTheme.colorScheme.primary),
        ActionItem("Inventory", Icons.Default.Inventory, MaterialTheme.colorScheme.secondary),
        ActionItem("Quotations", Icons.Default.Description, MaterialTheme.colorScheme.tertiary),
        ActionItem("Shipments", Icons.Default.LocalShipping, MaterialTheme.colorScheme.error),
        ActionItem("Analytics", Icons.Default.Analytics, MaterialTheme.colorScheme.primary),
        ActionItem("Reports", Icons.Default.Assessment, MaterialTheme.colorScheme.secondary)
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        actions.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { item ->
                    ActionCard(
                        action = item,
                        modifier = Modifier.weight(1f)
                    )
                }
                // Fill remaining space if less than 3 items
                repeat(3 - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun ActionCard(
    action: ActionItem,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .aspectRatio(1f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = true,
                    radius = 30.dp,
                    color = Color.White
                ),
                onClick = {

                }
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isPressed) 2.dp else 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = action.color.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = action.icon,
                    contentDescription = action.title,
                    modifier = Modifier.size(24.dp),
                    tint = action.color
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = action.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun PerformanceOverview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Performance Overview",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val change = "12.90%"
            MetricCard(
                title = "Total Revenue",
                value = "₹2,45,000",
                change = change,
                isPositive = true,
                icon = Icons.Default.TrendingUp,
                modifier = Modifier.weight(1f)
            )
            MetricCard(
                title = "Active Projects",
                value = "28",
                change = "+3.89",
                isPositive = true,
                icon = Icons.Default.Engineering,
                modifier = Modifier.weight(1f)
            )
        }

        AnimatedProgressSection()
    }
}

@Composable
fun AnimatedProgressSection() {
    val progressData = listOf(
        ProgressData("Customer Satisfaction", 0.56f, 56),
        ProgressData("Project Completion", 0.72f, 72),
        ProgressData("Team Efficiency", 0.90f, 90)
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            progressData.forEach { data ->
                AnimatedProgressIndicator(data)
            }
        }
    }
}

@Composable
fun AnimatedProgressIndicator(data: ProgressData) {
    var animatedProgress by remember { mutableStateOf(0f) }

    LaunchedEffect(data.progress) {
        animatedProgress = 0f
        delay(100)
        val animationSpec = tween<Float>(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
        animate(
            initialValue = 0f,
            targetValue = data.progress,
            animationSpec = animationSpec
        ) { value, _ ->
            animatedProgress = value
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.label,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = "${data.percentage}%",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary
            )
        }

        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        )
    }
}

@Composable
fun RecentActivity() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Recent Activity",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                TextButton(onClick = { /* View all */ }) {
                    Text("View All")
                }
            }

            val activities = listOf(
                ActivityItem("New customer onboarded", "2 hours ago", Icons.Default.PersonAdd),
                ActivityItem("Quotation sent to ABC Corp", "4 hours ago", Icons.Default.Send),
                ActivityItem(
                    "Solar panel installation completed",
                    "1 day ago",
                    Icons.Default.CheckCircle
                )
            )

            activities.forEach { activity ->
                ActivityRow(activity)
            }
        }
    }
}

@Composable
fun ActivityRow(activity: ActivityItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {},
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = activity.icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = activity.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = activity.time,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}


@Composable
fun MetricCard(
    title: String,
    value: String,
    change: String,
    isPositive: Boolean,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (isPositive) Icons.Default.TrendingUp else Icons.Default.TrendingDown,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = if (isPositive) Color(0xFF4CAF50) else Color(0xFFE57373)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = change,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = if (isPositive) Color(0xFF4CAF50) else Color(0xFFE57373)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardBottomNavigation() {
    val navigationItems = listOf(
        BottomNavItem("Dashboard", Icons.Filled.Dashboard, Icons.Outlined.Dashboard, true),
        BottomNavItem("Customers", Icons.Filled.People, Icons.Outlined.People, false),
        BottomNavItem("Projects", Icons.Filled.Engineering, Icons.Outlined.Engineering, false),
        BottomNavItem("Finance", Icons.Filled.AccountBalance, Icons.Outlined.AccountBalance, false),

        )

    Box {
        NavigationBar(
            modifier = Modifier
                .height(85.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
            containerColor = MaterialTheme.colorScheme.surface,

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                val isDarkMode = isSystemInDarkTheme()

                navigationItems.forEach { item ->
                    NavigationBarItem(

                        icon = {
                            Icon(
                                imageVector = if (item.selected) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.label,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = if (item.selected) FontWeight.Bold else FontWeight.Normal
                                )
                            )
                        },
                        selected = item.selected,
                        onClick = { /* Handle navigation */ },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = if (isDarkMode) Color.White else MaterialTheme.colorScheme.primary,
                            selectedTextColor = if (isDarkMode) Color.White else MaterialTheme.colorScheme.primary,
                            unselectedIconColor = if (isDarkMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = if (isDarkMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(12.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.08f),
                            Color.Transparent
                        )
                    )
                )
        )
    }
}

data class ActionItem(
    val title: String,
    val icon: ImageVector,
    val color: Color
)

data class BottomNavItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val selected: Boolean
)

data class ProgressData(
    val label: String,
    val progress: Float,
    val percentage: Int
)

data class ActivityItem(
    val title: String,
    val time: String,
    val icon: ImageVector
)