package com.wanjuuuuu.multidepthpicker.core

class IndeterminedPicker(
    id: Int,
    displayName: String,
    description: String = "",
    options: List<Pick> = listOf()
) : Picker(id, displayName, description, options) {

    override fun next(): Picker? = null
}