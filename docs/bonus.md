## Bonusaufgabe: Parametrisierte Tests

Nutze JUnit5 parameterized tests, um eine Kernfunktion wie die Validierungen im `BookService` mit verschiedenen Eingabedaten kompakt und systematisch zu testen.

**Ziel:**  
Stelle sicher, dass deine Logik mit unterschiedlichen Eingabewerten zuverlässig und korrekt funktioniert.

**Typische Testfälle (Beispiele):**
- Die Validierung für das Anlegen eines Buchs schlägt bei ungültigen Daten fehl (z.B. leerer Titel, negativer Preis).

**Vorgehen:**  
Definiere eine parameterisierte Testmethode und stelle verschiedene Testdatensätze zur Verfügung (z.B. als Methodenquelle oder CSV). Überprüfe, ob das erwartete Ergebnis mit dem tatsächlichen Resultat übereinstimmt.

---

## Bonusaufgabe: Integrationstests

Schreibe einen oder mehrere Integrationstests für deine REST-API, die das Zusammenspiel von Controller, Service und Repository in der Buchanwendung überprüfen.

**Ziel:**  
Überprüfe, ob die Endpunkte tatsächlich wie erwartet funktionieren – inklusive aller Schichten und der Datenbank.

**Typische Testfälle:**
- Ein vollständiges Hinzufügen eines neuen Buchs per POST-Request und Überprüfung, ob das Buch danach per GET verfügbar ist.
- Abrufen der Buchliste und Überprüfen, ob bestimmte Bücher korrekt enthalten sind.
- Löschen eines Buchs und sicherstellen, dass es anschließend nicht mehr abrufbar ist.

**Vorgehen:**  
Nutze für die Tests „echte“ Requests an die API. Lass die Datenbank für die Tests ggf. automatisch zurücksetzen, damit die Tests unabhängig voneinander laufen.
