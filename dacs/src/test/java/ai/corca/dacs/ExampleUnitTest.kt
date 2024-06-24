package ai.corca.dacs

import org.junit.Test

class ExampleUnitTest {

    @Test
    fun startDacs() {
        val dacsProvider = DacsProvider()
        dacsProvider.greet()
    }
}