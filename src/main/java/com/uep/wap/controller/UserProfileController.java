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
        System.out.println("initBinder()");
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == UserProfileDTO.class) {
            dataBinder.setValidator(registartionFormValidator);
        }
        if (target.getClass() == UserLogIn.class) {
            dataBinder.setValidator(logInFormValidation);
        }
    }

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
        System.out.println("registration func" + user.getEmail());
        System.out.println("userProfileDTO: " + user.getId() + ", " + user.getName()
                + ", " + user.getSurname());

        if(result.hasErrors()){
            System.out.println("result has errors");
            model.addAttribute("user", user);
            return "register";
        }
        PasswordEncoder encoder = securityConfig.passwordEncoder();

        user.setPassword(encoder.encode(user.getPassword()));
        user.setConfirmedPassword(encoder.encode(user.getConfirmedPassword()));
        System.out.println("password = " + user.getPassword());
        userProfileService.addUser(user);
        return "redirect:/register?success";
    }


    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        System.out.println("users");
        List<UserProfile> users = userProfileService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/userProfile")
    public String getUserProfile(Model model){
        System.out.println("getUserProfile");
        model.addAttribute("checkUser",  new UserProfile());
        model.addAttribute("post", post);
        return "userProfile";
    }
    // saving post and searching for user in db
    @PostMapping("/userProfile")
    public String profilePost(@ModelAttribute("checkUser") @Validated UserLogIn user,
                              @ModelAttribute("post") @Validated Post post,
                               BindingResult result,
                               Model model){
        System.out.println("profile post func");
        this.post = post;                           // save content in glbal variable
//        System.out.println(loggedUser.toString());
        UserProfile userProfile = userProfileService.findUserByEmail(user.getEmail()); // search for logged user in db
        System.out.println("userProfile = " + (userProfile == null));
        System.out.println("loggedUser = " + (loggedUser == null));
        if (loggedUser != null && userProfile != null)
        {
            System.out.println("wtf");
            System.out.println("emails = " + (loggedUser.getEmail().equals(userProfile.getEmail())));
            System.out.println("loggedUser.email = " + (loggedUser.getEmail()) + "userProfile.getEmail = " + userProfile.getEmail());
        }

        // check whether someone is logged in or whether logged in person has changed
        if (loggedUser == null)
        {
            System.out.println("profile post func if");
            loggedUser = userProfile;
        }
        else if (loggedUser != null && !loggedUser.getEmail().equals(userProfile.getEmail()))
        {
            loggedUser = userProfile;
        }
        System.out.println("before adding checkUser attribute = " + loggedUser.getPosts().isEmpty());
        model.addAttribute("checkUser", loggedUser);
        return "userProfile";
    }

    @GetMapping("/userProfile/addPost/{checkUser}")
    public String updatePosts(Model model, @PathVariable(value="checkUser") @Validated String checkUser){
        System.out.println("getUserProfilePost");
//        UserProfile userProfile = userProfileService.findUserByEmail(checkUser);
        model.addAttribute("checkUser", this.loggedUser);
        System.out.println("logged user = " + this.loggedUser.getPosts().isEmpty());
        System.out.println("logged user post size = " + this.loggedUser.getPosts().size());
        if (!this.loggedUser.getPosts().isEmpty())
        {
            System.out.println("if");
//            System.out.println(loggedUser.getPosts().get(0).getContent());
            for (int i = 0; i <  this.loggedUser.getPosts().size(); i++)
            {
                System.out.println("i = " + i);
                System.out.println("post = " + this.loggedUser.getPosts().get(i).getContent());
                model.addAttribute("post", loggedUser.getPosts().get(i));
            }
        }
        else
        {
            System.out.println("else");
            Post new_post = new Post();
            new_post.setContent("new post");
            model.addAttribute("post", new_post);
        }
        model.addAttribute("checkUser", loggedUser);
        return "userProfile";
    }

    @PostMapping("/userProfile/addPost/{checkUser}")
    public String addPost(@ModelAttribute("post") @Validated PostDTO post, // @Valid
                          @PathVariable(value="checkUser") @Validated String checkUser,
                              BindingResult result,
                              Model model){
        System.out.println("post profile");
        Post new_post = new Post();
        UserProfile userProfile = userProfileService.findUserByEmail(checkUser);
        this.loggedUser = userProfile;
        System.out.println(checkUser);
        // creating & saving new post
        new_post.setUser_name(userProfile.getName());
        new_post.setSurname(userProfile.getSurname());
        new_post.setContent(post.getContent());
        new_post.setEmail(userProfile.getEmail());

        System.out.println(this.loggedUser.toString());
        System.out.println(post.toString());
        if (loggedUser != null)
        {
            System.out.println("posts size= " + this.loggedUser.getPosts().size());
        }
        this.loggedUser.setPosts(postService.findPostsByEmail(this.loggedUser.getEmail()));
        if (this.loggedUser.getPosts() == null)
        {
            System.out.println("creating posts list");
            List<Post> posts = new ArrayList<>();
            posts.add(new_post);
            this.loggedUser.setPosts(posts);
        }
        else
        {
            System.out.println("adding post list");
            this.loggedUser.getPosts().add(new_post);
        }
        if (this.loggedUser != null)
        {
            System.out.println("posts size= " + this.loggedUser.getPosts().size());

            for (int i = 0; i <  this.loggedUser.getPosts().size(); i++)
            {
                System.out.println("i = " + i);
                System.out.println("post = " + this.loggedUser.getPosts().get(i).getContent());
            }
        }

        postService.addPost(post);
        return "redirect:/userProfile/addPost/{checkUser}";
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
            System.out.println("result has errors log in");
            model.addAttribute("checkUser", user);
            return "redirect:/login?failure";
        }
        return "redirect:/login?success";
    }

    public String profile(){
        return "profile";
    }
}