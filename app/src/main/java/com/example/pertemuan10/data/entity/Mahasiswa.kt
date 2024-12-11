package com.example.pertemuan10.data.entity

import androidx.room.

class Mahasiswa {
    @PrimaryKey
    val nim : String,
    val nama : String,
    val alamat : String,
    val jenisKelamin : String,
    val kelas : String,
    val angkatan : String,
    )
}