fun userPrint(): Int? {
    print = scanner.nextLine()
    if(print.toDoubleOrNull() != null){
        if (print.toIntOrNull() != null){
            val number = print.toInt()
            if(number >= 0) {
                return number
            } else {
                println("Вы ввели отрицательное число")
                return null
            }
        } else {
            println("Вы ввели дробное число")
            return null
        }
    } else {
        println("Вы ввели текст")
        return null
    }
}
fun needNumberDialog () {
   while (userPrint() === null) {
       println("Введите число")
   }
}
fun checkMenuPoints(menuSize: Int): Boolean {
   if(print.toInt() in 0.. (menuSize-1)) return true else return false
}

fun make(){
    println("Делаю!")
}

fun checkScreen(menuSize: Int): Boolean{
    val number: Int = print.toInt()
    val lastNumber: Int = menuSize - 1
    when(screen){
        Screen.ArchivesList -> {
            when(number){
                // TODO: ВЫБОР АРХИВА 
                0 -> createArchive()
                lastNumber -> {
                    println("Завершение программы")
                    return false
                }
                else -> println("else")
            }
        }
        Screen.ArchiveAdd -> {
            when(number){
                0 -> createArchive()
                lastNumber -> screen = Screen.ArchivesList
                else -> println("else")
            }
        }
        Screen.ArchiveShow -> {
            when(number){
                0 -> createNote()
                1 -> println(screen)
                2 -> screen = Screen.NoteShow
                lastNumber -> screen = Screen.ArchivesList
            }
        }

        Screen.NoteShow -> {
            when(number) {
                0 -> println("0 show")
                1 -> println(screen)
                2 -> screen = Screen.NoteAdd
                lastNumber -> screen = Screen.ArchiveShow
            }
        }
        Screen.NoteAdd -> {
            when(number) {
                0 -> println("0 show")
                1 -> println(screen)
                2 -> screen = Screen.NoteAdd
                lastNumber -> screen = Screen.ArchiveShow
            }
        }


        else -> println("else")
    }
    return true
}

fun createArchive() {
    println("Введите название архива")
    val name = scanner.nextLine()
    val archive = Archive(name, mutableListOf())
    archiveList.add(archive)
    println("Создан архив ${archive.name}")
}
fun createNote() {
    println("Введите название заметки")
    val name = scanner.nextLine()
    println("Введите текст заметки")
    val text = scanner.nextLine()
    val note = Note(name, text)
    // TODO: ДОБАВИТЬ В СПИСОК ЗАМЕТОК
    //notesList.add(note)
    println("Создана заметка ${note.name}")
}