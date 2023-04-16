
fun main() {

    println(commission( typeCard = "MasterCard", sumTransfer = 200_000))
}


    fun commission(typeCard: String = "VK Pay", sumTransfer: Int, maxSumTransfer: Int = 0): Int {
        return when (typeCard) {
            "VK Pay" ->
                if (sumTransfer > 15_000 || sumTransfer + maxSumTransfer > 40_000) -1
                else 0

            "MasterCard", "Maestro" ->
                if (sumTransfer > 150_000 || sumTransfer + maxSumTransfer > 600_000) -1
                else if (sumTransfer in 300..75_000) 0
                else (sumTransfer * 0.006).toInt() + 20


            else -> {
                if (sumTransfer * 0.0075 < 35) 35
                else if (sumTransfer > 150_000 || sumTransfer + maxSumTransfer > 600_000 ) -1
                else (sumTransfer * 0.075).toInt()
            }
        }
    }




