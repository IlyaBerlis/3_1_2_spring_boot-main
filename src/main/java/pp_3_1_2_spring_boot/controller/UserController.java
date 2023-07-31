package pp_3_1_2_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp_3_1_2_spring_boot.entity.User;
import pp_3_1_2_spring_boot.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String users(Model model) {
        List<User> users = userServiceImpl.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable(value = "id") long id, Model model) {
        User user = userServiceImpl.getUserById(id);
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
        userServiceImpl.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User updateUser){
        User user = userServiceImpl.getUserById(id);

        if (user == null){
            return "redirect:/";
        }

        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setAge(updateUser.getAge());
        user.setSex(updateUser.getSex());

        userServiceImpl.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        User user = userServiceImpl.getUserById(id);

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userServiceImpl.removeUser(id);
        return "redirect:/";
    }

    @RequestMapping("/favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}