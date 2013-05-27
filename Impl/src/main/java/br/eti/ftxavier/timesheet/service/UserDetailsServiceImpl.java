package br.eti.ftxavier.timesheet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.eti.ftxavier.timesheet.model.Role;
import br.eti.ftxavier.timesheet.model.Usuario;

@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario usuario = null;
		try {
			usuario = this.usuarioService.getUsuarioByLogin(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		} else {
			List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
			for(Role role : usuario.getRoles()) {
				roleList.add(new SimpleGrantedAuthority(role.getName()));				
			}
			
			UserDetails userDetails = new User(usuario.getLogin(),
					usuario.getPassword(), usuario.isEnabled(),
					usuario.isAccountNonExpired(),
					usuario.isCredentialsNonExpired(),
					usuario.isAccountNonLocked(), roleList);
			return userDetails;			
		}
	}

}
