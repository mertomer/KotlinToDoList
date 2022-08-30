package com.mertomerbakar.todoo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mertomerbakar.todoo.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*
import java.lang.Exception
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()


        loginbtn.setOnClickListener {


            var status = if (emailContainer.text.toString().equals("m.omerbakar@gmail.com")
                && passwordContainer.text.toString().equals("1234")
            )



            {

                val intent= Intent(applicationContext,ToDoActivity::class.java)
                startActivity(intent)

            }

            else {
                val alert = AlertDialog.Builder(this@LoginActivity)
                alert.setTitle("Wrong Password or E mail")
                alert.setMessage("try again ")
             print("Email is not validate. Show error")


                alert.setPositiveButton("Yes") { dialog, which ->
                    //restart
                    val intent = intent

                    finish()
                    startActivity(intent)}
                alert.setNegativeButton("No"){
                        dialog, which ->
                    Toast.makeText(this@LoginActivity, "", Toast.LENGTH_SHORT).show()

                }
                alert.show()

                }


            }

        fun loginbutton(view: View) {


                    }

                }


            }

