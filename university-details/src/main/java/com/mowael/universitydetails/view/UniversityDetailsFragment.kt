package com.mowael.universitydetails.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mowael.universitydetails.databinding.FragmentUniversityDetailsBinding
import com.mowael.universitydetails.di.UniversityDetailsComponent
import com.mowael.universitydetails.presentation.UniversityDetailsState
import com.mowael.universitydetails.presentation.UniversityDetailsViewModel

const val ARG_UNIVERSITY_NAME = "university_name"

class UniversityDetailsFragment : Fragment() {

    companion object {
        fun newInstance(universityName: String) = UniversityDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_UNIVERSITY_NAME, universityName)
            }
        }
    }

    private lateinit var binding: FragmentUniversityDetailsBinding
    private val component: UniversityDetailsComponent by lazy {
        UniversityDetailsComponent.create(
            requireActivity().application
        )
    }
    private val viewModel: UniversityDetailsViewModel by viewModels(factoryProducer = { component.universityDetailsViewModelFactory() })
    var onRefreshClick: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        binding = FragmentUniversityDetailsBinding.inflate(inflater, container, false)
        viewModel.universitiesLiveData.observe(viewLifecycleOwner) { renderState(it) }

        arguments?.let {
            it.getString(ARG_UNIVERSITY_NAME)?.also { universityNmae ->
                viewModel.getUniversityByName(universityNmae)
            }
        }

        binding.btnRefresh.setOnClickListener {
            onRefreshClick?.invoke()
        }
        return binding.root
    }

    private fun renderState(state: UniversityDetailsState) {

        when (state) {
            is UniversityDetailsState.Loading -> {
                binding.progress.visibility = View.VISIBLE
            }

            is UniversityDetailsState.Success -> {
                binding.progress.visibility = View.GONE
                state.university?.apply {
                    binding.tvName.text = name
                    binding.tvState.text = stateProvince
                    binding.tvCountry.text = country
                    binding.tvCountryCode.text = alphaTwoCode
                    binding.tvWebPage.text = webPages?.get(0) ?: "No web page"
                }
            }

            is UniversityDetailsState.Error -> {
                binding.progress.visibility = View.GONE
                Log.e("UniversityDetailsFragment", state.error.message, state.error)
                Toast.makeText(requireContext(), state.error.message, Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        onRefreshClick = null
    }
}