package helloworld

import grails.core.GrailsApplication
import grails.core.support.GrailsConfigurationAware
import grails.gorm.services.Service
import grails.config.Config
import org.springframework.beans.factory.annotation.Value;

@Service(Book)
class HelloService implements GrailsConfigurationAware {

    String recipient
    void setConfiguration(Config config) {
        recipient = config.getProperty("server.contextPath")
    }

    GrailsApplication grailsApplication

    String getContextPath (){
        def contextPath = grailsApplication.config.getProperty('server.contextPath')

        return "Hello ${contextPath}"
    }

    String greeting() {
        return "Hello ${recipient}"
    }




}