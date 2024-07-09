import java.util.Scanner

class GeneralScanner {
    private val scanner = Scanner(System.`in`)

    fun takeName(
        onTakeName :(scan: String) -> Unit
    ){
            println("Введите название")
            if (scanner.hasNextLine()) {
                onTakeName(scanner.nextLine())
                return
            }
    }
    fun takeInt( onTakeName :(scan: Int) -> Unit
    ) {
        while (true) {
            println("Введите цифру")
            if (scanner.hasNextInt()) {
                onTakeName(scanner.nextInt())
                scanner.nextLine()
                return
            } else {
                cleanInput()
            }
        }
    }

    private fun cleanInput(){
            println("Неверный ввод")
            if (scanner.hasNextLine()) {
                scanner.next()
            }
    }

    fun takeText(arr:MutableList<String>){
        var io :String
        while (true) {
            println("Введите текст")
            println("Пустая строка = конец ввода")
            while (true) {
                if (scanner.hasNextLine()) {
                    io = scanner.nextLine()
                    if(io.isEmpty()){
                        return
                    } else{
                        arr.add(io)
                    }
                } else {
                    cleanInput()
                }
            }
        }
    }

}