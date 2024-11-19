// src/main/kotlin/com/example/demo/controller/FeedbackController.kt
package com.example.meseum.controller

import com.example.meseum.model.Feedback
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class FeedbackController {

    private val feedbackList = mutableListOf<Feedback>()

    // Display the feedback form
    @GetMapping
    fun showForm(model: Model): String {
        model.addAttribute("feedback", Feedback("", "", "", "", "", "", "", "", "", "", "", "",""))
        return "feedbackForm"
    }

    // Handle form submission
    @PostMapping("/submitFeedback")
    fun submitFeedback(@ModelAttribute feedback: Feedback, model: Model): String {
        feedbackList.add(feedback)
        model.addAttribute("message", "Thank you for your feedback!")
        return "feedbackForm"
    }

    // View all submitted feedback
    @GetMapping("/viewFeedbacks")
    fun viewFeedbacks(model: Model): String {
        model.addAttribute("feedbackList", feedbackList)
        return "feedbackList"
    }
}
