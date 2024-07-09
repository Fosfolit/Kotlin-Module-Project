
class Archive(override var name : String ) : Function<Note>(name) {

    private fun printMenu(){
        println("Архив: ${this.name}")
        println("0.Выйти из архива")
        println("1.Переиминовать архив")
        println("2.Перейти в заметку")
        println("3.Добавить новую заметку")
        println("4.Удалить заметку")
    }

    fun menu (scan :GeneralScanner){
        printMenu()
        var inpu : Int  = -1
        while(true) {
            scan.takeInt { inpu = it}
            when (inpu) {
                0 -> return
                1 -> rename(scan)
                2 -> choiceNote(scan)
                3 -> addNewNote(scan)
                4 -> choiceNoteDelete(scan)
                else -> println("Невернный ввод")
            }
            printMenu()
        }
    }

    private fun choiceNote(scan :GeneralScanner){
        selectMenu()
        val inpu : Int = selected(scan)
        if(inpu == 0 ) {
            return
        }
        arr[inpu-1].menu(scan)
    }

    private fun addNewNote(scan:GeneralScanner){
        scan.takeName {arr.add(Note(it)) }
        println("Новое закладка добавлена")
    }

    private fun choiceNoteDelete(scan :GeneralScanner){
        selectMenuDelete()
        val inpu : Int = selected(scan)
        if(inpu == 0 ) {
            return
        }
        delete(inpu)
    }


    override fun whatPrintNeed(count: Int, it: Note) {
        println((count+1).toString()+ ". " + it.name)
    }
}