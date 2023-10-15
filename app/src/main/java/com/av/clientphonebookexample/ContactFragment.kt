package com.av.clientphonebookexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {
    private lateinit var _contact: Contact
    private lateinit var nameView: TextView
    private lateinit var callButton: ImageButton
    private lateinit var smsButton: ImageButton
    private lateinit var mailButton: ImageButton
    private lateinit var whatsappButton: ImageButton

    private lateinit var optionsPanel: View
    private var _optionsDisplayed: Boolean = false

    var contact: Contact
        get() = _contact
        set(value) {
            _contact = value

            //update view:
            if (::nameView.isInitialized) {
                refreshView()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val myView: View = inflater.inflate(R.layout.fragment_contact, container, false)
        myView.setOnClickListener {
            onContactClicked()
        }

        //contact name panel
        nameView = myView.findViewById(R.id.name_v)
        nameView.setOnClickListener {
            onContactClicked()
        }

        //options panel:
        optionsPanel = myView.findViewById(R.id.options_box)

        //call button:
        callButton = myView.findViewById(R.id.call_button)
        callButton.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${contact.mobilePhoneNumber}")
            startActivity(callIntent)
        }

        //sms button:
        smsButton = myView.findViewById(R.id.sms_button)
        smsButton.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_SENDTO)
            smsIntent.data = Uri.parse("sms:${contact.mobilePhoneNumber}")

            //todo: verify there is a sms app on the device.
            startActivity(smsIntent)
        }

        //mail button:
        mailButton = myView.findViewById(R.id.mail_button)
        mailButton.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${contact.mailAddress}")
            startActivity(emailIntent)
        }

        //whatsapp button:
        whatsappButton = myView.findViewById(R.id.whatsapp_button)
        whatsappButton.setOnClickListener{
            val uri = Uri.parse("smsto:${contact.mobilePhoneNumber}")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.setPackage("com.whatsapp")
            startActivity(intent)
        }

        return myView
    }

    fun onContactClicked() {
        if (optionsPanel.visibility == View.GONE) {
            showOptionsPanel()
            return
        }
        if (optionsPanel.visibility == View.VISIBLE) {
            hideOptionsPanel()
            return
        }
    }

    fun showOptionsPanel() {
        optionsPanel.visibility = View.VISIBLE
    }

    fun hideOptionsPanel() {
        optionsPanel.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshView()
    }

    private fun refreshView() {
        nameView.text = _contact.firstName + " " + _contact.lastName//todo: enable last name first,
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment ContactFragment.
         */
        @JvmStatic
        fun newInstance() = ContactFragment().apply { }
    }
}