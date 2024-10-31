class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    var playCount: Int = 0,
    private var _isPopular: Boolean = false
) {
    fun printDescription(): String {
        return "${title}, performed by ${artist}, was released in ${yearPublished}."
    }

    fun incrementPlayCount() {
        playCount++
        updatePopularity()
    }

    private fun updatePopularity() {
        _isPopular = playCount >= 1000
    }

    fun isPopular(): Boolean {
        return _isPopular
    }

    fun setAsPopular(isPopular: Boolean) {
        _isPopular = isPopular
    }
}


fun main() {
    val mySong = Song("21 guns", "Green Day", 2008)
    println(mySong.printDescription())
    
    repeat(1100) { mySong.incrementPlayCount() }
    
    println("Is this song popular? ${mySong.isPopular()}")

}
