package com.av.clientphonebookexample

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class BookViewActivity : AppCompatActivity() {
    lateinit var contactsListFragment: ContactsListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_view)

        //menu button:
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        menuButton.setImageResource(android.R.drawable.ic_dialog_dialer)

        //contacts list fragment:
        contactsListFragment =
            supportFragmentManager.findFragmentById(R.id.contacts_fragment) as ContactsListFragment
    }

    override fun onBackPressed() {
        //todo:
    }
}

