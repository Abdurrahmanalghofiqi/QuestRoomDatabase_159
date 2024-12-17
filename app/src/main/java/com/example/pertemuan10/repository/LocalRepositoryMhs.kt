package com.example.pertemuan10.repository

import com.example.pertemuan10.data.dao.MahasiswaDao
import com.example.pertemuan10.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {

    override suspend fun insertMhs(mahasiswa: Mahasiswa){
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
    // getAllMhs
    override fun getAllMhs (): Flow<List<Mahasiswa>> {
        return  mahasiswaDao.getAllMahasiswa()
    }
    // getMhs
    override fun getMhs(nim: String): Flow<Mahasiswa> {
        return mahasiswaDao.getMahasiswa(nim)
    }
    // deletedMhs
    override suspend fun deletedMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.deletedMAhasiswa(mahasiswa)
    }
    // updateMhs
    override suspend fun updateMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.updateMahasiswa(mahasiswa)
    }
}
