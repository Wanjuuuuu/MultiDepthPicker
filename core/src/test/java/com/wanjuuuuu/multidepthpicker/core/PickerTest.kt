package com.wanjuuuuu.multidepthpicker.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class PickerTest {

    @Test
    fun idOfIndeterminedPickerIsSet() {
        val picker = object : Picker(1, "", "", listOf()) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        assertEquals(1, picker.id)
    }

    @Test
    fun displayNameOfIndeterminedPickerIsSetAndEqualsToCategory() {
        val picker = object : Picker(1, "picker", "", listOf()) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        assertEquals("picker", picker.displayName)
        assertEquals("picker", picker.category)
    }

    @Test
    fun descriptionOfIndeterminedPickerIsSet() {
        val picker = object : Picker(1, "picker", "Has abstract next method", listOf()) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        assertEquals("Has abstract next method", picker.description)
    }

    @Test
    fun optionsOfIndeterminedPickerIsSet() {
        val pick = LeafPick(1, "pick")
        val picker = object : Picker(2, "picker", "Has abstract next method", listOf(pick)) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        assertEquals(1, picker.picks.size)
        assertEquals(pick, picker.picks[0])
    }

    @Test
    fun optionsOfIndeterminedPickerIsAdded() {
        val pick1 = LeafPick(1, "pick1")
        val picker = object : Picker(2, "picker", "Has abstract next method", listOf(pick1)) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        val pick2 = LeafPick(3, "pick2")
        picker.addPick(pick2)

        val pick3 = LeafPick(4, "pick3")
        val pick4 = LeafPick(4, "pick4")
        picker.addPicks(listOf(pick2, pick3, pick4))

        assertEquals(5, picker.picks.size)
        assertEquals(pick1, picker.picks[0])
        assertEquals(pick2, picker.picks[1])
        assertEquals(pick2, picker.picks[2])
        assertEquals(pick3, picker.picks[3])
        assertEquals(pick4, picker.picks[4])
    }

    @Test
    fun pickedOfInterminedPickerWhichNotPickedYetIsNull() {
        val pick = LeafPick(1, "pick")
        val picker = object : Picker(2, "picker", "Has abstract next method", listOf(pick)) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        assertNull(picker.picked)
    }

    @Test(expected = IllegalArgumentException::class)
    fun pickedOfInterminedPickerWhichPickedWithInvalidIndex() {
        val pick = LeafPick(1, "pick")
        val picker = object : Picker(2, "picker", "Has abstract next method", listOf(pick)) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        picker.pick(1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun pickedOfInterminedPickerWhichPickedWithInvalidOption() {
        val pick = LeafPick(1, "pick")
        val picker = object : Picker(2, "picker", "Has abstract next method", listOf(pick)) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        val invalidPick = LeafPick(2, "invalid")
        picker.pick(invalidPick)
    }

    @Test
    fun pickedOfInterminedPickerWhichPickedIsNotNull() {
        val pick1 = LeafPick(1, "pick1")
        val pick2 = LeafPick(2, "pick2")
        val pick3 = LeafPick(3, "pick3")
        val picker = object : Picker(
            4, "picker", "Has abstract next method", listOf(
                pick1, pick2, pick3
            )
        ) {
            override fun next(): Picker? {
                TODO("next is the abstract method")
            }
        }

        picker.pick(2)
        assertEquals(pick3, picker.picked)

        picker.pick(pick1)
        assertEquals(pick1, picker.picked)
    }
}