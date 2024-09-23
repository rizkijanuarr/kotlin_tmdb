package udemy.lazday.kotlintmdb.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import udemy.lazday.kotlintmdb.R
import udemy.lazday.kotlintmdb.data.api.Network

class MainActivity : AppCompatActivity() {

    lateinit var btnNowPlaying: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListener()
    }

    private fun initViews() {
        btnNowPlaying = findViewById(R.id.btnFetchNowPlaying)
    }

    private fun setupListener() {
        btnNowPlaying.setOnClickListener {
            fetchNowPlayingMovies()
        }
    }

    private fun fetchNowPlayingMovies() {
        // lifecycleScope coroutine
        lifecycleScope.launch {
            try {
                val result = Network.getService(this@MainActivity).getNowPlaying(page = 1)

                Log.d("Debug", "pages: ${result.totalPages}")
                Log.d("Debug", "hasil: ${result.totalResults}")

                result.results.map {
                    Log.d("Debug", "title: ${it.title} - overview: ${it.overview}")
                    showMessage("did it!")
                }
            } catch (e: Exception) {
                Log.e("Error", "fail bro", e)
                showMessage("fail!")
            }
        }
    }

    private fun showMessage(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}
