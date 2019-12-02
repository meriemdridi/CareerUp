package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.AppUser;

@Remote
public interface IUserService {

	public int ajouterUser(AppUser user);

	public List<AppUser> getAllUsers();

	public void deleteUser(int UserId);
	
	public void updateUser(AppUser user); 
	
	public AppUser getUserByEmailAndPassword(String email, String password);
	
}
