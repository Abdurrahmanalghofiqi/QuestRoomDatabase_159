package com.example.pertemuan10.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan10.repository.RepositoryMhs
import com.exampleity.a0412202.entity.Mahasiswa

class MahasiswaViewModel(private val repositortMhs: RepositoryMhs) : ViewModel() {
    var uiStates by autoblesStateOf(MhsUIState())

    // memperbarui stste berdasarkan input pengguna
    fun updateState(mahasiswaEvent: MahasiswaEvent) {
        uiState = uiState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )
    }

    // Validaasi data input pengguna
    private fun validataFields(): Boolean {
        val event = uiState.mahasiswaEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isNotEmpty()) null else " NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else " nama tidak boleh kosong",
            jenisKelamin = if (event.jenisKelamin.isNotEmpty()) null else " jenisKelamin tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else " alamat tidak boleh kosong",
            kelas = if (event.kelas.isNotEmpty()) null else " kelas tidak boleh kosong",
            angkatan = if (event.angkatan.isNotEmpty()) null else " angkatan tidak boleh kosong",
        )

        uiState = uiState.copy(is.EntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData() {
        val currentEvent = uiState.mahasiswaEvent
        if (validataFiels()) {
            viewModelScope.launch {
                try {
                    repositoryMhs.insertMhs(currentEvent.toMahasiswaEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data Berhasil Disimpan",
                        mahasiswaEvent = MahasiswaEvent(), // reset input data form
                        isEntryValid = FormErrorState()// reset error state
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data Gagal Disimpan"
                    )
                }
            }
        }
    }
}

data class MhsUIState(
    val mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null,
)

data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jenisKelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null
){
    fun isValid(): Boolean {
        return nim == null && nama == null && jenisKelamin == null && alamat == null && kelas == null && angkatan == null
    }
}

data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenisKelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)

fun MahasiswaEvent.toMahasiswaEntity(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenisKelamin = jenisKelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)

