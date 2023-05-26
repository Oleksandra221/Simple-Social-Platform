package com.uep.wap.model.interfaces;

import com.uep.wap.model.UserProfile;

import java.util.HashMap;
import java.util.Map;

public interface Comment {

    public UserProfile user = new UserProfile();
    public String comment = "";

    // only users logged in can leave comments
    // have to throw error if user is not logged in and forbid user to leave a comment
    public boolean isUserLoggedIn(UserProfile userProfile);

    public void leaveComment(String comment);

    public String postComment();

    public void deleteComment(String comment);

    public void editComment(String comment);

    public void hideComment(String comment);
}
