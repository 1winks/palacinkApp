package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projektr.backend.domain.Korisnik;
import projektr.backend.service.KorisnikService;
import java.util.List;
import static org.springframework.security.core.authority.AuthorityUtils.NO_AUTHORITIES;
import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Service
public class KorisnikUserDetailsService implements UserDetailsService {
    @Value("${opp.admin.password}")
    private String adminPasswordHash;

    @Autowired
    private KorisnikService korisnikService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new User(username, adminPasswordHash, authorities(username));
    }

    private List<GrantedAuthority> authorities(String username) {
        if ("admin".equals(username))
            return commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        return NO_AUTHORITIES;
    }
}
