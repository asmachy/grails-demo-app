package demoapp

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class CustomUserDetails extends GrailsUser {

   final String firstname, lastname, address, phone, email, fullname
   final Date birthdate

   CustomUserDetails(String username, String password, boolean enabled,
                 boolean accountNonExpired, boolean credentialsNonExpired,
                 boolean accountNonLocked,
                 Collection<GrantedAuthority> authorities, long id,
                 String firstname, String lastname, String address, String phone, String email, String fullname, Date birthdate) {
      super(username, password, enabled, accountNonExpired,
            credentialsNonExpired, accountNonLocked, authorities, id)

      this.firstname = firstname
      this.lastname = lastname
      this.address=address
      this.phone=phone
      this.email=email
      this.fullname=fullname
      this.birthdate=birthdate

   }

}
