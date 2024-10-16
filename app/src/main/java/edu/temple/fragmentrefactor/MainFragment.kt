package edu.temple.fragmentrefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainFragment : Fragment() {

    private lateinit var displayTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var changeButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        displayTextView = view.findViewById(R.id.displayTextView)
        nameEditText = view.findViewById(R.id.nameEditText)
        changeButton = view.findViewById(R.id.changeButton)

        changeButton.setOnClickListener {
            val name = nameEditText.text.toString()

            displayTextView.text = if (name.isNotBlank()) {
                "Hello, $name!"
            } else {
                "Please enter your name"
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}