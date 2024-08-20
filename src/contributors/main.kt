package contributors

fun main() {
    setDefaultFontSize(20f)
    ContributorsUI().apply {
        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }
}