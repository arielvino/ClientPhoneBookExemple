package com.av.clientphonebookexample

class Contact(attrs: List<String>) {
    private var _firstName: String
    val firstName: String
        get() = _firstName

    private var _lastName: String
    val lastName: String
        get() = _lastName

    private var _phoneNumberAtHome: String
    val phoneNumberAtHome: String
        get() = _phoneNumberAtHome

    private var _mobilePhoneNumber: String
    val mobilePhoneNumber: String
        get() = _mobilePhoneNumber

    private var _mailAddress: String
    val mailAddress: String
        get() = _mailAddress

    private var _geographicalAddress: String
    val geographicalAddress: String
        get() = _geographicalAddress

    init {
        _firstName = attrs[ContactFactory.FIRST_NAME_INDEX]
        _lastName = attrs[ContactFactory.LAST_NAME_INDEX]
        _mailAddress = attrs[ContactFactory.MAIL_ADDRESS_INDEX]
        _geographicalAddress = attrs[ContactFactory.GEOGRAPHICAL_ADDRESS_INDEX]
        _mobilePhoneNumber = attrs[ContactFactory.MOBILE_PHONE_INDEX]
        _phoneNumberAtHome = attrs[ContactFactory.PHONE_AT_HOME_INDEX]
    }
}