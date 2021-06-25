package ru.alinadorozhkina.noteapp.ui.activities.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.alinadorozhkina.noteapp.R
import ru.alinadorozhkina.noteapp.databinding.ActivityMainBinding
import ru.alinadorozhkina.noteapp.ui.activities.mainActivity.adapter.MainNotesAdapter

class MainActivity : AppCompatActivity() {

    private var ui: ActivityMainBinding? = null
    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainNotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui?.root)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter = MainNotesAdapter()
        ui?.mainRecycler?.adapter = adapter

        viewModel.viewState().observe(this, Observer<MainViewState> { t ->
            t?.let { adapter.notes = it.notes}
        })
    }
}