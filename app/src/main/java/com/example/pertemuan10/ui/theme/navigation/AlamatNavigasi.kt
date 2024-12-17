package com.example.pertemuan10.ui.theme.navigation

interface Alamatnavigasi {
    val route: String
}
// untuk menandai view
object DestinasiHome : Alamatnavigasi {
    override val route = "home"
}
object DestinasiDetail : Alamatnavigasi {
    override val route = "Detail"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"
}
object DestinasiUpdate : Alamatnavigasi{
    override val route = "update"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"


}