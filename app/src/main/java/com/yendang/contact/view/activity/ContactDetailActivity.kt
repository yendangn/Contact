package com.yendang.contact.view.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.yendang.contact.R
import com.yendang.contact.schema.Contact

class ContactDetailActivity : AppCompatActivity() {

    var imgProfile: ImageView? = null
    var tvName: TextView? = null
    var tvPhone: TextView? = null

    var contact: Contact? = null


    companion object {

        private val CONTACT_DATA = "CONTACT_DATA"

        fun start(context: Context, contact: Contact?) {
            val intent = Intent(context, ContactDetailActivity::class.java)
            intent.putExtra(CONTACT_DATA, contact)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        contact = intent.getSerializableExtra(CONTACT_DATA) as Contact

        imgProfile = findViewById(R.id.imgProfile) as ImageView
        tvName = findViewById(R.id.tvName) as TextView
        tvPhone = findViewById(R.id.tvPhone) as TextView



        showData()
    }

    private fun showData() {

        imgProfile?.setImageResource(contact?.avatar as Int)
        tvName?.text = contact?.name
        tvPhone?.text = contact?.phoneNumber
    }

}
