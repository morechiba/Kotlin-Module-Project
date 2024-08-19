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

fun checkScreen(menuSize: Int): Boolean{
    val number: Int = print.toInt()
    val lastNumber: Int = menuSize - 1
    when(screen){
        Screen.ArchivesList -> {
            when(number){
                0 -> screen = Screen.ArchiveAdd
                lastNumber -> {
                    println("Завершение программы")
                    return false
                }
                else -> {
                    archiveSelected = archiveList[number-1]
                    showArchive(archiveList[number-1])
                }
            }
        }
        Screen.ArchiveAdd -> {
            when(number){
                0 -> createArchive()
                lastNumber -> screen = Screen.ArchivesList
            }
        }
        Screen.ArchiveShow -> {
            when(number){
                0 -> screen = Screen.NoteAdd
                lastNumber -> {
                    screen = Screen.ArchivesList
                    archiveSelected = null
                }
                else -> {
                    if(archiveSelected != null) {
                        noteSelected = archiveSelected!!.notes[number-1]
                    }
                    screen = Screen.NoteShow
                    showNote(noteSelected!!)
                }
            }
        }
        Screen.NoteShow -> {
            when(number) {
                0 -> {
                    screen = Screen.ArchiveShow
                    noteSelected = null
                }
            }
        }
        Screen.NoteAdd -> {
            when(number) {
                0 -> createNote()
                lastNumber -> screen = Screen.ArchiveShow
            }
        }
    }
    return true
}

fun createArchive() {
    println("Введите название архива")
    var name = checkEmpty(scanner.nextLine())
    val archive = Archive(name, mutableListOf())
    archiveList.add(archive)
    println("Создан архив ${archive.name}")
    screen = Screen.ArchivesList
}
fun createNote() {
    println("Введите название заметки")
    var name = checkEmpty(scanner.nextLine())
    println("Введите текст заметки")
    var text = checkEmpty(scanner.nextLine())
    archiveSelected?.notes?.add(Note(name, text))
    println("Создана заметка $name")
    screen = Screen.ArchiveShow
}
fun showArchive(archive: Archive){
    screen = Screen.ArchiveShow
    println("Архив ${archive.name}")
}
fun showNote(note: Note) {
    screen = Screen.NoteShow
    println("Заметка ${note.name}")
    println("Текст: ${note.text}")
}
fun checkEmpty(text: String): String {
    var textChecked = text
    while(textChecked.isEmpty()){
        println("Поле не может быть пустым")
        textChecked = scanner.nextLine()
    }
    return textChecked
}