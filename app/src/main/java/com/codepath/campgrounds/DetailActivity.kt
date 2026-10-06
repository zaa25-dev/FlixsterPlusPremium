package com.codepath.campgrounds

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "CampgroundDetailActivity"
const val CAMPGROUND_EXTRA = "CAMPGROUND_EXTRA"

class DetailActivity : AppCompatActivity() {
    private lateinit var campgroundNameTV: TextView
    private lateinit var campgroundDescriptionTV: TextView
    private lateinit var campgroundLatLongTV: TextView
    private lateinit var campgroundImageIV: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        campgroundNameTV = findViewById(R.id.campgroundName)
        campgroundDescriptionTV = findViewById(R.id.campgroundDescription)
        campgroundLatLongTV = findViewById(R.id.campgroundLocation)
        campgroundImageIV = findViewById(R.id.campgroundImage)

        @Suppress("DEPRECATION")
        val campground = intent.getSerializableExtra(CAMPGROUND_EXTRA) as? Campground

        campground?.let {
            campgroundNameTV.text = it.name
            campgroundDescriptionTV.text = it.description
            campgroundLatLongTV.text = "Rating: ${it.voteAverage ?: 0.0} / 10\n" + "Votes: ${it.voteCount ?: 0}\n" + "Release Date: ${it.latLong ?: "N/A"}"

            // Loads the wide backdrop banner instead of reusing the main screen poster
            Glide.with(this)
                .load(it.backdropUrl)
                .into(campgroundImageIV)
        }
    }
}