package com.course.wizeline_criptomonedas.data.hilt

import android.content.Context
import androidx.room.Room
import com.course.wizeline_criptomonedas.data.database.BookDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val BOOK_DATABASE_NAME = "book_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        BookDatabase::class.java,
        BOOK_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideBookDao(db: BookDatabase) = db.getBookDao()
}
