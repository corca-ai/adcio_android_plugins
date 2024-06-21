package ai.corca.adcio_placement.network.data.response

import com.google.gson.annotations.SerializedName

data class RemoteMetaData(
    @SerializedName("isBaseline") val isBaseline: Boolean,
)