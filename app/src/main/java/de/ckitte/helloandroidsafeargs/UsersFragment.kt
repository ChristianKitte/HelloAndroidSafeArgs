package de.ckitte.helloandroidsafeargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A fragment representing a list of Items.
 */
class UsersFragment : Fragment() {
    private val users = listOf<User>(
        User(1, "Peter", 23),
        User(2, "Doris", 24),
        User(3, "Christian", 44),
        User(4, "Bernd", 29),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    users.count() <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, users.count())
                }
                adapter = UsersRecyclerViewAdapter(users)
            }
        }
        return view
    }

}