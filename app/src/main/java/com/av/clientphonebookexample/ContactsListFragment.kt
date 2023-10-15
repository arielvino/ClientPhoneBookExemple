package com.av.clientphonebookexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [ContactsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactsListFragment : Fragment() {

    lateinit var contactsHolder: LinearLayout
    val contactsLoader = TextBasedContactsLoader()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_contacts_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactsHolder = view.findViewById(R.id.contacts_holder)
        loadContacts(contactsLoader)
    }

    private fun addContact(contact: Contact) {
        val contactFragment: ContactFragment = ContactFragment.newInstance()

        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.contacts_holder, contactFragment)
        transaction.commit()
        contactFragment.contact = contact

    }

    private fun loadContacts(loader: IContactsLoader) {
        val list: List<Contact> = loader.getContacts()
        for(contact in list){
            addContact(contact)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ContactsListFragment.
         */
        @JvmStatic
        fun newInstance() = ContactsListFragment()
    }
}