# 💡 Hilfestellungen für den Workshop

## **Allgemeine Tipps & Tricks**

- **Schrittweise vorgehen:** Starte mit dem Testen einzelner Methoden, bevor du ganze Komponenten angehst.
- **Kontext bereitstellen:** Beschreibe, was die Methode/Klasse tut und welche Randbedingungen zu testen sind.
- **Nach Testideen fragen:** "`Welche kritischen Testfälle sollte ich für BookService.java abdecken?`"
- **Teste auch Fehlerfälle:** Lass KI Szenarien vorschlagen, bei denen bewusste Fehler auftreten sollten.
- **Dokumentiere Tests gut lesbar:** Testmethoden sinnvoll benennen (`shouldThrowException_forInvalidPrice`).
- **Fasse abgedeckte und nicht abgedeckte Stellen zusammen:** Lass dir auflisten, wo noch Tests fehlen könnten.

---

## Beispiel-Prompts – Datei für Datei

### **Controller**

- `Welche Unittestfälle sollte ich für BookController.java schreiben?`
- `Wie kann ich Fehlerfälle im SeriesController (z.B. ungültige ID) testen? Bitte Beispielcode.`

### **Service**

- `Welche Rand- und Ausnahmefälle sollte ich für PriceCalculator.java testen?`
- `Generiere Testdatensätze, um die Methode calculateSeriesPrice robust zu testen.`

### **Repository**

- `Welche Datenbank-Edge-Cases sollte ich im SeriesRepository testen (z.B. leere Ergebnisse, fehlerhafte Abfragen)?`
- `Schreibe einen Test, der prüft, ob filterBooks korrekt nach Genre filtert.`

### **DTO/Model**

- `Wie stelle ich sicher, dass die Datenklassen (BookDTO, SeriesDTO) korrekt serialisiert und deserialisiert werden? Bitte Unit-Test-Beispiel.`
- `Welche Validation-Tests sind für das Modell (Book.java) sinnvoll?`

---

## **Prompts für übergreifende Test-Abdeckung**

- `Analysiere das gesamte Projekt und gib eine Liste aller Klassen/Methoden, die noch keine oder unzureichende Tests haben.`
- `Schlage vor, wie ich die Testabdeckung im Bereich x (z.B. Service-Layer) gezielt erhöhen kann – bitte mit Testfallideen.`
- `Welche typischen Fehlerquellen könnten ungetestet bleiben und wie kann ich sie automatisiert abdecken?`
- `Erstelle einen Überblick aller Edge Cases, die im Projekt getestet werden sollten.`
