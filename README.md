﻿things to add...

Feature: Datumsausgabe formatieren:
         Das Datum auf dem Beleg wird derzeit im Format "yyyy-mm-dd" angezeigt.
         Der Programmierer erstellt eine Methode localDateFormat() und erstellt ein Patern nach
         folgendem Schema: "dd.mm.yyyy"

Feature: Ausgabe formatieren

Feature: Der Programmierer erstellt eine Methode bestandskontenAbschließen().
         In die Bestandskonten wird ein Schlussbestand sowie jeweils ein Saldo für die Soll- u. Haben-Seite integriert.
Feature: Der Programmierer erstellt die Methode kontenPruefen(), welche die beiden Salden auf Gleichheit prüft.
         Die Methode gibt eine Feedback.
Feature: Der Programmierer erstellt eine Methode erfolgskontenAbschließen().
         In die Erfolgskonten wird ein Schlussbestand (Gegenkonto GuV) sowie jeweils ein Saldo für die Soll- u.
         Haben-Seite integriert.

Feature: Monatsabschluss:
         Der Programmierer erstellt eine Methode monatsabschluss(), welche die kontenabschließenden Methoden aufruft.
                         
Feature: Jahresabschluss

Feature: USt berechnen

Feature: Bibliothek SKR04 (Standardkontenrahmen 04) integrieren.
         Der Programmierer muss eine Bibliothek für Standardkonten in die Projektstruktur integrieren.
Feature: In der Kontoverwaltung kann der Benutzer der Software individuell
         seine zu nutzenden Konten aus der Kontenbibliothek auswählen.
         Die individuelle Liste wird dann erstellt.
Feature: Der Benutzer kann nachträglich weitere Konten aus der Kontenbibliothek in seine zu
         nutzende Kontenliste integrieren.

Feature: Buchen mit Umsatzsteuer.
         Bei der Kontenwahl gibt es bei den Aufwands- u. Ertragskonten kombinierte Konten.
         Umsetzung: Präfix + KontoId ODER angepasste KontoId
         Durch diese Automatik fällt die extra Buchung der Vorsteuer u. Umsatzsteuer weg.
         Gebucht wird nur noch auf das Aufwands- od. Ertragskonto und die überladene Methode buchen(int Präfix)
         bucht selbständig die Steuer auf die entsprechenden Konten.

Feature: Digitale Eingangsrechnung im Pdf-Format.
         Der Programmierer integriert bspw. die IText Bibliotheken zum Parsen von Pdf-Dateien.