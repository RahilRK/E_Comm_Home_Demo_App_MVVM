package com.example.e_comm_home_demo_app.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_comm_home_demo_app.R
import com.example.e_comm_home_demo_app.data.model.Article
import com.example.e_comm_home_demo_app.data.model.MyData
import com.example.e_comm_home_demo_app.repository.MainRepository
import com.example.e_comm_home_demo_app.util.ReponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: MainRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val mHomeScreenData: MutableLiveData<ReponseHandler<MyData>> = MutableLiveData()
    var mHomeScreenResponse: MyData? = null

    val mNewsData: MutableLiveData<Article> = MutableLiveData()

    init {
        getHomeScreenData()
    }

    private fun getHomeScreenData() = viewModelScope.launch {
        safeHomeScreenCall()
    }

    private suspend fun safeHomeScreenCall(){
        mHomeScreenData.postValue(ReponseHandler.Loading())
        try{
            val response = repository.getHomeScreenData()
            mHomeScreenData.postValue(handleBreakingNewsResponse(response))
        }
        catch (ex : Exception){
            when(ex){
                is IOException -> mHomeScreenData.postValue(ReponseHandler.Error(context.getString(R.string.network_error_msg)))
                else -> mHomeScreenData.postValue(ReponseHandler.Error(context.getString(R.string.something_went_wrong_msg)))
            }
        }
    }

    private fun handleBreakingNewsResponse(response: Response<MyData>): ReponseHandler<MyData> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return ReponseHandler.Success(mHomeScreenResponse ?: resultResponse)
            }
        }
        return ReponseHandler.Error(response.message())
    }

    fun saveNews() {
        viewModelScope.launch {
            mNewsData.value?.let { repository.saveNews(it) }
        }
    }
}