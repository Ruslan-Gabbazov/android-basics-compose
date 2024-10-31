open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true): Phone() {
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    fun unfold() {
        isFolded = false
    }

    fun fold() {
        isFolded = true
    }
}

fun main() {
    val foldablePhone = FoldablePhone()

    println("Initial state:")
    foldablePhone.checkPhoneScreenLight()

    foldablePhone.fold()
    println("\nAfter folding:")
    foldablePhone.checkPhoneScreenLight()

    foldablePhone.unfold()
    println("\nAfter unfolding:")
    foldablePhone.checkPhoneScreenLight()

    foldablePhone.switchOn()
    println("\nAfter switching on:")
    foldablePhone.checkPhoneScreenLight()

    foldablePhone.fold()
    println("\nAfter folding again:")
    foldablePhone.checkPhoneScreenLight()
}
