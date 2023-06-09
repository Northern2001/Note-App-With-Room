package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FolderModel(
    @PrimaryKey val idFolder: Int? = null,
    @ColumnInfo(name = "title") var title: String? = null,
//    @ColumnInfo (name = "listFile") val listFile : List<FileModel>,
    var isSelected: Boolean = false
)