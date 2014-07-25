package recipesample;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;




import groovyx.net.http.*;
import static groovyx.net.http.ContentType.*;
import grails.rest.*

class MagicRecipeController {

	static def postText(String baseUrl, String path, query, method = Method.POST) {
		try {
			def ret = null
			def http = new HTTPBuilder(baseUrl)

			// perform a POST request, expecting TEXT response
			http.request(method, ContentType.TEXT) {
				uri.path = path
				uri.query = query
				headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

				// response handler for a success response code
				response.success = { resp, reader ->
					println "response status: ${resp.statusLine}"
					println 'Headers: -----------'
					resp.headers.each { h ->
						println " ${h.name} : ${h.value}"
					}

					ret = reader.getText()

					println 'Response data: -----'
					println ret
					println '--------------------'
				}
			}
			return ret

		} catch (groovyx.net.http.HttpResponseException ex) {
			ex.printStackTrace()
			return null
		} catch (java.net.ConnectException ex) {
			ex.printStackTrace()
			return null
		}
	}

	static def getText(String baseUrl, String path, query) {
		return postText(baseUrl, path, query, Method.GET)
	}

	
    def index() { 
		
		
		try
		{
			log.debug("Request to get the recipe arrived with params ${params}")
			def url = "http://www.recipepuppy.com"
			def path = "/api/"
			def ingredients=params.ingredients;
			def recipe=params.recipe
			def query = [ i: ingredients, q: recipe ]			
			// Submit a request via GET
			def response = getText(url, path, query)				
			log.debug("Successfully received json list of recipies ${response}")		
			render(response);
			//render('<error>-1</error>')
			//return (data);
		}
		catch(Exception e)
		{
			render ("{}")
		}
			
	}
}
