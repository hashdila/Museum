// src/main/kotlin/com/example/demo/controller/FeedbackController.kt
package com.example.meseum.controller




import com.example.demo.model.Feedback
import com.example.meseum.repository.FeedbackRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class FeedbackController(private val feedbackRepository: FeedbackRepository) {

    // Display the feedback form
    @GetMapping
    fun showForm(model: Model): String {
        model.addAttribute("feedback")
        return "feedbackForm"
    }

    // Handle form submission and save to database
    @PostMapping("/submitFeedback")
    fun submitFeedback(@ModelAttribute feedback: Feedback, model: Model): String {
        feedbackRepository.save(feedback) // Save to MySQL database
        model.addAttribute("message", "Thank you for your feedback!")
        return "feedbackForm"
    }

    // View all submitted feedback
    @GetMapping("/viewFeedbacks")
    fun viewFeedbacks(model: Model): String {
        val feedbackList = feedbackRepository.findAll() // Fetch all records
        model.addAttribute("feedbackList", feedbackList)
        return "feedbackList"
    }
}