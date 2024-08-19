import java.util.Scanner
fun main(args: Array<String>) {
    // который содержит код:
    //        По выводу пунктов меню;
    //        По чтению пользовательского ввода;
    //        По выполнению определённых операций на выбор пункта меню.
    //Для всего этого советуем использовать изменяемый список,
    // который содержит в себе название пункта и лямбду,
    // которая вызовется при выборе этого пункта.
    //    Для ввода стоит использовать бесконечный цикл,
    //    который повторяется до тех пор, пока пользователь не выберет выход.

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
val scanner = Scanner(System.`in`).useDelimiter("\\R")
var archiveList: MutableList<Archive> = mutableListOf()
var screen = Screen.ArchivesList
var print: String = ""
var archiveSelected: Archive? = null
var noteSelected: Note? = null