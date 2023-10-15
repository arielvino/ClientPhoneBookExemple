package com.av.clientphonebookexample

class TextBasedContactsLoader : IContactsLoader {
    override fun getContacts(): List<Contact> {
        val list: MutableList<Contact> = mutableListOf()
        val lines: List<String> = getDataRows()


        val data: MutableList<String> = MutableList(ContactFactory.NUMBER_OF_ATTRIBUTES) { "" }
        //each line is a Contact:
        for (line in lines) {
            var i = 0
            var lineCopy: String = line.toString()
            //each attribute of the Contact:
            while (lineCopy.indexOf("{") > -1) {
                val start: Int = lineCopy.indexOf("{")
                val end: Int = lineCopy.indexOf("}")
                val value: String = lineCopy.substring(start + 1, end)
                data[i] = value
                lineCopy = lineCopy.substring(end + 1)
                i++
            }
            list.add(Contact(data))
        }
        return list
    }

    override fun getDataRows(): List<String> {
        val string: String = FileLoader.readStringFromAssets(FileLoader.DATAFILE)
        return string.split("\n")
    }
}