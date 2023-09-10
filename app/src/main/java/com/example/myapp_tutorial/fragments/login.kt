package com.example.myapp_tutorial.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.myapp_tutorial.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [login.newInstance] factory method to
 * create an instance of this fragment.
 */
class login : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var vista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        return vista
    }

    override fun onStart() {
        super.onStart()
        val goToRegister = vista.findViewById<TextView>(R.id.registerId)
        val loginBtn = vista.findViewById<Button>(R.id.loginBtnId)
        val username = vista.findViewById<EditText>(R.id.usernameId)
        val password = vista.findViewById<EditText>(R.id.passwordId)


        loginBtn.setOnClickListener {
            Log.d("Usuario",username.text.toString())
            Log.d("Contraseña",password.text.toString())

            if(username.text.toString() == "a" &&  password.text.toString() == "b") {

                vista.findNavController().navigate(R.id.action_login_to_successLogin)
            }

        }



        goToRegister.setOnClickListener {

            vista.findNavController().navigate(R.id.action_login_to_register)

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}