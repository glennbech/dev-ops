## Eksamen i DevOps

##### Hovedfokuset mitt har ikke vært å lage en avansert eller ordentlig applikasjon, derfor viser den minimalt, men er samtidig innholdsrik nok til å demonstrere de DevOps-prinsippene jeg har gjort.  

##### Oppgave 1
##### I denne oppgaven har jeg koblet opp GCP sammen med travis for å gjøre det slik at hver gang jeg gjør en endring og pusher til github så lager travis et docker image av applikasjonen og laster det opp i GCP i container registry. 
##### Dette har jeg gjort ved hjelp av docker-multistage build som vi lærte i dette emnet. For å få til dette har jeg kryptert google service account nøklene med travis encrypt i shellet for å gi hemmeligheter til travis. Deretter har jeg lagt til openssl outputen jeg har fått og lagt det inn i travis filen. 

##### Oppgave 2 
##### I denne oppgaven fikk jeg en del problemer med å koble opp influxdb sammen med prosjektet, og hoppet over den i første omgang for så å komme tilbake til den hvis jeg fikk tid til overs. 

##### Oppgave 3 
##### I denne oppgaven har jeg gjort det slik at det blir lest logger til logz.io og i consollen når man kjører applikasjonen. For å gjøre det i henhold til twelve factor app prinsippet så har jeg ikke lagt inn log.io token i logback filen men kryptert det og lagt det til som variabel i infrastruktur repoen min. Så ingen kan bruke tokenet mitt bombadere meg med logger. Kunne forsåvidt gjort det med logz urlen også men siden det ble nevnt i timen at den har vært det samme en god stund nå så lot jeg det være. 

