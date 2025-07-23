package com.example.dogbreedgallery

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    // Mapping of properly formatted breed names to descriptions
    private val breedDescriptions = mapOf(
        "Border Collie" to "Border Collies are energetic, intelligent herding dogs with a strong work ethic.",
        "Italian Segugio" to "A sleek hunting hound known for its agility and endurance.",
        "Bedlington Terrier" to "Curly-coated terriers known for their lamb-like appearance and tenacity.",
        "Toy Poodle" to "Small and smart, Toy Poodles are affectionate and easy to train.",
        "Maltese" to "Maltese dogs are gentle lap dogs with long flowing coats.",
        "Norwegian Elkhound" to "A strong, loyal hunting dog from Norway with a wolf-like appearance.",
        "Cairn Terrier" to "Alert and cheerful, Cairn Terriers are fearless and lively.",
        "Boston Bulldog" to "Boston Bulldogs are muscular and compact, great companions for families.",
        "Tibetan Terrier" to "Known for their unique foot structure and long hair, these are adaptable and loving dogs.",
        "Rhodesian Ridgeback" to "African breed known for its ridge of hair and lion-hunting history.",
        "Miniature Pinscher" to "A small, fearless dog known as the 'King of Toys'.",
        "Tibetan Mastiff" to "Massive and powerful, Tibetan Mastiffs are protective and independent.",
        "Soft Coated Wheaten Terrier" to "Friendly and spirited, known for their silky soft coat.",
        "Welsh Terrier" to "Bold and friendly terriers originally bred for hunting.",
        "Entlebucher" to "Swiss herding dog, agile and loyal.",
        "German Shepherd" to "Courageous, confident, and smart—ideal for work and service.",
        "Dingo" to "Wild dogs of Australia, not usually kept as pets.",
        "Silky Terrier" to "A small Australian breed with silky coat and big personality.",
        "Akita" to "Powerful Japanese dogs known for their loyalty.",
        "Indian Spitz" to "Fluffy and playful, often confused with the Pomeranian.",
        "Shiba Inu" to "Japan's fox-like, independent breed with bold spirit.",
        "Vizsla" to "Hungarian hunting dog, affectionate and athletic.",
        "Xoloitzcuintli" to "Ancient Mexican hairless dog, loyal and alert.",
        "Irish Setter" to "Elegant and friendly with a silky red coat.",
        "Beagle" to "Curious and merry scent hounds, great with kids.",
        "Pomeranian" to "Tiny, vocal puffballs with big personalities.",
        "Pitbull" to "Strong, loyal dogs—often misunderstood due to their strength.",
        "Flat-Coated Retriever" to "Happy, confident retrievers with long coats.",
        "Miniature Poodle" to "Highly intelligent, trainable, and hypoallergenic.",
        "Irish Wolfhound" to "One of the tallest breeds, gentle giants.",
        "Briard" to "French sheepdogs, loyal and protective with flowing coats."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById<ImageView>(R.id.detailImageView)
        val textView = findViewById<TextView>(R.id.detailTextView)

        val imageUrl = intent.getStringExtra("imageUrl") ?: ""
        val rawBreedName = intent.getStringExtra("breedName") ?: "Unknown"

        // Format breed name to match map keys
        val formattedBreed = formatBreedName(rawBreedName)

        // Show Toast for debugging
        Toast.makeText(this, "Breed: $formattedBreed", Toast.LENGTH_SHORT).show()
        Log.d("DetailActivity", "Breed formatted = $formattedBreed")

        // Lookup description
        val description = breedDescriptions[formattedBreed] ?: "Description not available."

        // Show image and description
        Glide.with(this).load(imageUrl).into(imageView)
        textView.text = "$formattedBreed\n\n$description"
    }

    private fun formatBreedName(raw: String): String {
        val parts = raw.split("-")
        return if (parts.size > 1) {
            parts.reversed().joinToString(" ") { it.replaceFirstChar { c -> c.uppercaseChar() } }
        } else {
            raw.replaceFirstChar { it.uppercaseChar() }
        }
    }
}
