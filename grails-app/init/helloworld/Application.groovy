package helloworld

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

//    @Override
//    Collection<String> packageNames() {
//        super.packageNames() + ['my.additional.package']
//    }
}