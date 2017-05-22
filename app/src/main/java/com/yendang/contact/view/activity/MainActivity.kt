package com.yendang.contact.view.activity

import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.yendang.contact.R
import com.yendang.contact.schema.Contact
import com.yendang.contact.view.adapter.MainAdapter
import com.yendang.contact.view.adapter.MainAdapter.OnItemClickListener

class MainActivity : AppCompatActivity(), OnItemClickListener {


    private var rvContactList: RecyclerView? = null
    private var contactList: List<Contact>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContactList = findViewById(R.id.rvContact) as RecyclerView

        setUpAdapter()
    }


    private fun setUpAdapter() {
        val spacing = this.resources.getDimension(R.dimen.spacing).toInt()

        contactList = initData()

        rvContactList?.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
                super.getItemOffsets(outRect, view, parent, state)

                outRect?.let {
                    outRect.left = spacing
                    outRect.right = spacing
                    outRect.top = spacing
                }

            }
        })

        val layoutManager = LinearLayoutManager(this)
        rvContactList?.layoutManager = layoutManager


        val adapter = MainAdapter(contactList as ArrayList<Contact>, this, this)
        rvContactList?.adapter = adapter

    }

    private fun initData(): List<Contact> {

        val data = ArrayList<Contact>()

        data.add(Contact(R.drawable.midu, "Midu", "+841655089290"))
        data.add(Contact(R.drawable.thuychi, "Thuy Chi", "+841655123290"))
        data.add(Contact(R.drawable.mytam, "My Tam", "+841655087390"))
        data.add(Contact(R.drawable.bichphuog, "Bich Phuong", "+841623329290"))
        data.add(Contact(R.drawable.midu, "Midu", "+841655089290"))
        data.add(Contact(R.drawable.midu, "Midu", "+841655089290"))
        data.add(Contact(R.drawable.thuychi, "Thuy Chi", "+841655123290"))
        data.add(Contact(R.drawable.mytam, "My Tam", "+841655087390"))
        data.add(Contact(R.drawable.bichphuog, "Bich Phuong", "+841623329290"))
        data.add(Contact(R.drawable.bichphuog, "Bich Phuong", "+841623329290"))
        data.add(Contact(R.drawable.midu, "Midu", "+841655089290"))
        data.add(Contact(R.drawable.midu, "Midu", "+841655089290"))

        return data
    }

    override fun onItemClick(position: Int) {
        ContactDetailActivity.start(this@MainActivity, contactList?.get(position))

    }
}
