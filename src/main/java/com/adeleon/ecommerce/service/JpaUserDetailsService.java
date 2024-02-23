package com.adeleon.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.adeleon.ecommerce.model.User;
import com.adeleon.ecommerce.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = repository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema!", username));
        }

        User user = userOptional.orElseThrow();

        //GrantedAuthority.
        List<GrantedAuthority> authorities =  Stream.of(user.getRole())
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        org.springframework.security.core.userdetails.User userDetail;
        userDetail = new org.springframework.security.core.userdetails.User(user.getUsername(),
               user.getPassword(),
               user.isEnabled(),
               true,
               true,
               true,
               authorities);

        return userDetail;
    }

}
