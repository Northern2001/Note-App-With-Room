package com.example.noteapp.screen.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.base.BaseBackground
import com.example.noteapp.base.CircleImage
import com.example.noteapp.common.CommonDatabase
import com.example.noteapp.model.FileModel
import com.example.noteapp.nav.RouterManager
import com.example.noteapp.ui.theme.colorBackGround

@Composable
fun DetailScreen(idFolder: String) {
    val rootController = RouterManager.current.rootController
    var value by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var model by remember { mutableStateOf(FileModel()) }
    val context = LocalContext.current
    var database = CommonDatabase.current.getDatabase(context)

    BaseBackground() {
        Row(Modifier.padding(top = 12.dp)) {
            CircleImage(icon = R.drawable.ic_back) {
                rootController?.popBackStack()
                if (title.isNotEmpty() && value.isNotEmpty()){
                    database.daoFile().insertAll(model)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            CircleImage(icon = R.drawable.ic_share) {
                rootController?.popBackStack()
            }
            Spacer(modifier = Modifier.width(10.dp))
            CircleImage(icon = R.drawable.ic_save) {
                rootController?.popBackStack()
            }
        }

        LaunchedEffect(Unit ){
            model.idFolder = idFolder.toInt()
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = title,
            placeholder = { Text(text = "Title here...") },
            onValueChange = {
                title = it
                model.title = title
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                backgroundColor = colorBackGround,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
        )
        TextField(
            modifier = Modifier
                .fillMaxSize(),
            value = value,
            placeholder = { Text(text = "Content here...") },
            onValueChange = {
                value = it
                model.title = title
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                backgroundColor = colorBackGround,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
                fontSize = 20.sp
            )
        )
    }
}