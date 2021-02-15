package com.colman.natureviews.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.colman.natureviews.fragments.PostsListFragmentDirections;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.colman.natureviews.R;
import com.colman.natureviews.fragments.PostsListFragment;
import com.colman.natureviews.model.Post;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements PostsListFragment.Delegate {

    NavController navCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(LoginPageActivity.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            // User is signed out
            Log.d(TAG, "onAuthStateChanged:signed_out");
        }*/
        setContentView(R.layout.activity_home);

        navCtrl = Navigation.findNavController(this, R.id.home_nav_host);
        BottomNavigationView bottomNav = findViewById(R.id.home_bottom_nav);
        NavigationUI.setupWithNavController(bottomNav, navCtrl);
    }

    @Override
    public void onItemSelected(Post post) {
        navCtrl = Navigation.findNavController(this, R.id.home_nav_host);
        PostsListFragmentDirections.ActionFeedListFragmentToPostDetailsFragment directions = PostsListFragmentDirections.actionFeedListFragmentToPostDetailsFragment(post);
        navCtrl.navigate(directions);
    }
}
