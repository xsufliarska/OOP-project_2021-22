# OOP-project_2021-22
Lujza Šufliarska

# Hlavné kritériá
## Dedenie
Dedenie je použité hlavne pri controlleroch v GUI, pretože sa v každom z nich nachádza rovnaké menu.

## Polymorfizmus
Polymorfia je využitá hlavne pri interfacey pre rôzne typy aukcií, keďže sa jedná o veľmi podobné funkcie.

## Zapuzdrenie
Zapuzdrenie sa využíva napríklad v triede User, kde sú private premenné, ku ktorým je prístup pomocu getterov a setterov.

## Agregácia
Využitie agregácie je napríklad pri Userovi, ktorý má vlastnú peňaženku (Wallet).

## Oddelenie aplikačnej logiky od používateľského rozhrania
Projekt je rozdelený do niekoľkých packageov. Package controllers obsahuje všetky triedy spojené s GUI a jeho funkcionalitou (hlavne reakcia tlačidiel). V balíku main sú uložené všetky ostatné triedy, ktoré zabezpečujú logiku aplikácie.

# Návrhové vzory
### Listener
Okrem strategy je tu aplikovaný aj návrhový vzor listener. Mimo GUI je použitý v návrhovom vzore strategy, v triedach EnglishAuctionSetup a FPSB_AuctionSetup.

### Strategy
Návrhový vzor strategy je použitý pre vytváranie rôznych druhov aukcií. Triedy k tomuto  návrhovému vzoru sú: 
•	AuctionSetup
•	EnglishAuctionSetup
•	FPSB_AuctionSetup
•	JapaneseAuctionSetup
•	Auction

## Handler
Manuálne vytvorené handlery sa nachádzajú mimo GUI napríklad v triedach EnglishAuctionSetup a FPSB_AuctionSetup.

## Multithreading
Viacniťovosť je využitá pri časovačoch v aukciách. Triedy EnglishAuctionSetup a FPSB_AuctionSetup.

## Lambda
Lambda výrazy je možné nájsť napríklad v triede EnglishAuctionSetup a FPSB_AuctionSetup.

## Serializácia
Všetky potrebné údaje sú ukladané do „.txt“ súborov, z ktorých sú následne aj čítané. Všetky triedy určené na serializáciu sú uložené v balíku main.serialize.
