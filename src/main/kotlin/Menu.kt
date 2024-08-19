open class Menu () {

    //var listMenu: MutableList<String> = mutableListOf()
    var menuList: MutableList<String> = mutableListOf("Создать архив", "Выход")
    fun menuShow() {
        val menuList = when(screen){
            Screen.ArchivesList -> menuArchivesCreate()
            Screen.ArchiveShow -> menuNotesCreate()
            Screen.ArchiveAdd -> mutableListOf("Создание архива", "Назад")
            Screen.NoteAdd -> mutableListOf("Создание заметки", "Назад")
            Screen.NoteShow -> mutableListOf("Назад")
        }
        println("Выберите пункт меню:")
        for((index, item) in menuList.withIndex()){
            println("$index. $item")
        }
    }
    fun getMenuSize(): Int {
        return menuList.size
    }
    fun menuArchivesCreate(): MutableList<String> {
        menuList = mutableListOf("Создать архив", "Выход")
        var itemNameList: MutableList<String> = mutableListOf()
        for(archive in archiveList){
            itemNameList.add(archive.name)
        }
        menuList.addAll(1, itemNameList)
        return menuList
    }

    fun menuNotesCreate(): MutableList<String>{
        menuList = mutableListOf("Создать заметку", "Назад")
        var itemNameList: MutableList<String> = mutableListOf()
        val archive = archiveSelected
        if (archive != null) {
            for(note in archive.notes){
                itemNameList.add(note.name)
            }
        }
        menuList.addAll(1, itemNameList)
        return menuList
    }

}