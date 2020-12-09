package com.example.capstoneproject.Viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.Model.RaceResponse
import com.example.capstoneproject.Repository.RaceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RaceViewModel(application: Application) : AndroidViewModel(application) {


    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val raceRepository: RaceRepository = RaceRepository()

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val races: LiveData<List<RaceResponse.Races>> = raceRepository.races
    val errorText: LiveData<String> get() = _errorText

    fun getRace() {
        mainScope.launch {
            try {
                raceRepository.getRace()
            } catch (error: RaceRepository.RaceError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }

    fun getMRData() {
        mainScope.launch {
            try {
                raceRepository.getMRData()
            } catch (error: RaceRepository.RaceError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }
}