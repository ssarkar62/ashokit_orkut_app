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
	public String index(Model model)
	{
//sending one empty user object to map our form to user data
		//33.48
		model.addAttribute("user",new UserAccount());
		
		return "index";
	}
	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user, Model model) {
		
		String msg = service.saveOrUpdateUserAcc(user);
		
		model.addAttribute("msg",msg);
		
	
		return "index";
	}
	@GetMapping("/users")
	public String getUsers(Model model) {
		
		List<UserAccount> userList = service.getAllUserAccounts();
		
		model.addAttribute("users", userList);
		
		return "view-users";
	}
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer id , Model model) {
		
		UserAccount userAcc = service.getUserAcc(id);
		
		model.addAttribute("user" , userAcc);
		
		return "index";
	
	}
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id")Integer uid)
	{
		boolean deleteUserAcc = service.deleteUserAcc(uid);
		
		
		return "redirect:/users";
	}
	@GetMapping("/update")
	public String statusUpdate(@RequestParam("id")Integer uid , @RequestParam("status") String status)
	{
		System.out.println("Controller -inside statusUpdate method: userid"+uid+"status"+status);
		service.updateUserAccStatus(uid, status);
		return "redirect:/users";
	}
}
