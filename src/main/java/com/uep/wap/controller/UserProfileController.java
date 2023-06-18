package com.uep.wap.controller;
import com.uep.wap.configs.WebSecurityConfig;
import com.uep.wap.controller.validators.LogInFormValidation;
import com.uep.wap.controller.validators.RegistartionFormValidator;
import com.uep.wap.controller.helpers.UserLogIn;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;

import com.uep.wap.dto.UserProfileDTO;

import com.uep.wap.model.UserProfile;
import com.uep.wap.service.UserProfileService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        // ...
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
//        UserProfileDTO user = new UserProfileDTO();
        model.addAttribute("user", new UserProfileDTO());
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register")
    public String registration(@ModelAttribute("user") @Validated UserProfileDTO user, // @Valid
                               BindingResult result,
                               Model model){
        System.out.println("registration func");
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


    public void deleteUserByEmail(){
        System.out.println("registration func");
        userProfileService.deleteUserByEmail(null);
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        System.out.println("users");
        List<UserProfile> users = userProfileService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
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

//    @GetMapping(path = "/users")
//    public Iterable<UserProfile> getAllUsers(){
//        return userProfileService.getAllUsers();
//    }

//    @PostMapping(path = "/users")
//    private String addUsers(@RequestBody UserProfileDTO userProfileDTO){
//        userProfileService.addUser(userProfileDTO);
//        return "Users added!";
//    }

    // implement check the right format of email as well as password
//    private void validateEnteredData() throws SignUpExceptions {
//        if (String.valueOf(signUpFormView.getName_t()).equals(""))
//        {
//            throw new SignUpExceptions("Name field cannot be an empty string.");
//        }
//        else if (String.valueOf(signUpFormView.getSurname_t()).equals(""))
//        {
//            throw new SignUpExceptions("Surname field cannot be an empty string.");
//        }
//        else if (String.valueOf(signUpFormView.getUsername_t()).equals(""))
//        {
//            throw new SignUpExceptions("Username field cannot be an empty string.");
//        }
//        else if (String.valueOf(signUpFormView.getEmail_t()).equals(""))
//        {
//            throw new SignUpExceptions("Email field cannot be an empty string.");
//        }
//        else if (String.valueOf(signUpFormView.getPassword_t()).equals("")
//                || String.valueOf(signUpFormView.getPassword_t()).length() < 8)
//        {
//            throw new SignUpExceptions("Password field is empty or less than 8 characters.");
//        }
//    }
//    private void signUp()
//    {
//        UserProfileDTO userProfileDTO = new UserProfileDTO();
//        userProfileDTO.setName(String.valueOf(signUpFormView.getName_t()));
//        userProfileDTO.setSurname(String.valueOf(signUpFormView.getSurname_t()));
//        userProfileDTO.setUsername(String.valueOf(signUpFormView.getUsername_t()));
//        userProfileDTO.setEmail(String.valueOf(signUpFormView.getEmail_t()));
//        userProfileDTO.setPassword(String.valueOf(signUpFormView.getPassword_t()));
//
//        addUsers(userProfileDTO);
//    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String command = e.getActionCommand();
//        if (command.equals("Sign up"))
//        {
//            try {
//                validateEnteredData();
//            } catch (SignUpExceptions ex) {
//                throw new RuntimeException(ex);
//            }
//            signUp();
//        }
//        else if (command.equals("Exit"))
//        {
//            exitSignUpForm();
//        }
//    }

//    @PostMapping(path = "/students")
//    public String updateStudents(StudentDTO studentDTO){
//        Student student = studentRepository.findById(studentDTO.getId()).get();
//
//        studentsService.addStudent(studentDTO);
//        return "Students added!";
//    }

}