package com.wanjuuuuu.multidepthpicker.core

class ChainPick(
    id: Int,
    displayName: String,
    description: String = "",
    private val nextPicker: Picker
) : Pick(id, displayName, description) {

    override fun next(): Picker = nextPicker
}