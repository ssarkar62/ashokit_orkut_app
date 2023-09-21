package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entities.UserAccount;
import in.ashokit.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepo userAccRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {

		Integer userId = userAcc.getUserid(); // UPSERT (insert or update)
		userAccRepo.save(userAcc);

		if (userId == null) {
			return "User Record Saved";
		} else {
			return "User Record Updated";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {

		// List<UserAccount> accounts = userAccRepo.findAll();
		// return accounts;

		return userAccRepo.findAll();

	}

	@Override
	public UserAccount getUserAcc(Integer userId) {

		Optional<UserAccount> findById = userAccRepo.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {

		try {
			userAccRepo.deleteById(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean existsById = userAccRepo.existsById(userId);
		if (existsById) {
			userAccRepo.deleteById(userId);
			return true;
		}
		return false;

	}

	/*
	 * @Override public boolean updateUserAccStatus(Integer userId, String status) {
	 * // TODO Auto-generated method stub return false; }
	 */

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		System.out.println("ServiceImpl-inside updateUserAccStatus method: userId"+userId+"status"+status);
		try {
			userAccRepo.updateUserAccStatus(userId, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
