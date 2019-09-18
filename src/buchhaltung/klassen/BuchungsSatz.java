package buchhaltung.klassen;

import java.util.List;

public class BuchungsSatz {

    private Konto konto;

    public List<Position> getPositions() {
        return positions;
    }

    private final List<Position> positions;
    private final Seite seite;

    public BuchungsSatz(Konto konto, List<Position> positions, Seite seite) {
        this.konto = konto;
        this.positions = positions;
        this.seite = seite;
    }

    public Double gesamtWert(){
        return positions.stream().map(p -> p.getGesamtpreisNetto()).reduce(0d ,(acc,e) -> acc + e);
    }

}
