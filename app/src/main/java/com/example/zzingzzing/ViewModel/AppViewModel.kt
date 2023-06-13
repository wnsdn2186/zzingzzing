package com.example.zzingzzing.ViewModel

import androidx.lifecycle.*
import com.example.zzingzzing.Entity.MessageInfo
import com.example.zzingzzing.Entity.TelInfo
import com.example.zzingzzing.Repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel(private val repository: AppRepository) : ViewModel() {
    val allMessage: LiveData<List<MessageInfo>> = repository.allMessage.asLiveData()
    val allTel: LiveData<List<TelInfo>> = repository.allTel.asLiveData()

    fun insertMessage(messageInfo: MessageInfo) = viewModelScope.launch {
        repository.insertMessage(messageInfo)
    }

    fun insertTel(telInfo: TelInfo) = viewModelScope.launch {
        repository.insertTel(telInfo)
    }
}

class AppViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}