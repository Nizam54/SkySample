package cs.nizam.skysample

import com.google.gson.annotations.SerializedName


data class Ratings(

    @SerializedName("Value") var value: String? = null,
    @SerializedName("Source") var source: String? = null

)