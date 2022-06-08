package com.example.demoproject.models

data class LoginApiResponse(
    val active: Boolean,
    val app_platform: String,
    val app_version: String,
    val can_update_progress: Boolean,
    val coach: Coach,
    val device_token: String,
    val email: String,
    val expansion_plans: List<Any>,
    val first_login: Boolean,
    val id: Int,
    val manager: Manager,
    val name: String,
    val office: Office,
    val plans: List<Plan>,
    val uid: String
)