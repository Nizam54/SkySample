package cs.nizam.skysample.data.model

import com.google.gson.annotations.SerializedName
import cs.nizam.skysample.Ratings

data class Movie(

    @SerializedName("DVD") var dvd: String? = null,
    @SerializedName("Plot") var plot: String? = null,
    @SerializedName("Type") var type: String? = null,
    @SerializedName("Year") var year: Int? = null,
    @SerializedName("Genre") var genre: String? = null,
    @SerializedName("Rated") var rated: String? = null,
    @SerializedName("Title") var title: String? = null,
    @SerializedName("Actors") var actors: String? = null,
    @SerializedName("Awards") var awards: String? = null,
    @SerializedName("Poster") var poster: String? = null,
    @SerializedName("Writer") var writer: String? = null,
    @SerializedName("imdbID") var imdbId: String? = null,
    @SerializedName("Country") var country: String? = null,
    @SerializedName("Ratings") var ratings: ArrayList<Ratings> = arrayListOf(),
    @SerializedName("Runtime") var runtime: String? = null,
    @SerializedName("Director") var director: String? = null,
    @SerializedName("Language") var language: String? = null,
    @SerializedName("Released") var released: String? = null,
    @SerializedName("Response") var response: String? = null,
    @SerializedName("BoxOffice") var boxOffice: String? = null,
    @SerializedName("Metascore") var metascore: Int? = null,
    @SerializedName("imdbVotes") var imdbVotes: String? = null,
    @SerializedName("Production") var production: String? = null,
    @SerializedName("imdbRating") var imdbRating: Double? = null

)
