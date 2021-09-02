package com.kotlin.kotlingithubbookmarks.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Repository (
    @PrimaryKey var id: Int = 0,
    var name: String? = null,
    var language: String? = null,
    @SerializedName("html_url") var htmlUrl: String? = null,
    var description: String? = null,
    @SerializedName("stargazers_count") var stars: Int? = null,
    @SerializedName("watchers_count") var watchers: Int? = null,
    var forks: Int? = null,
    var owner: Owner? = null
) : RealmObject()

/**

//doesn't have @SerializedName("language") because names are same ie var language
var language: String? = null

//Has @SerializedName("html_url") because names are different ie var htmlUrl
@SerializedName("html_url")
var htmlUrl: String? = null

 **/

open class Owner (var id:Int = 0, var login: String? = null) : RealmObject()

open class SearchResponse (
    @SerializedName("total_count")var totalCount: Int = 0,
    var items: RealmList<Repository>? = null
) : RealmObject()

data class ErrorResponse  ( val  message: String?)