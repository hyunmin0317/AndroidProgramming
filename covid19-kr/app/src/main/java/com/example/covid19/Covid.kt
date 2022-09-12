package com.example.covid19

import java.io.Serializable

class Covid(
    val date: String,
    val confirmed: String,
    val death: String,
    val today_confirmed: String,
    val today_death: String,
): Serializable