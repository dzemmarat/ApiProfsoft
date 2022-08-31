package ru.mrz.apiprofsoft.data.models

data class RegisterBody(
    val email: String = "use4",
    val login: String = "Test",
    val name: String = "name",
    val password: String = "t",
)