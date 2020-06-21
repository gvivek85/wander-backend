package com.dev.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.dev.config.model.UserPrincipal;
import com.dev.entity.Authority;
import com.dev.entity.Roles;
import com.dev.entity.User;
import com.dev.repository.UserRepository;

/**
 * User Service Class
 * @author Vivek Gupta
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Method to load the User authorities
	 */
	@Override
	public UserPrincipal loadUserRolesAuthorities(User user) {
		UserPrincipal userPrincipal = null;
		if(user.getIsActive()){
			if (user.getRoles() != null) {
				List<GrantedAuthority> authoritiesNames = (List<GrantedAuthority>) getAuthorities(user.getRoles());			
				userPrincipal = new UserPrincipal(user.getId(), user.getFirstName(), user.getUsername(), user.getEmail(),
						user.getPassword(), authoritiesNames);
			}
		}
		return userPrincipal;
	}
	
	/**
	 * Method to get Authorities from the list of Roles Object
	 * @param roles
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Roles> roles) {
		return getGrantedAuthorities(getPrivileges(roles));
	}
	
	/**
	 * Methof to iterate the Roles Collection and return the String Authorities
	 * @param roles
	 * @return
	 */
	private List<String> getPrivileges(Collection<Roles> roles) {
		List<String> privileges = new ArrayList<>();
		List<Authority> collection = new ArrayList<>();
		for (Roles role : roles) {
			if(role.getIsActive()){
				collection.addAll(role.getAuthorities());
			}
		}
		if (collection != null && !collection.isEmpty()) {
			privileges = collection.stream().filter(authority-> authority.getIsActive() )
					.map(authority ->authority.getName()).collect(Collectors.toList());
			Set<String> set = new HashSet<>(privileges);
			privileges.clear();
			privileges.addAll(set);
		}
		return privileges;
	}
	/**
	 * Method to retrieve the granted authorities from the Privileges of the Users
	 * @param privileges
	 * @return
	 */
	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (privileges != null && !privileges.isEmpty()) {
			authorities = privileges.stream().map(authorityName ->new SimpleGrantedAuthority(authorityName)).collect(Collectors.toList());
		}
		return authorities;
	}
	
	/**
	 * Method to find user by username
	 */
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	/**
	 * Method to get the list of all users in the system
	 */
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	
	/**
	 * Method to update the User in database
	 */
	public User updateUser(User user) {
		return userRepository.save(user);
	}
}
