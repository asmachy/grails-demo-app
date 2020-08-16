package demoapp

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(User)
@Transactional
interface UserService {

    User get(Serializable id)
}
