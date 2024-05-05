package com.mowael.uae_universties

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.mowael.universities.view.UniversitiesFragment
import com.mowael.universitydetails.view.ARG_UNIVERSITY_NAME
import com.mowael.universitydetails.view.UniversityDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navHostFragment.let { navFragment ->
            navFragment.childFragmentManager.primaryNavigationFragment?.let { fragment ->
                if (fragment is UniversitiesFragment) {
                    fragment.onUniversityItemClick = { _, name ->
                        navController.navigate(
                            R.id.action_universitiesFragment_to_universityDetailsFragment,
                            Bundle().apply {

                                putString(ARG_UNIVERSITY_NAME, name)
                            })
                    }
                }
            }

            navFragment.childFragmentManager.addFragmentOnAttachListener() { _, fragment ->
                if (fragment is UniversityDetailsFragment) {
                    fragment.onRefreshClick = { navController.popBackStack() }
                }
            }
        }

    }
}
