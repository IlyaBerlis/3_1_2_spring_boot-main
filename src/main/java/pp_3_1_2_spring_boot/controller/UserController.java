package pp_3_1_2_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp_3_1_2_spring_boot.entity.User;
import pp_3_1_2_spring_boot.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User updateUser){
        User user = userService.getUserById(id);

        if (user == null){
            return "redirect:/";
        }

        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setAge(updateUser.getAge());
        user.setSex(updateUser.getSex());

        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}