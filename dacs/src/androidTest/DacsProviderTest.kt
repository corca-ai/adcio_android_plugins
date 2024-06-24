package ai.corca.dacs

import org.junit.Test
import kotlin.test.assertEquals

class DacsProviderTest {

    @Test
    fun testGreet() {
        val provider = DacsProvider()
        val result = provider.greet()
        println("Result: $result")
        assertEquals("Expected Greeting", result)
    }
}