package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import in.ashokit.entities.UserAccount;
@Service
public interface UserAccountService {
	//insert and update
	public String saveOrUpdateUserAcc(UserAccount userAcc);
	//view records
	public List<UserAccount> getAllUserAccounts();
	//edit records
	public UserAccount getUserAcc(Integer userId);
	//delete
	public boolean deleteUserAcc(Integer userId);
	//status
	public boolean updateUserAccStatus(Integer userId,String status);

}
