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


class ChooseRecipientFragment : Fragment(),View.OnClickListener {
    private lateinit var navController: NavController
    private lateinit var input_recipient : TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        input_recipient=view.findViewById(R.id.input_recipient)

    }

    override fun onClick(v: View?) {
        //view and navcontroller cant be null
      when(v!!.id){
         R.id.next_btn -> {


             if (!TextUtils.isEmpty(input_recipient.text.toString())){
                 var bundle= bundleOf("recipient" to input_recipient.text.toString())

                 navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment2,bundle)
             }
             else{
                 Toast.makeText(requireContext(),"please enter recipient",Toast.LENGTH_SHORT).show()
             }
         }
          R.id.cancel_btn -> activity?.onBackPressed()
      }
    }


}