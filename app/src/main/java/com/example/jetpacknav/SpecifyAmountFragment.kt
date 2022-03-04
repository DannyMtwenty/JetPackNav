package com.example.jetpacknav

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment() ,View.OnClickListener{
  private lateinit var navController: NavController
  private lateinit var txtmessage : TextView
    private lateinit var input_amount: TextInputEditText
  private lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //retrieve recipient from the bundle
        recipient= arguments!!.getString("recipient").toString()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)

        input_amount=view.findViewById(R.id.input_amount)

        txtmessage=view.findViewById(R.id.recipient)
        txtmessage.text="Sending money to $recipient"



    }


    override fun onClick(v: View?) {
        //view and navcontroller cant be null
        when(v!!.id){
            R.id.send_btn -> {


                if (!TextUtils.isEmpty(input_amount.text.toString())){
                    var bundle= bundleOf("recipient" to recipient,"amount" to Money(BigDecimal(input_amount.text.toString())))

                   navController.navigate(R.id.action_specifyAmountFragment2_to_confirmationFragment,bundle)
                }
                else{
                    Toast.makeText(requireContext(),"please enter recipient", Toast.LENGTH_SHORT).show()
                }

            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }

    }
}