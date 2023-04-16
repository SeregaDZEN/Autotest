import org.junit.Test
import kotlin.test.assertEquals


class TransferTest {


    @Test
    fun testMasterCardFree() {
        val type = "MasterCard"
        val transfer = 500
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(0, result)

    }

    @Test
    fun testMasterCardDayLimit() {
        val type = "MasterCard"
        val transfer = 200_000
        val previous = 500000

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(-1, result)

    }

    @Test
    fun testCardChange() {
        val type = "VK Pay"
        val transfer = 200_000
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(-1, result)

    }

    @Test
    fun testCardChangeTwo() {
        val type = "Любая другая карта"
        val transfer = 0
        val previous = 100_000

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(35, result)

    }

    @Test
    fun testMasterCardMonth() {
        val type = "Любая другая карта"
        val transfer = 100_000
        val previous = 700_000

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(-1, result)

    }
    @Test
    fun testElse() {
        val type = "VK Pay"
        val transfer = 20_000
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(-1, result)

    }
    @Test
    fun testCardChangeVK() {
        val type = "VK Pay"
        val transfer = 10
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(0, result)

    }
    @Test
    fun testCardBefore() {
        val type = "Maestro"
        val transfer = 290
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(21, result)

    }
    @Test
    fun testCardAgo() {
        val type = "Maestro"
        val transfer = 75100
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(470, result)

    }
    @Test
    fun testCard() {
        val type = "Любая другая карта"
        val transfer = 160_000
        val previous = 0

        val result = commission(typeCard = type, sumTransfer = transfer, maxSumTransfer = previous)

        assertEquals(-1, result)

    }


}
