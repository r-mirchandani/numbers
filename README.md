# numbers-to-words
Java application to convert positive numbers to word form. Built using gradle wrappers.

Build using './gradew build', subsequently run server with './gradew run'.

Once server is running, navigate to http://localhost:8080/ to use the application.

Numbers larger than int32.maxValue (2,147,483,647) are not accepted. Inputs with 2 decimal places are preferred, but the application will correct for this if only a single or no decimals are provided.
