package tw.edu.pu.csim.tcyang.mole

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MoleViewModel : ViewModel() {

    private val _counter = MutableStateFlow(0L)

    val counter: StateFlow<Long> = _counter.asStateFlow()

    fun incrementCounter() {
        _counter.update { it + 1 }
    }
}