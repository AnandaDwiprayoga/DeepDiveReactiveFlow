package com.pasukanlangit.id.deepdiveflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    init {
        observeCountDownChange()
    }

    val countDown = flow {
        val initialValue = 10
        var startCountDownValue = initialValue

        while(startCountDownValue >= 0){
            emit(startCountDownValue)
            startCountDownValue--
            delay(1000L)
        }
    }

    private fun observeCountDownChange(){
        viewModelScope.launch {
            //for some reasons need to delay before observing, waiting flow initialized first
            delay(50L)
            //collect will wait current operation in block scope finish event though new value emitted
//            countDown.collect { count ->
//                delay(1200L)
//                println("Current value count: $count")
//            }

            //collect will cancel current operation in block scope when new value emitted
            countDown.collectLatest { count ->
                delay(1200L)
                println("Current value count: $count")
            }
        }
    }

}