package com.example.pertemuan10
import android.app.Application
import com.example.pertemuan10.dependenciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp // Fungsi untuk menyimpan

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) // membuat instance
        // instance adalah object yanng dibuat dari class
    }
}