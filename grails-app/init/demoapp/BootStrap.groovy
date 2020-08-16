package demoapp

import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.beans.factory.annotation.Autowired
import grails.util.Environment
import java.text.DateFormat
import java.text.SimpleDateFormat

class BootStrap {
    GregorianCalendar birthdate1 = new GregorianCalendar(1980, 3, 15)
    GregorianCalendar birthdate2 = new GregorianCalendar(1981, 9, 15)
    GregorianCalendar birthdate3 = new GregorianCalendar(1979, 7, 11)


    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()
        def userRole1 = userRole

        switch (Environment.current) {
            case Environment.DEVELOPMENT:

                def admin = new User(username: "guilizzoni@bitmascot.com", password: "guilizzoni12",
                        firstname: "Giacomo", lastname: "Guilizzoni", address: "Dhaka, Bangladesh", phone: "+8801666666666",
                        email: "guilizzoni@bitmascot.com", fullname: "Giacomo Guilizzoni", birthdate: birthdate1, age: 20).save()
                UserRole.create(admin, adminRole).save()
                def user1 = new User(username: "marco@bitmascot.com", password: "marco12",
                        firstname: "Marco", lastname: "Botton", address: "Khulna, Bangladesh", phone: "+8801666666666",
                        email: "marco@bitmascot.com", fullname: "Marco Botton", birthdate: birthdate2, age: 20).save()
                UserRole.create(user1, userRole).save()

                def user2 = new User(username: "maria@bitmascot.com", password: "maria12",
                        firstname: "Maria", lastname: "Mason", address: "Chattogram, Bangladesh", phone: "+8801666666666",
                        email: "maria@bitmascot.com", fullname: "Maria Mason", birthdate: birthdate3, age: 10).save()
                UserRole.create(user2, userRole).save()
                def user3 = new User(username: "test@test.com", password: "test12",
                        firstname: "Test", lastname: "Test", address: "Test", phone: "+8801666666666",
                        email: "test@test.com", fullname: "Test Test", birthdate: birthdate3, age: 10).save()
                UserRole.create(user3, userRole).save()
                break
            case Environment.PRODUCTION:
                break
        }

    }
    def destroy = {

    }
}
