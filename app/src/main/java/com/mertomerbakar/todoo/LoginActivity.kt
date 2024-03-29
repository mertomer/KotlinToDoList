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
    private lateinit var mert:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()
        mert=User("m.omerbakargmail.com","1234")
    }

    fun loginbtn(view: View) {

        fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }

        var status = if (binding.emailContainer.text.toString().equals(mert.email)
            && binding.passwordContainer.text.toString().equals(mert.password)&&isEmailValid(mert.email)==true)




        {

            val intent= Intent(applicationContext,ToDoActivity::class.java)
            startActivity(intent)

        }

        else {
            val alert = AlertDialog.Builder(this@LoginActivity)

            if (!isEmailValid(mert.email)&&binding.emailContainer.text.toString().equals(mert.email)){
                alert.setTitle("Wrong email pattern")
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
            else if(isEmailValid(binding.emailContainer.text.toString())==true&&binding.emailContainer.text.toString()!=mert.email){
                alert.setTitle("Wrong email or password")
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


            } else {
                alert.setTitle("Wrong email")
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


    }

            }

