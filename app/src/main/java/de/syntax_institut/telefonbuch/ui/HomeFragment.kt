package de.syntax_institut.telefonbuch.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.syntax_institut.telefonbuch.R
import de.syntax_institut.telefonbuch.adapter.ItemAdapter
import de.syntax_institut.telefonbuch.data.Datasource
import de.syntax_institut.telefonbuch.data.model.Contact
import de.syntax_institut.telefonbuch.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contacts = Datasource().loadContacts()

        // die RecyclerView bekommt den Adapter
        val itemAdapter = ItemAdapter(contacts)
        binding.recyclerView.adapter = itemAdapter

        // Button fügt einen Listeneintrag hinzu
        binding.btnAdd.setOnClickListener {

            // Hole den Inhalt aus den Textfeldern
            val name = binding.inName.text.toString()
            val number = binding.inPhoneNumber.text.toString()

            // Falls in beiden Textfeldern etwas steht
            if (name != "" && number != "") {
                val position = contacts.size // kann auch ein anderer Index <= contacts.size sein
                contacts.add(position, Contact(name, number))
                itemAdapter.notifyItemInserted(position)
                binding.inName.setText("")
                binding.inPhoneNumber.setText("")
            }
        }
    }


}