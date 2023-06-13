package com.uep.wap.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uep.wap.dto.UserProfileDTO;

import com.uep.wap.model.UserProfile;
import com.uep.wap.service.UserProfileService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
//@RequestMapping(path = "/api")
public class UserProfileController {

    private final UserProfileService userProfileService;

//    private  UserProfileDTO userProfileDTO;

//    private SignUpFormView signUpFormView;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // handler method to handle home page request
//    @GetMapping("/index")
//    public String home(){
//        return "index";
//    }

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
    public String registration(@Valid @ModelAttribute("user") UserProfileDTO user, // @Valid
                               BindingResult result,
                               Model model){
        System.out.println("registration func");
        System.out.println("userProfileDTO: " + user.getId() + ", " + user.getName()
                + ", " + user.getSurname());
        UserProfile existingUser = userProfileService.findUserByEmail(user.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }

        userProfileService.addUser(user);
//        return "successSignedUp";
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
    public String login(){
        return "login";
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