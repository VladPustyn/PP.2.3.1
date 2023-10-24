package web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }


    @GetMapping("show")
    public String show(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("update")
    public String update(@RequestParam(name = "id") int id, @ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("delete")
    public String delete(@RequestParam(name = "id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
