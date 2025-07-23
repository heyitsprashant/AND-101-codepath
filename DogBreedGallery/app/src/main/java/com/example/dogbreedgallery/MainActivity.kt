package com.example.dogbreedgallery

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import androidx.appcompat.app.AppCompatDelegate
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DogAdapter
    private lateinit var searchView: SearchView
    private lateinit var toggleThemeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.dogRecyclerView)
        searchView = findViewById(R.id.searchView)
        toggleThemeButton = findViewById(R.id.toggleThemeButton)
        adapter = DogAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        fetchDogs()

        // Theme toggle logic
        toggleThemeButton.setOnClickListener {
            val currentMode = AppCompatDelegate.getDefaultNightMode()
            if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

        // Search logic
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { adapter.filter(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { adapter.filter(it) }
                return true
            }
        })
    }

    private fun fetchDogs() {
        val client = AsyncHttpClient()
        val url = "https://dog.ceo/api/breeds/image/random/50"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>?,
                response: JSONObject?
            ) {
                response?.let {
                    val imageArray = it.getJSONArray("message")
                    val dogs = mutableListOf<Dog>()
                    for (i in 0 until imageArray.length()) {
                        val imageUrl = imageArray.getString(i)
                        val breedName = extractBreedName(imageUrl)
                        dogs.add(Dog(imageUrl, breedName))
                    }
                    adapter.setDogs(dogs)
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun extractBreedName(imageUrl: String): String {
        val parts = imageUrl.split("/")
        return if (parts.size > 4) {
            parts[4].replace("-", " ").replaceFirstChar { it.uppercaseChar() }
        } else {
            "Unknown"
        }
    }
}
