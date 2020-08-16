package demoapp
import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import demoapp.User
import demoapp.Role
import demoapp.UserRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationTrustResolver

import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
@Secured('permitAll')
class RegisterController {

    def springSecurityService
    GregorianCalendar birthdate
    static allowedMethods = [register: "POST"]
    def index() {
        if (springSecurityService.isLoggedIn()) {
            redirect controller: 'user'
        }
    }

    def register() {

        if(!params.password.equals(params.repassword)) {
            flash.message = "Password and Re-Password not match"
            redirect action: "index"
            return
        } else {
            try {
                String flashmsg="You have registered successfully. Please login."
                def user
                def yearbirthdate = Integer.parseInt(params.yearbirthdate)
                def monthbirthdate = Integer.parseInt(params.monthbirthdate)
                def daybirthdate = Integer.parseInt(params.daybirthdate)

                birthdate = new GregorianCalendar(yearbirthdate, monthbirthdate-1, daybirthdate)
                def fullname = params.firstname + ' ' + params.lastname
                if(User.findByUsername(params.username)){
                    flash.message = "Email is not Available.\n Already have an Account? Please login."
                    redirect controller: "login", action: "auth"
                    return

                } else {
                    user = User.findByUsername(params.username) ?: new User(username: params.username, password: params.password,
                            firstname: params.firstname, lastname: params.lastname, address: params.address, phone: params.phone,
                            email: params.username, fullname: fullname, birthdate: birthdate, age: 0).save()
                }

                def role = Role.get(params.role.id)
                if(user && role) {
                    UserRole.create user, role

                    UserRole.withSession {
                      it.flush()
                      it.clear()
                    }

                    flash.message = flashmsg
                    redirect controller: "login", action: "auth"
                    return
                } else {
                    flash.message = "Register failed"
                    render view: "index"
                    return
                }
            } catch (ValidationException e) {
                flash.message = "Register Failed"
                redirect action: "index"
                return
            }
        }
    }
}
