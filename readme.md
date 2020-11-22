## Eksamen i DevOps

##### Hovedfokuset mitt har ikke vært å lage en avansert applikasjon, derfor viser den minimalt, men er samtidig innholdsrik nok til å demonstrere de DevOps-prinsippene jeg har gjort.  

##### Oppgave 1
##### I denne oppgaven har jeg koblet opp GCP sammen med travis for å gjøre det slik at hver gang jeg gjør en endring og pusher til github så lager travis et docker image av applikasjonen og laster det opp i GCP i container registry. 
##### Dette har jeg gjort ved hjelp av docker-multi-stage build som vi lærte i dette emnet. For å få til dette har jeg kryptert google service account nøklene med travis encrypt i shellet for å gi hemmeligheter til travis. Deretter har jeg lagt til openssl outputen jeg har fått og lagt det inn i travis filen. Siden jeg benyttet meg av windows, måtte jeg bruke linux shell for å kryptere nøklene. Kommandoen jeg kjørte var først travis login --pro, for å logge inn på travis. Så lagde jeg meg service account osv i GCP, lastet ned JSON nøklene for service accounten også kjørte: travis encrypt-file google-key.json. Samme kommandoen brukte jeg når jeg krypterte nøkler/token for feks Logz.io og Statuscake. 

##### Oppgave 2 
##### I denne oppgaven fikk jeg en del problemer med å koble opp influxdb sammen med prosjektet, og hoppet over den i første omgang for så å komme tilbake til den hvis jeg fikk tid til overs. Her har jeg addet dependencyene som trengs og laget meg en databse, men ikke fått implementert det i koden. 
##### Oppgave 3 
##### I denne oppgaven har jeg gjort det slik at det blir lest logger til logz.io og i consollen når man kjører applikasjonen. For å gjøre det i henhold til twelve factor app prinsippet så har jeg ikke lagt inn log.io token i logback filen men kryptert det og lagt det til som variabel i infrastruktur repoen min. Så ingen kan bruke tokenet mitt bombadere meg med logger. Kunne forsåvidt gjort det med logz urlen også men siden det ble nevnt i timen at den har vært det samme en god stund nå så lot jeg det være. La inn LOG.info i noen av controllerne mine for å vise at det blir skrevet ut logger. 
