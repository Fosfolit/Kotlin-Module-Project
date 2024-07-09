
class ArchiveArr : Function<Archive>("start") {
    private val scan: GeneralScanner = GeneralScanner()
    fun start(){
        menu(scan)
    }

    private fun printMenu(){
        println("0.Выйти")
        println("1.Выбрать Архив")
        println("2.Создать Архив")
        println("3.Удалить Архив")
    }

    private fun menu(scan: GeneralScanner){
        println("Доброго времени суток")
        printMenu()
        var inpu : Int  = -1
        while(true) {
            scan.takeInt {inpu = it}
            when (inpu) {
                0 -> return
                1 -> selectArchives(scan)
                2 -> addArchive()
                3 -> selectArchivesDelete(scan)
                else -> println("Невернный ввод")
            }
            printMenu()

        }
    }

    private fun addArchive(){
        scan.takeName {arr.add(Archive(it)) }
        println("Архив успешно создан")
    }

    private fun selectArchives(scan :GeneralScanner){
        selectMenu()
        val inpu : Int = selected(scan)
        if(inpu == 0 ) {
            return
        }
        arr[inpu-1].menu(scan)
    }

    private fun selectArchivesDelete(scan :GeneralScanner){
        selectMenuDelete()
        val inpu : Int = selected(scan)
        if(inpu == 0 ) {
            return
        }
        delete(inpu)
    }

    override fun whatPrintNeed(count: Int, it: Archive) {
        println((count+1).toString() + ". " +it.name)
    }

}