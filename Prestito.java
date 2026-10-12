import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestito {
    private final Libro libro;
    private final LocalDate dataInizio;
    private final LocalDate dataFine;
    private LocalDate dataConsegna;

    public Prestito(Libro libro, LocalDate dataInizio, LocalDate dataFine) {
        this.libro = libro;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public long calcolaGiorniDiRitardo(LocalDate dataEffettiva) {
        if (dataConsegna == null) {
            return Math.max(0, ChronoUnit.DAYS.between(dataFine, dataEffettiva));
        }
        return Math.max(0, ChronoUnit.DAYS.between(dataFine, dataConsegna));
    }


}