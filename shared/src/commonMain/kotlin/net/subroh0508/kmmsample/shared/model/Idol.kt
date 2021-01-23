package net.subroh0508.kmmsample.shared.model

data class Idol(
    val id: String,
    val name: String,
    val yomi: String,
    val color: String,
    val age: Int,
    val birthplace: String,
    val hobbies: List<String>,
    val idollistUrl: String,
)
