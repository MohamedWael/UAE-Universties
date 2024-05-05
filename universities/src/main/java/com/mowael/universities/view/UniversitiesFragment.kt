package com.mowael.universities.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mowael.universities.databinding.FragmentUniversitiesBinding
import com.mowael.universities.di.UniversitiesComponent
import com.mowael.universities.presentation.UniversitiesState
import com.mowael.universities.presentation.UniversitiesViewModel
import com.mowael.universities.view.adapter.UniversitiesAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UniversitiesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UniversitiesFragment : Fragment() {


    var onUniversityItemClick: ((id: Long, name: String?) -> Unit)? = null
    private lateinit var binding: FragmentUniversitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUniversitiesBinding.inflate(inflater, container, false)

        binding.rvUniversities.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUniversities.adapter = UniversitiesAdapter(arrayListOf()) { id, name ->
            onUniversityItemClick?.invoke(id, name)
        }
        val component = UniversitiesComponent.create(requireActivity().application)
        component.inject(this)
        val viewModel = ViewModelProvider(
            this,
            component.universitiesViewModelFactory()
        )[UniversitiesViewModel::class.java]

        viewModel.universitiesLiveData.observe(viewLifecycleOwner) { renderState(it) }
        viewModel.getUniversities()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun renderState(it: UniversitiesState) {
        when (it) {
            is UniversitiesState.Loading -> binding.progress.visibility = View.VISIBLE

            is UniversitiesState.Success -> {
                binding.progress.visibility = View.GONE
                (binding.rvUniversities.adapter as UniversitiesAdapter).setUniversities(it.universities)
            }

            is UniversitiesState.Error -> {
                binding.progress.visibility = View.GONE
                Log.e("UniversitiesFragment", it.error.message.toString())
                Toast.makeText(
                    requireContext(),
                    "An error occured: ${it.error.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {
                // No Op
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UniversitiesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UniversitiesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}