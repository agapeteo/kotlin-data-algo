package dynamic

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class KnapsackTest {

    @Test
    fun maxTotalPrice() {
        val items = mutableListOf<Knapsack.Item>()
        items.add(Knapsack.Item(price = 100, weight = 10))
        items.add(Knapsack.Item(price = 12, weight = 10))
        items.add(Knapsack.Item(price = 3, weight = 3))
        items.add(Knapsack.Item(price = 1, weight = 1))

        val actual = Knapsack.maxTotalPrice(items, 13);

        assertEquals(103, actual)
    }
}