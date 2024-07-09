
open class Note (override var name : String) : Function<String>(name) {
    private fun printMenu(){
        println("Заметка: ${this.name}")
        println("0.Выйти из заметки")
        println("1.Переиминовать заметки")
        println("2.Обновить/Записать текст в заметки")
        println("3.Вывести текст заметки")
    }

    fun menu (scan :GeneralScanner){
        printMenu()
        var input : Int  = -1
        while(true) {
            scan.takeInt {input = it}
            when (input) {
                0 -> return
                1 -> rename(scan)
                2 -> updatingTextNote(scan)
                3 -> {
                    println("Выводим текст")
                    viewing()}
                else -> println("Невернный ввод")
            }
            printMenu()
        }
    }

    private fun updatingTextNote(scanner : GeneralScanner){
        scanner.takeText(arr)
        println("Текст заметки изменён")
    }
}