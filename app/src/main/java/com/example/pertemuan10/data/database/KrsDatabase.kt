package com.example.pertemuan10.data.database

class KrsDatabase : RoomDatabase() {

    //Mendefinisikan fungsi untuk mengakses data Mahasiswa

    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile  // Memastikan bahwa nilai variabel instance selalu sama
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java,  // Class database
                    "KrsDatabase"  // Nama Database
                )
                    .build().also { Instance = it }
            })
        }
    }
}