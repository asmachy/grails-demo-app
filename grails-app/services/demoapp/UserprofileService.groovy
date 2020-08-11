package demoapp

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(User)
@Transactional
interface UserprofileService {

    User get(Serializable id)
}
