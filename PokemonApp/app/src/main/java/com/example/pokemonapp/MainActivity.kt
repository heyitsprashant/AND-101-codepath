package com.example.pokemonapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var ivPokemon: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvExperience: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        etSearch = findViewById(R.id.etSearch)
        btnSearch = findViewById(R.id.btnSearch)
        ivPokemon = findViewById(R.id.ivPokemon)
        tvName = findViewById(R.id.tvName)
        tvExperience = findViewById(R.id.tvExperience)

        // Button click fetches data
        btnSearch.setOnClickListener {
            val query = etSearch.text.toString().trim().lowercase()
            if (query.isNotEmpty()) {
                fetchPokemonData(query)
            } else {
                Toast.makeText(this, "Please enter a Pokémon name or ID", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchPokemonData(query: String) {
        val client = AsyncHttpClient()
        val url = "https://pokeapi.co/api/v2/pokemon/$query"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                try {
                    val name = response.getString("name").replaceFirstChar { it.uppercase() }
                    val baseExp = response.getInt("base_experience")

                    // Get first ability name
                    val abilitiesArray = response.getJSONArray("abilities")
                    val firstAbility = abilitiesArray.getJSONObject(0)
                        .getJSONObject("ability")
                        .getString("name")
                        .replaceFirstChar { it.uppercase() }

                    // Get sprite image URL
                    val imageUrl = response
                        .getJSONObject("sprites")
                        .getString("front_default")

                    // Update UI
                    tvName.text = "Name: $name"
                    tvExperience.text = "Base XP: $baseExp\nAbility: $firstAbility"
                    Glide.with(this@MainActivity).load(imageUrl).into(ivPokemon)

                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Error parsing data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                Toast.makeText(this@MainActivity, "API call failed: $statusCode", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
