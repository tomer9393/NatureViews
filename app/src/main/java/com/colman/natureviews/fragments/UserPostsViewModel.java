package com.colman.natureviews.fragments;

import androidx.lifecycle.LiveData;
import com.colman.natureviews.model.Model;
import com.colman.natureviews.model.Post;
import com.colman.natureviews.model.User;
import java.util.List;


public class UserPostsViewModel extends PostsListViewModel {
    LiveData<List<Post>> liveData;

    @Override
    public LiveData<List<Post>> getData() {
        if (liveData == null)
            liveData = Model.instance.getAllPostsByUserId(User.getInstance().userId);
        return liveData;    }

    @Override
    public void refresh(Model.CompListener listener) {
        Model.instance.refreshPostsList(listener);
    }
}
