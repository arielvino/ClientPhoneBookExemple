package com.av.clientphonebookexample.ui.theme

import com.av.clientphonebookexample.MyApplication
import java.io.InputStream

class FileLoader {
    companion object {
        fun readStringFromAssets(fileName: String): String {
            val assetManager = MyApplication.applicationContext().assets
            val inputStream: InputStream = assetManager.open("data/$fileName")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer, Charsets.UTF_8)
        }

        const val DATAFILE: String = "data"
    }
}