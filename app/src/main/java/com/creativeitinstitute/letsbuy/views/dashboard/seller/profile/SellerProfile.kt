package com.creativeitinstitute.letsbuy.views.dashboard.seller.profile

data class SellerProfile(
    val name:String="",
    val email:String="",
    val password:String="",
    val userType:String="",
    val userID:String="",
    var userImage:String="",
    val shopName:String=""
)

fun SellerProfile.toMap(): Map<String, Any>{
    return mapOf(
        "name" to name,
        "email" to email,
        "password" to password,
        "userType" to userType,
        "userID" to userID,
        "userImage" to userImage,
        "shopName" to shopName
    )
}