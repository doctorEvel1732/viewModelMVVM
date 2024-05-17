package com.example.countermvvm
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countermvvm.ui.theme.CounterMVVMTheme
import androidx.lifecycle.ViewModel


class CounterViewModel(): ViewModel() {

    private val _repository: CounterRepository = CounterRepository()

    private val _count = mutableStateOf(_repository.getCounter().count)
    //Expose the count as an immutable state
    val count: MutableState<Int> = _count

    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }


}