package com.example.autocompleteview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var arrayAdapter:ArrayAdapter<String>
    // Initialize a new array with elements
    var colors= arrayOf("Red","Green","Blue","Maroon","Magenta",
        "Gold","GreenYellow")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize a new array adapter object
        arrayAdapter=ArrayAdapter<String>(
            this,android.R.layout.simple_dropdown_item_1line,colors)

// Set the AutoCompleteTextView adapter
        autoCompleteTextView.setAdapter( arrayAdapter)

        // Auto complete threshold
        // The minimum number of characters to type to show the drop down
        autoCompleteTextView.threshold = 1

        autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()
            // Display the clicked item using toast
            Toast.makeText(applicationContext,"Selected : $selectedItem",Toast.LENGTH_SHORT).show()
        }


// Set a dismiss listener for auto complete text view
      /* autoCompleteTextView.setOnDismissListener {
            Toast.makeText(applicationContext,"Suggestion closed.",Toast.LENGTH_SHORT).show()
        }*/


        // Set a click listener for root layout
      /*  root_layout.setOnClickListener{
            val text = autoCompleteTextView.text
            Toast.makeText(applicationContext,"Inputted : $text",Toast.LENGTH_SHORT).show()
        }*/


        // Set a focus change listener for auto complete text view
       autoCompleteTextView.onFocusChangeListener = View.OnFocusChangeListener{
                view, b ->
            if(b){
                // Display the suggestion dropdown on focus
                autoCompleteTextView.showDropDown()
            }
        }

    }}
