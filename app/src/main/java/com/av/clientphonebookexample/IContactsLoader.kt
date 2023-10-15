package com.av.clientphonebookexample

interface IContactsLoader {
    fun getContacts(): List<Contact>
    fun getDataRows(): List<String>
}