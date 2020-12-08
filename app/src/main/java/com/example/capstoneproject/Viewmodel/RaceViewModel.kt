package com.example.capstoneproject.Viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.Repository.RaceRepository
import kotlinx.coroutines.launch

class RaceViewModel(application: Application) : AndroidViewModel(application) {
    private val raceRepository = RaceRepository()

    /**
     * This property points direct to the LiveData in the repository, that value
     * get's updated when user clicks FAB. This happens through the refreshNumber() in this class :)
     */
    val trivia = raceRepository.race

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * errorText can be observed from Activity for error showing
     * Encapsulation :)
     */
    val errorText: LiveData<String>
        get() = _errorText

    /**
     * The viewModelScope is bound to Dispatchers.Main and will automatically be cancelled when the ViewModel is cleared.
     * Extension method of lifecycle-viewmodel-ktx library
     */
    fun getRace() {
        viewModelScope.launch {
            try {
                //the triviaRepository sets it's own livedata property
                //our own trivia property points to this one
                raceRepository.getRace()
            } catch (error: RaceRepository.TriviaRefreshError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }
}