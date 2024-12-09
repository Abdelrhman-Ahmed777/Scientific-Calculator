package com.example.scientificcalculator.presention.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scientificcalculator.domain.Item
import com.example.scientificcalculator.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DataBaseViewModel(private val repository: Repository) : ViewModel() {

   fun getAllItems(): Flow<List<Item>> =
            repository.getAll().stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun insertItem(item: Item) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insert(item)
            }
        }
    }

}
