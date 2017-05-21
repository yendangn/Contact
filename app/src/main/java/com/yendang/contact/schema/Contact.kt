package com.yendang.contact.schema

import java.io.Serializable

/**
 * Created by yendang on 5/21/17.
 */
class Contact : Serializable {

    var avatar: Int = 0
    var name: String? = null
    var phoneNumber: String? = null


    constructor(avatar: Int, name: String, phoneNumber: String) {

        this.avatar = avatar
        this.name = name
        this.phoneNumber = phoneNumber

    }

    constructor() {}

}
