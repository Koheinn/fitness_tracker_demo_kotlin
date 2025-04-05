package com.example.fitness_tracker_demo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.fitness_tracker_demo.databinding.ActivityMainBinding
import kotlin.jvm.Throws

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userName: String
    lateinit var email: String
    lateinit var password: String
    var weight: Double = 0.0
    var height: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            if (validateInputs()) {
                registerUser()
            }
        }
    }

    private fun validateInputs(): Boolean {
        userName = binding.userName.text.toString()
        email = binding.emailAddress.text.toString()
        password = binding.passwordHolder.text.toString()
        weight = binding.weight.text.toString().toDoubleOrNull() ?: 0.0
        height = binding.height.text.toString().toDoubleOrNull() ?: 0.0

        return when {
            userName.isEmpty() -> {
                Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
                false
            }
            email.isEmpty() -> {
                Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
                false
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
                false
            }
            weight == 0.0 -> {
                Toast.makeText(this, "Weight is required", Toast.LENGTH_SHORT).show()
                false
            }
            height == 0.0 -> {
                Toast.makeText(this, "Height is required", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }

    }
    // Register user with the provided data
    private fun registerUser() {
//        userName = binding.userName.text.toString()
//        email = binding.emailAddress.text.toString()
//        password = binding.passwordHolder.text.toString()
//        weight = binding.weight.text.toString().toDoubleOrNull() ?: 0.0
//        height = binding.height.text.toString().toDoubleOrNull() ?: 0.0
//
        val url = "http://192.168.8.139/fitness_code_android/registrationDAO.php"
//
//        val stringRequest = object : StringRequest(
//            Request.Method.POST, url,
//            Response.Listener<String> { response ->
//                handleRegistrationResponse(response)
//            },
//            Response.ErrorListener { error ->
//                handleError(error)
//            }
//        ) {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): MutableMap<String, String> {
//                val params = mutableMapOf<String, String>()
//                params["phpFunction"] = "createUser"
//                params["username"] = userName
//                params["email"] = email
//                params["pass"] = password
//                params["weight"] = weight.toString()
//                params["height"] = height.toString()
//                return params
//            }
//        }
//
//        Volley.newRequestQueue(this).add(stringRequest)
        // Create a StringRequest object for the registration process
        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String> { response ->
                if (response.equals("True")){
                    Toast.makeText(this, "Registered Successful", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error occurred1", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error occurred2: $error", Toast.LENGTH_SHORT).show()
            }) {

            // Override getParams function to send parameters
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>{
                val params = mutableMapOf<String, String>()

                params["phpFunction"] = "createUser"
                params["username"] = userName
                params["email"] = email
                params["pass"] = password
                params["weight"] = weight.toString()
                params["height"] = height.toString()

                return params
            }
        }
        Volley.newRequestQueue(this).add(stringRequest)
    }
}