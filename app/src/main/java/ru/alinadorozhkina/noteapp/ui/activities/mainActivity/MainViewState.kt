package ru.alinadorozhkina.noteapp.ui.activities.mainActivity

import ru.alinadorozhkina.noteapp.data.model.Note

/*
представляет состояние view и служит для передачи данных из ViewModel во view
 */
class MainViewState(val notes: List<Note>)