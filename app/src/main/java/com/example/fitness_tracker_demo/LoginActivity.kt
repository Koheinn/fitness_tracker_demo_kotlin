package com.example.fitness_tracker_demo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
import com.example.fitness_tracker_demo.databinding.ActivityLoginBinding
import org.json.JSONException
import org.json.JSONObject
import kotlin.jvm.Throws

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener{
            login()
        }
        binding.registerButton.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    private fun login() {
        val emailIp: String = binding.loginEmail.text.toString().trim()
        val passwordIp: String = binding.loginPassword.text.toString().trim()
        if (emailIp.isEmpty() || passwordIp.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailIp).matches()) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            return
        }
        var URL_ROOT = "http://192.168.8.139/fitness_code_android/Login.php"
val stringRequest= object : StringRequest(Request.Method.POST,URL_ROOT,
    Response.Listener<String>{
            response ->
                Log.d("LOGIN_RESPONSE",response)

                try {
                    Log.d("RES", response.toString())
                    val ss = response.toString()
                    val jsonPart = ss.substring(response.indexOf("{"))
                    val obj = JSONObject(jsonPart)
                    if (obj.getString("response") == "true") {
                        val username = obj.getString("username")
                        Toast.makeText(applicationContext, "Welcome, $username!", Toast.LENGTH_LONG)
                            .show()
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Invalid credentials", Toast.LENGTH_LONG)
                            .show()
                    }
                }catch (e:JSONException){
                    e.printStackTrace()
                    Toast.makeText(applicationContext,"JSON error : ${e.message}",Toast.LENGTH_LONG).show()
                }
    },Response.ErrorListener {
        error->
            Log.e("LOGIN_ERROR",error.toString())
            Toast.makeText(applicationContext,"Login failed : ${error.message}",Toast.LENGTH_LONG).show()
    }) {
    @Throws(AuthFailureError::class)
    override fun getParams(): MutableMap<String, String>? {
        val params=HashMap<String,String>()
        params.put("phpFunction","loginUser")
        params.put("email",emailIp)
        params.put("password",passwordIp)
        return params
    }
}
        Volley.newRequestQueue(this).add(stringRequest)
    }
}