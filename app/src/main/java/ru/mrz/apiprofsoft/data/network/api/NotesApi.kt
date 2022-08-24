package ru.mrz.apiprofsoft.data.network.api

import ru.mrz.apiprofsoft.data.models.Note
import retrofit2.http.GET
import retrofit2.http.Path

interface NotesApi {

    @GET("todos/1")
    suspend fun getNote() : Note

    @GET("todos/{id}")
    suspend fun getNoteById(
        @Path("id") id: Int
    ) : Note

    @GET("todos")
    suspend fun getNotes() : List<Note>
}