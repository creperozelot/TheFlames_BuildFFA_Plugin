
# The Flames | BuildFFA Plugin
Willkommen. Hier findest du das Offizielle BuildFFA Plugin von [The-Flames](https://the-flames.de). Besuche auch gerne unseren [Discord](https://dc.the-flames.de). Weitere Information und anderes findest du weiter unten.

## Wir verwenden API's

#### Core API | Primeapi - Spigot / Waterfall
Diese API Ermlöglicht es uns Viele Dinge für unser Plugin zu vereinheitlichen. Dies Bedeutet das die Coins und die Funktionen für jedes unserer Plugins gleich sind.

## Bereitstellende Funktionen der API
* Scoreboard
* Chat-Color
* Präfixe
* Coin-System
* Zusätzliche Funktionen wie z.B. die Intergration von der Party-API
```http
  GET de.primeapi
```


### Coin System
Hier findest du eine Kurze übersicht und ein Besipiel wie unser Coin System Arbeitet.
```java
[Command Executer and Classes above ...]
Player player = (Player) sender;
int coins = CoinsAPI.getInstance().getCoins(player.getUniqueId()).complete();
if (coins >= 50) {
    player.sendmessage("you have more coins then 50");
} else {
    player.sendmessage("you have less coins then 50");
}
[Other Code...]
``` 

### Placeholder

| Type | Standalone     | Description                |
| :-------- | :------- | :------------------------- |
| `Core` | `%prime_coins%` | Zeigt die Coins von einem Spieler an. |
| `Core` | `%prime_onmins%` | Anzahl der Spielminuten. |
| `Core` | `%prime_ontime_1%` | Spielzeit formatiert (4:36). |
| `Core` | `%prime_ontime_2%` | Spielzeit formatiert (4 Stunden 36 Minuten). |
| `Core` | `%prime_ontime_3%` | Spielzeit formatiert (4h 36m). |
| `Core` | `%prime_ontime_4%` | Spielzeit formatiert (4h). |
| `Clan` | `%clan_name%` | Name des Clans. |
| `Clan` | `%clan_tag%` | Clantag. |
| `Clan` | `%clan_tag_formatted%` | Clantag mit [] wenn Clan != null. |
| `Clan` | `%clan_count%` | Anzahl der Clanmember. |



## Features

- Coins Integration
- Fast alle Nachrichten sind Editier bar.
- Sonstige Feature sind noch in Entwickelung


## Authors

- [@creperozelot](https://github.com/creperozelot)


## Feedback und Bugemldung

Bei Fehlern oder Ideen erreichst du uns unter https://the-flames.de/support (Website under Maintenance), auf unserem [Discord](https://dc.the-flames.de) oder unter support@the-flames.de


## Linzenz

Keine Linzenz Angegeben


-----------------

If you find software that doesn’t have a license, that generally means you have **NO PERMISSION** from the creators ([@creperozelot](https://github.com/creperozelot)) of the software to use, modify, or share the software. Although a code host such as GitHub may allow you to view and fork the code, this does not imply that you are permitted to use, modify, or share the software for any purpose.

Your options:

* Ask the maintainers nicely to add a license. Unless the software includes strong indications to the contrary, lack of a license is probably an oversight. If the software is hosted on a site like GitHub, open an issue requesting a license and include a link to this site. If you’re bold and it’s fairly obvious what license is most appropriate, open a pull request to add a license – see “suggest this license” in the sidebar of the page for each license on this site (e.g., MIT).
* Don’t use the software. Find or create an alternative that is under an open source license.
* Negotiate a private license.

--------
Wenn du Software findest die keine Linzenz angegeben hat, meint dies Normalerweise das du **KEINE BERECHTIGUNG** von dem Jeweiligen besitzern ([@creperozelot](https://github.com/creperozelot)) hast diese zu Verwenden, zu Verändern oder zu Teilen. Wenn dieser Code auf GitHub ist darfst du sie Anschauen und Forken aber auch dies gibt dir nicht das Recht diese Software zu Verwenden, zu Verändern oder zu Teilen unter allen Umständen.

Du hast Folgende möglichkeiten:

* Frage den Betreiber ob eine Linzenz hinzugefügt werden kann, Sofern diese Software keine Offensichtlichen Programme oder Codes benutzt die ander Anwender nicht benutzen können oder dürfen. Auf Github kannst du ein issue requesting erstatten und anfragen für eine Linzenz.
* Benutze diese Software nicht.
* Verhandele eine Private Linzenz mit dem Betreiber
