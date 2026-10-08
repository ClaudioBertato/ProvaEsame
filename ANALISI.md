# Problematiche
## Ambiguità
- Affidabilità di un cliente, quante volte deve far ritardo per essere considerato non affidabile?
- Ritardo, quanto tempo deve essere in ritardo nella consegna di un libro per essere considerato in ritardo?
- Dati, che dati si vogliono sapere di un cliente?
- Totale massimo libri, quanti libri può prendere un cliente affidabile al amssimo?
- Libri rari, ome vengono considerati rari, semplicemente con un attributo?

## Risoluzione problemi
### Affidabilità
- 1 Ipotesi(scartata): Avere un tasso di affidabilità da 1 a 5 stelle, (troppo complesso non sapendo se il cliente sia d'accordo e come vuole gestire l' affidabilità e quanta ne perde ongi volta)
- 2 Ipotesi (scelta): Avere un valore booleano che dice se un cliente è affidabile o no (dopo due volte che è calssificato come non affidabile e consegna un libro in orario ritorna affidabile), inoltre un cliente nuovo non è affidabile

### Ritardo
- 1 Ipotesi(scartata): Il cliente non è più affidabile dopo un solo giorno di ritardo
- 2 Ipotesi (scartata): Il cliente ha più possibilità: se 2 volte su 2 libri presi in prestito fa ritardo allora non è più affidabile (Seconda possibilità)
- 3 Ipotesi (scelta): Il cliente può fare 2 volte ritardo al massimo, ma se al primo libro fa ritardo di un tempo >= 7 giorni allora non ha la seconda possibilità

### Dati
- 1 Ipotesi (scelta perchè ha solo dati essenziali): NOME, COGNOME; CODICE FISCALE

### Totale massimo libri
- 1 Ipotesi (scelta): Tetto massimo di 2 libri per i clienti affidabili

### Libri rari
- 1 ipotesi (scelta): Al momento dell' inserimento di un libro nel catalogo, si richiede se è raro o meno
