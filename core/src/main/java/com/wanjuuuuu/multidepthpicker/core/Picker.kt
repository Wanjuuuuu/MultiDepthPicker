package com.wanjuuuuu.multidepthpicker.core

import kotlin.IllegalArgumentException

abstract class Picker(
    id: Int,
    displayName: String,
    description: String,
    options: List<Pick>
) : Pick(id, displayName, description) {

    val category
        get() = displayName

    private val _picks = options.toMutableList()
    val picks: List<Pick> = _picks

    var picked: Pick? = null
        private set

    fun pick(index: Int) {
        if (index >= _picks.size) {
            throw IllegalArgumentException("index is more than size of options")
        }
        picked = _picks[index]
    }

    fun pick(option: Pick) {
        if (!_picks.contains(option)) {
            throw IllegalArgumentException("options don't contain same option")
        }
        picked = option
    }

    fun addPicks(picks: List<Pick>) {
        _picks.addAll(picks)
    }

    fun addPick(pick: Pick) {
        _picks.add(pick)
    }
}