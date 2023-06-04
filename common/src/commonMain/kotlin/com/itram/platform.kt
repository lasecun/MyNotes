package com.itram

fun getAppTitle() = "My Notes - ${getPlatformName()}"

expect fun getPlatformName(): String