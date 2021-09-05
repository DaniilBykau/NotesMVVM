package com.example.notes.database

import androidx.lifecycle.LiveData
import com.example.notes.models.AppNote
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnSuccess

interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note:AppNote, onSuccess: ()->Unit)
    suspend fun delete(note:AppNote, onSuccess: ()->Unit)

}