package com.example.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText


class ConfirmationFragment : Fragment() {

    private lateinit var txtmessage : TextView

    private lateinit var recipient: String
    lateinit var amount: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      recipient=arguments!!.getString("recipient").toString()
      amount= arguments!!.getParcelable("amount")!!

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtmessage=view.findViewById(R.id.confirmation_message)

        val msg="you have sent ksh ${amount!!.amount} to $recipient"
        txtmessage.text=msg

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

}