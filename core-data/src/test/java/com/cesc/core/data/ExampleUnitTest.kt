package com.cesc.core.data

import com.cesc.core.data.repository.HomeBannerRepository
import com.cesc.core.data.repository.HomeTopArticleRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.koin.ksp.generated.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class ExampleUnitTest : KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(
            DataDIModule().module
        )
    }

    @Test
    fun `fetch banner data`() = runTest {
        val bannerRepository = get<HomeBannerRepository>()
        val result = bannerRepository()
        println(result)
        assertEquals(false, result.isEmpty())
    }

    @Test
    fun `fetch home top articles`() = runTest {
        val topArticles = get<HomeTopArticleRepository>()
        val result = topArticles()
        println(result)
        assertEquals(false, result.isEmpty())
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

}