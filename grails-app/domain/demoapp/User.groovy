package demoapp

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String firstname
    String lastname
    String address
    String phone
    String email
    String fullname

    Long age

    GregorianCalendar birthdate
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        address nullable: false, blank: false
        phone nullable: false, blank: false
        firstname nullable: false, blank: false
        lastname nullable: false, blank: false
    }

    void setAge(){
        def nowdate = new GregorianCalendar()
        if(nowdate.get(Calendar.MONTH)>=birthdate.get(Calendar.MONTH) && nowdate.get(Calendar.DATE)>= birthdate.get(Calendar.DATE) )
            this.age = nowdate.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR)
        else
            this.age = nowdate.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR)-1

    }

    static mapping = {
	    password column: '`password`'
    }
}
