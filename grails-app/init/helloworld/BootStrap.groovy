package helloworld

import javax.servlet.ServletContext

class BootStrap {
//
//    def init = { servletContext ->
//    }

    def init = { ServletContext ctx ->
        environments {
            production {
                ctx.setAttribute("env", "prod")
            }
            development {
                ctx.setAttribute("env", "dev")
            }
        }
        ctx.setAttribute("foo", "bar")
    }

    def destroy = {
    }
}
