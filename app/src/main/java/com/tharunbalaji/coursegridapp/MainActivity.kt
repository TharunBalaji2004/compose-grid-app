package com.tharunbalaji.coursegridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tharunbalaji.coursegridapp.data.DataSource
import com.tharunbalaji.coursegridapp.ui.theme.CourseGridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseGridAppTheme {
                CourseTopicApp()
            }
        }
    }
}

@Composable
fun CourseTopicApp() {
    TopicList(topics = DataSource.topics)
}

@Composable
fun TopicList(topics: List<Topic>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(topics) {
            TopicCard(it, modifier = Modifier)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier) {
    Card(modifier = Modifier.padding(5.dp)) {
        Row {
            Image(
                painter = painterResource(id = topic.topicImage),
                contentDescription = "",
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 16.dp, top = 12.dp, end = 16.dp)) {
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(id = topic.topicName),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
                    Text(
                        text = topic.topicCount.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CourseGridAppTheme {
        CourseTopicApp()
    }
}