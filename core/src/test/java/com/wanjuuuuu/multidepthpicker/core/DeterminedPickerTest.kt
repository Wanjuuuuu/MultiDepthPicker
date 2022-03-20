package com.wanjuuuuu.multidepthpicker.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DeterminedPickerTest {

    @Test
    fun defaultDescriptionOfDeterminedPickerIsEmpty() {
        val picker = DeterminedPicker(1, "determined", nextPicker = IndeterminedPicker(2, ""))

        assertEquals("", picker.description)
    }

    @Test
    fun descriptionOfDeterminedPickerIsSet() {
        val picker = DeterminedPicker(
            1,
            "determined",
            "Next is determined",
            nextPicker = IndeterminedPicker(2, "")
        )

        assertEquals("Next is determined", picker.description)
    }

    @Test
    fun defaultOptionsOfDeterminedPickerIsEmptyList() {
        val picker = DeterminedPicker(
            1,
            "determined",
            "Next is determined",
            nextPicker = IndeterminedPicker(2, "")
        )

        assertTrue(picker.picks.isEmpty())
    }

    @Test
    fun optionsOfDeterminedPickerIsSet() {
        val pick = LeafPick(1, "pick")
        val picker = DeterminedPicker(
            2,
            "determined",
            "Next is determined",
            listOf(pick),
            IndeterminedPicker(3, "")
        )

        assertEquals(1, picker.picks.size)
        assertEquals(pick, picker.picks[0])
    }

    @Test
    fun nextOfDeterminedPickerIsAlwaysSameAsSet() {
        val pick1 = LeafPick(1, "pick1")
        val pick2 = ChainPick(2, "pick2", nextPicker = IndeterminedPicker(3, ""))
        val nextPickerOfPicker = IndeterminedPicker(4, "")
        val picker = DeterminedPicker(
            5,
            "determined",
            "Next is determined",
            listOf(pick1, pick2),
            nextPickerOfPicker
        )

        assertEquals(nextPickerOfPicker, picker.next())

        picker.pick(pick1)
        assertEquals(nextPickerOfPicker, picker.next())

        picker.pick(pick2)
        assertEquals(nextPickerOfPicker, picker.next())
    }
}