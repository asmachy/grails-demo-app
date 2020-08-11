package demoapp

import demoapp.CustomUserDetails
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

class ProfileController {
    static allowedMethods = [save: "POST", update: "PUT"]
    CustomUserDetails userDetails= SecurityContextHolder.getContext().getAuthentication().getPrincipal()

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() {

        respond userDetails

    }
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit() {
        respond userDetails
    }
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def profile() {
        if(!params.newpassword.equals(params.newrepassword)) {
            flash.message = "Password and Re-Password not match"
            redirect action: "edit"
            return
        } else {

                flash.message = "The Feature is not Yet Enabled!"
                redirect action: "edit"
                return

        }
    }

}
