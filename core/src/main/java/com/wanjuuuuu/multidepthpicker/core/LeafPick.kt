package com.wanjuuuuu.multidepthpicker.core

class LeafPick(
    id: Int,
    displayName: String,
    description: String = "",
) : Pick(id, displayName, description) {

    override fun next(): Picker? = null
}