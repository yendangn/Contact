package com.yendang.contact.schema

import java.io.Serializable

/**
 * Created by yendang on 5/21/17.
 */

class ContactJava : Serializable{

    var name: String? = null

    constructor() {}

    constructor(name: String) {
        this.name = name

    }
}
