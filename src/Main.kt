fun main() {
    val n = readLine()!!.toInt() // Чтение количества точек
    val letters = readLine()!! // Чтение строки с буквами

    val result = StringBuilder() // Для хранения результата

    for (i in 0 until n) {
        val (x, y) = readLine()!!.split(" ").map { it.toDouble() } // Чтение координат точки

        when {
            // Верхний ряд: цифры 0-9
            y < 1.0 -> {
                val digit = (x.toInt()).coerceIn(0, 9) // Определяем цифру
                result.append(digit)
            }
            // Второй ряд: буквы a-j (первые 10 символов)
            y < 2.0 -> {
                val index = (x.toInt()).coerceIn(0, 9) // Определяем индекс буквы
                result.append(letters[index])
            }
            // Третий ряд: буквы k-t (следующие 10 символов)
            y < 3.0 -> {
                val index = (x.toInt()).coerceIn(0, 9) + 10 // Определяем индекс буквы
                result.append(letters[index])
            }
            // Четвертый ряд: буквы u-z и пробел
            else -> {
                when {
                    // Буквы u, v, w (первые 3 символа из последних 6)
                    x < 3.0 -> {
                        val index = (x.toInt()).coerceIn(0, 2) + 20 // Индексы 20, 21, 22
                        result.append(letters[index])
                    }
                    // Пробел (координаты от 3.0 до 7.0)
                    x in 3.0..7.0 -> {
                        result.append(' ') // Пробел
                    }
                    // Буквы x, y, z (последние 3 символа из последних 6)
                    else -> {
                        val index = (x.toInt() - 7).coerceIn(0, 2) + 23 // Индексы 23, 24, 25
                        result.append(letters[index])
                    }
                }
            }
        }
    }

    println(result.toString()) // Вывод результата
}