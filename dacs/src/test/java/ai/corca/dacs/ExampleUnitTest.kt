package ai.corca.dacs

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testGreet() {
        val myClass = Dacs()
        val greeting = myClass.greet("World")
        assertEquals("Hello, World!", greeting)
    }
}