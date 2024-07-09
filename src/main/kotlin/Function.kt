open class Function<T>(open var name: String) {
    val arr: MutableList<T> = mutableListOf()

    fun viewing() {
        if (arr.isEmpty()) {
            return
        }
        for (i in arr.indices) {
            whatPrintNeed(i, arr[i])
        }
    }

    open fun whatPrintNeed(count: Int, it: T) {
        println( it.toString())
    }

    fun rename(scan: GeneralScanner) {
        scan.takeName {name = it }
        println("Новое имя получено")
    }

    fun delete(count: Int) {
        arr.remove(arr[count - 1])
        println("Элемент успешно удалён")

    }

    fun selected(scan :GeneralScanner) : Int{
        var inpu : Int  = -1
        while(true){
            scan.takeInt { inpu = it}
            if (inpu >= 0 && inpu <= arr.size) {
                return inpu
            }else {
                println("Неверный ввод")
            }
        }
    }

    fun selectMenuDelete() {
        println("Выберите элемент для удаления")
        println("0. Вернутся назад")
        viewing()
    }

    fun selectMenu() {
        println("Выберите элемент ")
        println("0. Вернутся назад")
        viewing()
    }

}