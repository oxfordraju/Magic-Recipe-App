// Place your Spring DSL code here
import grails.rest.render.json.*
import org.codehaus.groovy.grails.web.mime.*

beans = {
	
	rest(grails.plugins.rest.client.RestBuilder)
}
