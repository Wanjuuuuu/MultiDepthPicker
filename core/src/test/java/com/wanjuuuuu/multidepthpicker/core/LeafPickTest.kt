package com.wanjuuuuu.multidepthpicker.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LeafPickTest {

    @Test
    fun idOfLeafPickIsSet() {
        val pick = LeafPick(1, "")

        assertEquals(1, pick.id)
    }

    @Test
    fun displayNameOfLeafPickIsSet() {
        val pick = LeafPick(1, "leaf")

        assertEquals("leaf", pick.displayName)
    }

    @Test
    fun defaultDescriptionOfLeafPickIsEmpty() {
        val pick = LeafPick(1, "leaf")

        assertEquals("", pick.description)
    }

    @Test
    fun descriptionOfLeafPickIsSet() {
        val pick = LeafPick(1, "leaf", "Doesn't have next")

        assertEquals("Doesn't have next", pick.description)
    }

    @Test
    fun nextOfLeafPickIsAlwaysNull() {
        val pick = LeafPick(1, "leaf", "Doesn't have next")

        assertNull(pick.next())
    }
}