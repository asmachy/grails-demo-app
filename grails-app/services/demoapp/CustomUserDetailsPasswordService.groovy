package demoapp


import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsPasswordService
import org.springframework.security.provisioning.UserDetailsManager

class CustomUserDetailsPasswordService implements UserDetailsPasswordService{

    private final User user;
//    private final UserDetailsMapper userDetailsMapper;
    UserDetailsManager userDetailsManager

    def serviceMethod() {
        userDetailsManager.updateUser()

    }

    @Override
    UserDetails updatePassword(UserDetails user, String newPassword) {
        return null
    }
}
