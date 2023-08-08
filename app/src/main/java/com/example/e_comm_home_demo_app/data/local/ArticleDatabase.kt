package com.example.e_comm_home_demo_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_comm_home_demo_app.data.model.Article
import com.example.e_comm_home_demo_app.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Article::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    class Callback @Inject constructor(
        private val database: Provider<ArticleDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}