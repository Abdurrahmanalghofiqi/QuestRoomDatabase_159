package com.example.pertemuan10.data.dao

interface MahasiswaDao {
    @Insertm
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}