package demoapp

import demoapp.CustomUserDetails
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.junit.Test
import org.springframework.security.core.context.SecurityContextHolder
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.userdetails.GrailsUser
import grails.plugin.springsecurity.SpringSecurityService
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.PreInsertEvent
import org.grails.datastore.mapping.engine.event.PreUpdateEvent
import org.springframework.beans.factory.annotation.Autowired
import grails.events.annotation.gorm.Listener
class UserController {
    static allowedMethods = [save: "POST", update: "PUT"]
    CustomUserDetails userDetails
    User currentUser
    @Autowired
    SpringSecurityService springSecurityService
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() {

        if (!springSecurityService.isLoggedIn()) {
            redirect controller: 'login'
            return
        } else {
            userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
            respond userDetails
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit() {
        if (!springSecurityService.isLoggedIn()) {
            redirect controller: 'login'
            return
        } else {
            userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
            respond userDetails
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update_password() {
        userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        currentUser = User.findByUsername(userDetails.getUsername())
            if(params.newpassword != params.newrepassword ) {
                flash.message = "Password and Re-Password Did not Match!"
                render view: "edit"
                return
            } else {
                flash.message = "The Feature is Not Available Now!"
                render view: "edit"
                return
            }

    }
    @Secured(['ROLE_ADMIN'])
    def list() {
        if (!springSecurityService.isLoggedIn()) {
            redirect controller: 'login'
            return
        } else {
            userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
            respond userDetails
            for(User user : User.list())
            {
                user.setAge()
            }
            render(view: "list", model: [userList : User.list()])

        }

    }
    @Secured(['ROLE_ADMIN'])
    def searchlist() {
        def users = User.findAllByFullnameIlike("%"+params.search+"%")
        for(User user : users)
        {
            user.setAge()
        }
        render(view: "list", model: [userList : users])
    }

}
