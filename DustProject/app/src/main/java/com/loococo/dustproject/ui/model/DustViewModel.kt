package com.loococo.dustproject.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loococo.dustproject.data.model.DustItem
import com.loococo.dustproject.data.rest.dust.DustRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class DustViewModel(private val dustRepository: DustRepository) : ViewModel() {

    val dust = MutableLiveData<DustItem>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    //코루틴 내부에서 오류가 발생 시 처리하는 부분 (따로 오류 처리는 안함)
    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        error.value = true
    }

    //launch는 코루틴을 만들고 함수 본문의 실행, 새로운 코루틴을 생성하여 다른 코루틴들과 동시에 함께 동작
    //launch 는 Job 객체를 반환하는 반면 async 는 Deferred
    fun dust(param: HashMap<String, String>) = viewModelScope.launch(exceptionHandler) {
        loading.value = true
        val responseData = dustRepository.getDustService(param)
        loading.value = false
        dust.value = responseData.response?.dustBody?.dustItem?.firstOrNull()
    }
}