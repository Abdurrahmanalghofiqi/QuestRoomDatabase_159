package com.example.pertemuan10.repository

import com.example.pertemuan10.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {

    suspend fun insertMhs(mahasiswa: Mahasiswa)

    fun getAllMhs() : Flow<List<Mahasiswa>> // Memanggil fungsi getAllMahasiswa dari MahasiswaDao

    fun getMhs(nim: String): Flow<Mahasiswa> // Untuk Mengammbil data dari MahasiswaDao berdasarkan Nim

    suspend fun deletedMhs (mahasiswa: Mahasiswa) // untuk menghapus data dari MahasiswaDao

    suspend fun updateMhs(mahasiswa: Mahasiswa) //untuk update data dari MahasiswaDao



}