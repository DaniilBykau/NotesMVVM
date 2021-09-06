package com.example.notes.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.database.DatabaseRepository
import com.example.notes.models.AppNote
import com.example.notes.utilits.EMAIL
import com.example.notes.utilits.PASSWORD
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class AppFirebaseRepository:DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnCanceledListener { onFail(it.toString()) }
            }

    }

    override fun signOut() {
        mAuth.signOut()
    }
}