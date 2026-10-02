package br.uepa.aplicativoteste1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform