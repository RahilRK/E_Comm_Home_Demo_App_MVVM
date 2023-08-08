package com.example.e_comm_home_demo_app.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.e_comm_home_demo_app.data.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(article: Article) : Long

    @Query("select * from article_table")
    fun getSavedNews(): LiveData<List<Article>>
}