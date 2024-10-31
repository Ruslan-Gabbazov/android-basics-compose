class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        
        if (hobby != null) {
            println("Likes to $hobby.")
        } else {
            println("Doesn't have a hobby listed.")
        }
        
        if (referrer == null) {
            println("Doesn't have a referrer.")
        } else {
            println("Has a referrer named ${referrer.name}, who likes to ${referrer.hobby ?: "nothing"}.")
        }
        
        println()
    }
}

fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}
