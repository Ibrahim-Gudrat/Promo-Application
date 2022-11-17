package com.abrahamgudratli.promoapplication

import java.io.Serializable

data class Message(
    var contactName: String,
    var contactNumber: String,
    var displayName: String,
    var includeJunior: Boolean,
    var jobTitle: String?,
    var immediateStart: Boolean,
    var availableDate: String?
) : Serializable {

    fun jobDescription(): String {
        return if (includeJunior) "Junior $jobTitle"
        else "$jobTitle"
    }

    fun startDate(): String {
        return if (immediateStart) "immediately"
        else "from $availableDate"
    }

}