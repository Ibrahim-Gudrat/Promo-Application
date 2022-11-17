package com.abrahamgudratli.promoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.* //with this extension we do not need to create variable and findViewById. Just take id from layout and use it

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview_message.setOnClickListener {
            onClickPreviewButton()
        }

        val jobTitles = arrayOf("Android Developer", "Android Engineer", "Mobile Developer", "Software Developer")
        val adapterSpinner = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, jobTitles)
        spinner_job_title.adapter = adapterSpinner


    }

    private fun onClickPreviewButton() {

        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_date.text.toString()
        )
        
        val previewIntent = Intent(this, PreviewActivity::class.java)
        previewIntent.putExtra("Message", message)
        startActivity(previewIntent)

    }

}