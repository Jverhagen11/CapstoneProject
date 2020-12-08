package com.example.capstoneproject.Viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.Model.Race
import com.example.capstoneproject.Repository.RaceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RaceViewModel(application: Application) : AndroidViewModel(application) {

    private val raceRepository = RaceRepository()
    val race = raceRepository.race

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    fun getRace() {
        viewModelScope.launch {
            try {
                raceRepository.getRace()
            } catch (error: RaceRepository.RaceError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }
}