Project Description

        This project pulls recipies from RecipyPoppy API and renders the dishes in html page
        
        
Build Instrutions

	Grails Application

        1) Place the project folder in any location in PC
        2) Open Eclipse. Perform import of the project into eclipse
        3) Install grails in the system and make necessary configurations in eclipse to build grails application
        4) Build the application in grails
        5) Copy the build into tomcat server. Place the build inside webapps folder. Name application as "MagicRecipe"
        6) Restart tomcat server
        
        
        UI components
        	
        1) Open magicRecipePage.html
        2) Replace webServerIp:port with tomcat web server ip and port
        3) Run the webpage from web server . Enter the dishes and find the recipies in table
        
        
        
Technologies used.


	1) Grails is used to develop back end application. This project may not need grails architecture itself . It can be handled also completely in HTML,AJAX and JSON Parser.
	   Instead we have our html page call Grails API and grails inturn calls RecipePuppy API.
	   One advantage is we can log data into grails application or persist data into our database when we call any external API via grails
	2) Ajax is used to make API request to grails. We use datatables plugin and tablesorter plugin of javascript.
	3) Grails passes json arrays to html page where we use json parser to parse the arrays.
	
	
	
	   
	
        
        
        