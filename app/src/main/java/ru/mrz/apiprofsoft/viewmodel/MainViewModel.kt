package ru.mrz.apiprofsoft.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.flow
import ru.mrz.apiprofsoft.data.network.ApiClient

class MainViewModel : ViewModel() {
    private val api = ApiClient.retrofitService()

    fun getNote() = flow {
        emit(api.getNotes())
    }
}