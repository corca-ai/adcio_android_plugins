package ai.corca.dacs

import org.junit.Test

class DacsProviderTest {

    @Test
    fun testGreet() {
        val provider = DacsProvider()
        val result = provider.greet()
        println("Result: $result")
    }
}
