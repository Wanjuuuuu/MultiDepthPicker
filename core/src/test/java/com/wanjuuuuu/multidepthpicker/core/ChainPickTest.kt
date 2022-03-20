package com.wanjuuuuu.multidepthpicker.core

import org.junit.Assert.assertEquals
import org.junit.Test

class ChainPickTest {

    @Test
    fun idOfChainPickIsSet() {
        val pick = ChainPick(1, "", nextPicker = IndeterminedPicker(1, ""))

        assertEquals(1, pick.id)
    }

    @Test
    fun displayNameOfChainPickIsSet() {
        val pick = ChainPick(1, "chain", nextPicker = IndeterminedPicker(1, ""))

        assertEquals("chain", pick.displayName)
    }

    @Test
    fun defaultDescriptionOfChainPickIsEmpty() {
        val pick = ChainPick(1, "chain", nextPicker = IndeterminedPicker(1, ""))

        assertEquals("", pick.description)
    }

    @Test
    fun descriptionOfChainPickIsSet() {
        val pick = ChainPick(1, "chain", "Has next", IndeterminedPicker(1, ""))

        assertEquals("Has next", pick.description)
    }

    @Test
    fun nextOfChainPickIsSet() {
        val picker = IndeterminedPicker(1, "")
        val pick = ChainPick(1, "chain", "Has next", picker)

        assertEquals(picker, pick.next())
    }
}