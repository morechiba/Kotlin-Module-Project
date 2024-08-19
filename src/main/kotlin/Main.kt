import java.util.Scanner
fun main(args: Array<String>) {
     val menu = Menu()

    while(true){
        menu.menuShow()
        needNumberDialog()
        while(checkMenuPoints(menu.getMenuSize()) == false){
            println("Такого пункта меню не существует")
            menu.menuShow()
            needNumberDialog()
        }

        if (checkScreen(menu.getMenuSize()) == false) return
    }

}
val scanner = Scanner(System.`in`)
var archiveList: MutableList<Archive> = mutableListOf()
var screen = Screen.ArchivesList
var print: String = ""
var archiveSelected: Archive? = null
var noteSelected: Note? = null