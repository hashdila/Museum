// src/main/kotlin/com/example/demo/model/Feedback.kt
package com.example.demo.model

import jakarta.persistence.*

@Entity
@Table(name = "feedback")
data class Feedback(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val studentId: String,

    @Column(nullable = false)
    val question1: String,

    @Column(nullable = false)
    val question2: String,

    @Column(nullable = false)
    val question3: String,

    @Column(nullable = false)
    val question4: String,

    @Column(nullable = false)
    val question5: String,

    @Column(nullable = false)
    val question6: String,

    @Column(nullable = false)
    val question7: String,

    @Column(nullable = false)
    val question8: String,

    @Column(nullable = false)
    val question9: String,

    @Column(nullable = false)
    val question10: String,

    @Column(length = 1000)
    val comments: String
)
