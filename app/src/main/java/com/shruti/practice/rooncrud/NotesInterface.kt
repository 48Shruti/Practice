package com.shruti.practice.rooncrud

interface NotesInterface {
    fun updateNotes(notesdataclass: Notesdataclass,position:Int)
    fun deleteNotes(notesdataclass: Notesdataclass,position: Int)
}