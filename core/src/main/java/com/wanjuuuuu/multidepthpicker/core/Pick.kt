package com.wanjuuuuu.multidepthpicker.core

abstract class Pick(val id: Int, val displayName: String, val description: String) {

    abstract fun next(): Picker?
}