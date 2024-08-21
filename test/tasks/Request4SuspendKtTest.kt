package tasks

import contributors.MockGithubService
import contributors.expectedResults
import contributors.testRequestData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class Request4SuspendKtTest {
    @Test
    fun testSuspend() = runTest {
        val startTime = System.currentTimeMillis()
        val result = loadContributorsSuspend(MockGithubService, testRequestData)
        Assert.assertEquals("Wrong result for 'loadContributorsSuspend'", expectedResults.users, result)
        val totalTime = System.currentTimeMillis() - startTime
        Assert.assertEquals(
            "The calls run consequently," +
                    "so the total virtual time should be 4000 ms: ",
            expectedResults.timeFromStart, totalTime
        )
    }
}