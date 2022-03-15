package com.wanjuuuuu.multidepthpicker.core

class DeterminedPicker(
    id: Int,
    displayName: String,
    description: String = "",
    options: List<Pick> = listOf(),
    private val nextPicker: Picker
) : Picker(id, displayName, description, options) {

    override fun next(): Picker = nextPicker
}