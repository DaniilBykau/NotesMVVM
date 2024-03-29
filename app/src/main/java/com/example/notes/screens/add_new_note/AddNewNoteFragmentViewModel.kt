package com.example.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.databinding.FragmentAddNewNoteBinding
import com.example.notes.databinding.FragmentMainBinding
import com.example.notes.models.AppNote
import com.example.notes.utilits.REPOSITORY
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteFragmentViewModel (application: Application):AndroidViewModel(application){
    fun insert(note:AppNote, onSuccess:()->Unit)=
        viewModelScope.launch{
            REPOSITORY.insert(note){
                onSuccess()
            }
        }
}