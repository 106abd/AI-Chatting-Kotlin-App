package com.example.aichattingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Chat(modifier: Modifier = Modifier) {

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextLog(modifier = modifier)

        // Move chatbox to the bottom
        Spacer(Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 30.dp)
        ) {

            // Chatbox
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(end = 10.dp)

                )

            IconButton(
                onClick = {},
                modifier = Modifier.size(55.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(color = Color.Green)


            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_add_comment_24),
                    contentDescription = "Send",
                    tint = Color.Black
                )
            }

        }
    }

}

@Composable
fun TextLog(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "YOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.DarkGray)
                .padding(10.dp)

        )
    }
}