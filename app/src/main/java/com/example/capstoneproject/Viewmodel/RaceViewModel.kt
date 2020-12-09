package com.example.capstoneproject.Viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Model.Data
import com.example.capstoneproject.Model.RaceResponse
import com.example.capstoneproject.Model.RaceTable
import com.example.capstoneproject.Model.RaceX
import com.example.capstoneproject.Repository.RaceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RaceViewModel(application: Application) : AndroidViewModel(application) {


    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val raceRepository: RaceRepository = RaceRepository()

    val races: LiveData<List<RaceX>> = raceRepository.races

    private val _errorText: MutableLiveData<String> = MutableLiveData()
    val errorText: LiveData<String> get() = _errorText

    fun getData() {
        mainScope.launch {
            try {
                raceRepository.getData()
            } catch (error: RaceRepository.RaceError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }





}