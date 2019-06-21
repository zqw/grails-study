package helloworld

import org.springframework.beans.factory.annotation.Value

class HelloController {

    HelloService helloService

    def index() {
        String testTxt = "Hello";
        render testTxt
    }

    def contextPath() {
        def contextPath = helloService.getContextPath();
        render "Hello ${contextPath}"
    }

    def greeting() {
        def recipient = helloService.greeting();
        render "Hello ${recipient}"
    }

    @Value('${server.contextPath}')
    String recipient2

    def hello() {
        render "Hello ${recipient2}"
    }

}
