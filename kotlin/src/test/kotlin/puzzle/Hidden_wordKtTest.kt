package puzzle

import org.junit.Assert.assertEquals
import org.junit.Test

class Hidden_wordKtTest {

    private fun arrayFromString(s: String) = s.trimIndent().lines().map { it.toCharArray() }.toTypedArray()

    @Test
    fun shouldLoopRight() {
        val str = """
            BAC
            BOB
            RED
        """
        val words = setOf("BOB", "BAC")
        assertEquals("RED", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopVertically() {
        val str = """
            GTRI
            LMAL
            UAGO
            ECML
        """.trimIndent()
        val words = setOf("GLUE", "LOL", "RAG", "MAC")
        assertEquals("TIM", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopLeft() {
        val str = """
            CAB
            BOB
            RED
        """.trimIndent()
        val words = setOf("BOB", "BAC")
        assertEquals("RED", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopTOPAndBottom() {
        val str = """
            CAB
            ARO
            BOB
        """.trimIndent()
        val words = setOf("BOB", "BAC")
        assertEquals("R", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopBottomRight() {
        val str = """
            BAD
            OAO
            EOC
        """.trimIndent()
        val words = setOf("BOB", "BAC")
        assertEquals("ADOOEO", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopBottomLeft() {
        val str = """
            EAB
            QAO
            COC
        """.trimIndent()
        val words = setOf("BOB", "BAC")
        assertEquals("EAQOOC", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopTopLeft() {
        val str = """
            CAE
            FAG
            HOB
        """.trimIndent()
        val words = setOf("BOB", "BAC")
        assertEquals("AEFGHO", findWord(arrayFromString(str), words))
    }

    @Test
    fun shouldLoopTopRight() {
        val str = """
            DAC
            FAG
            BOZ
        """.trimIndent()
        val words = setOf("BOB", "BAC")
        assertEquals("DAFGOZ", findWord(arrayFromString(str), words))
    }


}