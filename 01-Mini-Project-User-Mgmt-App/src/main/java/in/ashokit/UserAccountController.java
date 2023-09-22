package in.ashokit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entities.UserAccount;
import in.ashokit.service.UserAccountService;

@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService service;

	@GetMapping("/")
	public String index(Model model) {
//sending one empty user object to map our form to user data
		// 33.48
		model.addAttribute("user", new UserAccount());

		return "index";
	}

	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user, Model model) {
		
		String msg = service.saveOrUpdateUserAcc(user);

		model.addAttribute("msg", msg);
		// 13 sept -37 min//here we are sending empty binding object
		// so after submitting the form , ui record should be removed.
		model.addAttribute("user", new UserAccount());

		// return "redirect:/users";
		return "index";
	}

	@GetMapping("/users")
	public String getUsers(Model model) {

		List<UserAccount> userList = service.getAllUserAccounts();

		model.addAttribute("users", userList);

		return "view-users";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer id, Model model) {

		UserAccount userAcc = service.getUserAcc(id);

		model.addAttribute("user", userAcc);

		return "index";

	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer uid, Model model) {
		boolean deleteUserAcc = service.deleteUserAcc(uid);

		model.addAttribute("msg", "user record deleted");

		return "forward:/users";
	}

	@GetMapping("/update")
	public String statusUpdate(@RequestParam("id") Integer uid, @RequestParam("status") String status, Model model) {
		System.out.println("Controller -inside statusUpdate method: userid" + uid + "status" + status);
		service.updateUserAccStatus(uid, status);

		if ("Y".equals(status)) {
			model.addAttribute("msg", "User Account Activated");
		} else {
			model.addAttribute("msg", "User Account De-Activated");
		}

		return "forward:/users";
	}
}
