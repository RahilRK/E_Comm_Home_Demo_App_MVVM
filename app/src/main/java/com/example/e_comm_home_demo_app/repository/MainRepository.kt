package com.example.e_comm_home_demo_app.repository

import com.example.e_comm_home_demo_app.data.local.ArticleDao
import com.example.e_comm_home_demo_app.data.model.Article
import com.example.e_comm_home_demo_app.data.model.MyData
import com.example.e_comm_home_demo_app.data.remote.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val articleDao: ArticleDao
) {

    suspend fun getHomeScreenData(): Response<MyData> {
        return apiInterface.getHomeScreenData()
    }

    suspend fun saveNews(article: Article): Long {

        return articleDao.saveNews(article)
    }
}