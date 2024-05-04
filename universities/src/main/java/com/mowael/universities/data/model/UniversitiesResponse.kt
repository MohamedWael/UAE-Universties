package com.mowael.universities.data.model

import com.google.gson.annotations.SerializedName

class UniversitiesResponse : ArrayList<UniversityItem>()

data class UniversityItem(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("web_pages")
    val webPages: List<String>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("domains")
    val domains: List<String>? = null,

    @field:SerializedName("alpha_two_code")
    val alphaTwoCode: String? = null,

    @field:SerializedName("state-province")
    val stateProvince: String? = null
)


data class UniversityDto(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("web_pages")
    val webPages: List<String>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("domains")
    val domains: List<String>? = null,

    @field:SerializedName("alpha_two_code")
    val alphaTwoCode: String? = null,

    @field:SerializedName("state-province")
    val stateProvince: String? = null
)