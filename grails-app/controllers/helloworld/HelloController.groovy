package helloworld

import groovy.xml.MarkupBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.servlet.ModelAndView

import javax.servlet.ServletContext

class HelloController {

    HelloService helloService
    ServletContext servletContext

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

    @Value('${foo}')
    String theFoo

    def foo() {
        render "Hello ${servletContext.getAttribute('env')}"
    }

    def motest(){
//        return new ModelAndView("/book/show", [lable: "label" ])

        def map =  [lable: "label" ]
        render(view: "/book/show", model: map)
    }

    def xxmmll(){
        def books = [
                [id:"id1", title:"title1"],
                [id:"id2", title:"title2"],
        ]
        render(text: "<xml>some xml</xml>", contentType: "text/xml", encoding: "UTF-8")

//        render {
//            for (b in books) {
//                div(id: b.id, b.title)
//            }
//        }
    }

    def login() {
        if (!session.user)
            redirect(action: 'nologin')
        return
    }


    def nologin() {
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.html {
            head {
                title 'no login'
            }
            body {
                h1 'no login'
                form {
                }
            }
        }

        def html = writer.toString()
        render html
    }


    def tt(){
        Book book = new Book(name: "book123");
        redirect book
    }

}
