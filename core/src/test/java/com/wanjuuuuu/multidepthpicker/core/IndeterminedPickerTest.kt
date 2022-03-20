package com.wanjuuuuu.multidepthpicker.core

import org.junit.Assert.*
import org.junit.Test

class IndeterminedPickerTest {

    @Test
    fun defaultDescriptionOfIndeterminedPickerIsEmpty() {
        val picker = IndeterminedPicker(1, "indetermined")

        assertEquals("", picker.description)
    }

    @Test
    fun descriptionOfIndeterminedPickerIsSet() {
        val picker = IndeterminedPicker(1, "indetermined", "Next depends what picked")

        assertEquals("Next depends what picked", picker.description)
    }

    @Test
    fun defaultOptionsOfIndeterminedPickerIsEmptyList() {
        val picker = IndeterminedPicker(1, "indetermined", "Next depends what picked")

        assertTrue(picker.picks.isEmpty())
    }

    @Test
    fun optionsOfIndeterminedPickerIsSet() {
        val pick = LeafPick(1, "pick")
        val picker = IndeterminedPicker(2, "indetermined", "Next depends what picked", listOf(pick))

        assertEquals(1, picker.picks.size)
        assertEquals(pick, picker.picks[0])
    }

    @Test
    fun nextOfIndeterminedPickerIsNullIfNotPicked() {
        val pick = LeafPick(1, "pick")
        val picker = IndeterminedPicker(2, "indetermined", "Next depends what picked", listOf(pick))

        assertNull(picker.next())
    }

    @Test
    fun nextOfIndeterminedPickerIsNullIfLeafPicked() {
        val pick1 = LeafPick(1, "pick1")
        val pick2 = ChainPick(2, "pick2", nextPicker = IndeterminedPicker(3, ""))
        val picker = IndeterminedPicker(
            4, "indetermined", "Next depends what picked", listOf(pick1, pick2)
        )

        picker.pick(pick1)

        assertNull(picker.next())
    }

    @Test
    fun nextOfIndeterminedPickerExistsIfNotLeafPicked() {
        val pick1 = LeafPick(1, "pick1")
        val pickerOfPick2 = IndeterminedPicker(3, "")
        val pick2 = ChainPick(2, "pick2", nextPicker = pickerOfPick2)
        val picker = IndeterminedPicker(
            4, "indetermined", "Next depends what picked", listOf(pick1, pick2)
        )

        picker.pick(pick2)

        assertEquals(pickerOfPick2, picker.next())
    }
}
