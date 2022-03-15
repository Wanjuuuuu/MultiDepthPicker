package com.wanjuuuuu.multidepthpicker.core

abstract class Picker(
    id: Int,
    displayName: String,
    description: String,
    options: List<Pick>
) : Pick(id, displayName, description) {

    private val _picks = options.toMutableList()
    val picks: List<Pick> = _picks

    fun addPicks(picks: List<Pick>) {
        _picks.addAll(picks)
    }

    fun addPick(pick: Pick) {
        _picks.add(pick)
    }

    fun category() = displayName
}