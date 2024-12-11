package com.example.pertemuan10.ui.theme.view.view.mahasiswa

import androidx.compose.runtime.Composable

@Composable
fun FormMahasiswa(
    mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    OnValueChange: (MahasiswaEvent) -> Unit,
    errorState: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
){
    val jenisKelamin = listOf("Laki-Laki", "Perempuan")
    val kelas = listOf("A", "B", "C", "D", "E")

    column(
        modifier = modifier.fillMaxWidth())
    {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.nama,
            onValueChange = {
                onValueChange(mahasiswaEvent.copy(nama = it))
            },
            label = { Text(text: "Nama")},
            isError = errorState.nama != null,
            placeholder = { Text(text: "Masukkan Nama")},
        )

        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.nim, onValueChange = {
                onValueChange(mahasiswaEvent.copy(nim = it))
            },
            label = { Text(text: "Masukkan NIM")},
            keyboardOptions = keyboardOptions(keyboardType.Number)
        )
        Text(text = errorState.nim ?: "", Color.Red)

        Spacer(modifier = Modifier.fillMaxWidth())
    }
}