package mx.delasalle.introviewmodel

import androidx.collection.mutableIntSetOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel(){
    var counter = mutableIntStateOf(0)
        private set

    fun increment(){
        counter.intValue += 1
    }
}
