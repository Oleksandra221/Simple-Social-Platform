package com.uep.wap.controller;
import com.uep.wap.configs.WebSecurityConfig;
import com.uep.wap.controller.validators.LogInFormValidation;
import com.uep.wap.controller.validators.RegistartionFormValidator;
import com.uep.wap.controller.helpers.UserLogIn;
import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.service.PostService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;

import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.UserProfileRepository;
import com.uep.wap.dto.UserProfileDTO;

import com.uep.wap.model.UserProfile;
import com.uep.wap.service.UserProfileService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping(path = "/api")
public class UserProfileController{

    private final UserProfileService userProfileService;
    @Autowired
    private RegistartionFormValidator registartionFormValidator;

    @Autowired
    private LogInFormValidation logInFormValidation;
    @Autowired
    private WebSecurityConfig securityConfig;

    @Autowired
    private PostService postService;
    private UserProfile loggedUser;

    private Post post = new Post();

    private EmailValidator emailValidator = EmailValidator.getInstance();

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        // Form target
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == UserProfileDTO.class) {
            dataBinder.setValidator(registartionFormValidator);
        }
        if (target.getClass() == UserLogIn.class) {
            dataBinder.setValidator(logInFormValidation);
        }
    }
    // display welcome page
    @GetMapping("/index")
    public String getWelcomePage(Model model) {
        String msg = "Welcome to Simple Social Platform!";
        // adding the attribute(key-value pair)
        model.addAttribute("message", msg);
        // returning the view name
        return "index";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        model.addAttribute("user", new UserProfileDTO());
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register")
    public String registration(@ModelAttribute("user") @Validated UserProfileDTO user, // @Valid
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        PasswordEncoder encoder = securityConfig.passwordEncoder();

        user.setPassword(encoder.encode(user.getPassword()));
        user.setConfirmedPassword(encoder.encode(user.getConfirmedPassword()));
        userProfileService.addUser(user);
        return "redirect:/register?success";
    }


    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserProfile> users = userProfileService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/userProfile")
    public String getUserProfile(Model model){
        model.addAttribute("checkUser",  new UserProfile());
        model.addAttribute("post", post);
        return "userProfile";
    }
    // getting logged user from db
    @PostMapping("/userProfile")
    public String profilePost(@ModelAttribute("checkUser") @Validated UserLogIn user,
                              @ModelAttribute("post") @Validated Post post,
                               BindingResult result,
                               Model model){
        this.post = post;
        UserProfile userProfile = userProfileService.findUserByEmail(user.getEmail()); // search for logged user in db

        // check whether someone is logged in or whether logged in person has changed
        if (loggedUser == null)
        {
            loggedUser = userProfile;
        }
        else if (loggedUser != null && !loggedUser.getEmail().equals(userProfile.getEmail()))
        {
            loggedUser = userProfile;
        }
        model.addAttribute("checkUser", loggedUser);
        return "userProfile";
    }
    // updating and displayin users' posts
    @GetMapping("/userProfile/addPost/{checkUser}")
    public String updatePosts(Model model, @PathVariable(value="checkUser") @Validated String checkUser){
        model.addAttribute("checkUser", this.loggedUser);
        if (!this.loggedUser.getPosts().isEmpty())
        {
            for (int i = 0; i <  this.loggedUser.getPosts().size(); i++)
            {
                model.addAttribute("post", loggedUser.getPosts().get(i));
            }
        }
        else
        {
            Post new_post = new Post();
            model.addAttribute("post", new_post);
        }
        model.addAttribute("checkUser", loggedUser);
        return "userProfile";
    }
    // creating & saving to db new post
    @PostMapping("/userProfile/addPost/{checkUser}")
    public String addPost(@ModelAttribute("post") @Validated PostDTO post, // @Valid
                          @PathVariable(value="checkUser") @Validated String checkUser,
                              BindingResult result,
                              Model model){
        Post new_post = new Post();
        UserProfile userProfile = userProfileService.findUserByEmail(checkUser);
        this.loggedUser = userProfile;

        new_post.setUser_name(userProfile.getName());
        new_post.setSurname(userProfile.getSurname());
        new_post.setContent(post.getContent());
        new_post.setEmail(userProfile.getEmail());

        this.loggedUser.setPosts(postService.findPostsByEmail(this.loggedUser.getEmail()));
        if (this.loggedUser.getPosts() == null)
        {
            List<Post> posts = new ArrayList<>();
            posts.add(new_post);
            this.loggedUser.setPosts(posts);
        }
        else
        {
            this.loggedUser.getPosts().add(new_post);
        }
        postService.addPost(post);
        return "redirect:/userProfile/addPost/{checkUser}";
    }

    @PostMapping("/deletePost/{id}")
    public String deletePost(@PathVariable(value = "id") long id,
                             @ModelAttribute("post") @Validated PostDTO post, // @Valid
                             Model model)
    {
        Post postToDelete = postService.findPostsById(id);
        if (!this.loggedUser.getPosts().isEmpty())
        {
            for (int i = 0; i <  this.loggedUser.getPosts().size(); i++)
            {
                if (this.loggedUser.getPosts().get(i).getContent().equals(postToDelete.getContent()))
                {
                    this.loggedUser.getPosts().remove(i);
                    postService.deletePostById(id);
                }
                else
                {
                    model.addAttribute("post", loggedUser.getPosts().get(i));
                }
            }
        }
        model.addAttribute("checkUser", loggedUser);
        return "userProfile";
    }



    // handler method to handle login request
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("checkUser", new UserLogIn());
        return "login";
    }

    @PostMapping ("/login")
    public String login(@ModelAttribute("checkUser") @Validated UserLogIn user, // @Valid
                        BindingResult result,
                        Model model){
        if(result.hasErrors()){
            model.addAttribute("checkUser", user);
            return "redirect:/login?failure";
        }
        return "redirect:/login?success";
    }

    public String profile(){
        return "profile";
    }
}