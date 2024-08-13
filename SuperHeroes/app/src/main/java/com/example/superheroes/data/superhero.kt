package com.example.superheroes.data

import androidx.annotation.DrawableRes
import com.example.superheroes.R

data class Superhero(
    val name: String,
    val age: Int,
    val superpower: String,
    val bio: String,
    @DrawableRes val imageResId: Int
)

val superheroes = listOf(
    Superhero(
        name = "Atom Eve",
        age = 28,
        superpower = "Matter Manipulation",
        bio = "Atom Eve has the ability to manipulate matter at a subatomic level.",
        imageResId = R.drawable.atom_e
    ),
    Superhero(
        name = "Batgirl",
        age = 25,
        superpower = "Expert Martial Artist",
        bio = "Batgirl is a skilled fighter and detective, fighting crime in Gotham City.",
        imageResId = R.drawable.batgirl


    ),
    Superhero(
        name = "Black Widow",
        age = 35,
        superpower = "Master Spy",
        bio = "Black Widow is an elite spy with unmatched combat skills.",
        imageResId = R.drawable.blackw

    ),
    Superhero(
        name = "Captain Marvel",
        age = 32,
        superpower = "Super Strength, Energy Projection",
        bio = "Captain Marvel is one of the most powerful superheroes with incredible strength and the ability to project energy blasts.",
        imageResId = R.drawable.captainm

    ),
    Superhero(
        name = "Catwoman",
        age = 30,
        superpower = "Stealth, Agility",
        bio = "Catwoman is a master thief with incredible agility and stealth skills.",
        imageResId = R.drawable.catw

    ),
    Superhero(
        name = "She-Hulk",
        age = 30,
        superpower = "Super Strength",
        bio = "She-Hulk possesses immense strength and is a formidable force in battle.",
        imageResId = R.drawable.sheh

    ),
    Superhero(
        name = "Storm",
        age = 29,
        superpower = "Weather Manipulation",
        bio = "Storm can control the weather, summoning storms and lightning at will.",
        imageResId = R.drawable.storm
    ),
    Superhero(
        name = "Supergirl",
        age = 24,
        superpower = "Super Strength, Flight",
        bio = "Supergirl has incredible strength and the ability to fly, just like her cousin Superman.",
        imageResId = R.drawable.superg
    ),
    Superhero(
        name = "Wonder Woman",
        age = 28,
        superpower = "Super Strength, Combat Skills",
        bio = "Wonder Woman is a warrior princess with super strength and unparalleled combat skills.",
        imageResId = R.drawable.wonderw

    )
)
