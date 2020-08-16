package demoapp

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class CustomUserDetails extends GrailsUser {

   final String firstname, lastname, address, phone, email, fullname
   final String birthdate
   String[] months = ["January", "February", "March", "April", "May", "June","July","August","September","October","November","December"]
   CustomUserDetails(String username, String password, boolean enabled,
                 boolean accountNonExpired, boolean credentialsNonExpired,
                 boolean accountNonLocked,
                 Collection<GrantedAuthority> authorities, long id,
                 String firstname, String lastname, String address, String phone, String email, String fullname, GregorianCalendar birthdate) {
      super(username, password, enabled, accountNonExpired,
            credentialsNonExpired, accountNonLocked, authorities, id)

      this.firstname = firstname
      this.lastname = lastname
      this.address=address
      this.phone=phone
      this.email=email
      this.fullname=fullname

      def s
      if(birthdate.get(Calendar.DATE)==1)
         s = "st"
      else if(birthdate.get(Calendar.DATE)==2)
         s = "nd"
      else if(birthdate.get(Calendar.DATE)==3)
         s = "rd"
      else
         s ="th"
      this.birthdate = String.valueOf(birthdate.get(Calendar.DATE))+ s + " "+months[birthdate.get(Calendar.MONTH)]+", "+String.valueOf(birthdate.get(Calendar.YEAR))


   }

}
