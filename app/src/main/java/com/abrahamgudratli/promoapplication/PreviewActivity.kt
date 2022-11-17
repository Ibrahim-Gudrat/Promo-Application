package com.abrahamgudratli.promoapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setupSendMessageButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        messagePreviewText = """
                
                Hello my name is ${message.contactName}, I'm a ${message.jobDescription()}.
                
                I'm looking for internship opportunity. If there is one that you can offer
                 
                I can start ${message.startDate()}. Thanks in advance!
                                
                
                Best regards, ${message.displayName}
                
            """.trimIndent()

        text_view_message.text = messagePreviewText
    }

    private fun setupSendMessageButton() {
        send_message_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // This ensures only SMS apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}