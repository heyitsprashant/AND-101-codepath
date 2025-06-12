package com.driuft.androidhunt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Contact Me button logic
        val contactButton = findViewById<Button>(R.id.contactButton)
        contactButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:prashant@example.com") // ← change to your actual email
                putExtra(Intent.EXTRA_SUBJECT, "Hi from your profile card!")
            }
            // Only launch if an email app is available
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
