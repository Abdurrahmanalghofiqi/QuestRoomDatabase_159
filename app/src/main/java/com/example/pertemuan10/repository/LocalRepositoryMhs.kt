package com.example.pertemuan10.repository

class LocalRepositoryMhs (
    private val mahasiswaDao: MahasiswaDao
    ): RepositoryMhs {
        override suspend fun insertMhs
    }
