package ai.corca.dacs

import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {

    private fun testGreet2(): String {
        val myClass = DacsProvider()
        var result = ""
        runTest {
            result = myClass.greet()
        }
        return result
    }

    @Test
    fun testGreet() {
        val myClass = CreateDacs()
        val response = testGreet2()
        val greeting = runTest { myClass.greet(response) }
        print(greeting)
    }
}