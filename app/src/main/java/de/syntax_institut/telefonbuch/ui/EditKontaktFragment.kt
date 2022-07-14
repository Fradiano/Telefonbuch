package de.syntax_institut.telefonbuch.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.syntax_institut.telefonbuch.R
import de.syntax_institut.telefonbuch.databinding.FragmentEditKontaktBinding
import de.syntax_institut.telefonbuch.databinding.FragmentHomeBinding


class EditKontaktFragment : Fragment() {

    lateinit var binding: FragmentEditKontaktBinding
    var name = ""
    var nummer = ""

        override

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_kontakt, container, false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            name = it.getString("name").toString()
            nummer = it.getString("nummer").toString()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nameView.text = name
        binding.nummerView.text = nummer
    }

}