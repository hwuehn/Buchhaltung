package data;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Account {

    private final int accountID;
    private final String accountName;
    private double initialBalance;

    public void setInitialBalance() {
        initialBalance = 0.00;
    }

    public Account(int accountID, String accountName ) {
        this.accountName = accountName;
        this.accountID = accountID;
        setInitialBalance();
        System.out.print("Kontoerstellung:");
        System.out.println(ausgabe());
    }

    public String ausgabe() {
        return MessageFormat.format(" [Kontonummer = {0}, Bezeichnung = {1}, AB = {2}]", kontoId, kontoBezeichnung, anfangsbestand);
    }

    public static String ausgabeKontoBuchungen(List<BuchungsSatz> buchungen, Konto konto) {
        Stream<BuchungsSatz> buchungsSaetze = buchungen.stream().filter(b -> isSameKonto(b.getKonto(),konto) );
        String diesesKonto = "K: " + konto.getKontoId() + "    " + konto.anfangsbestand;
        String gegenKonten = buchungsSaetze.reduce("", gegenKontoEintrag(buchungen), String::concat);
        return diesesKonto+ "\n" + gegenKonten;
    }

    private static BiFunction<String, BuchungsSatz, String> gegenKontoEintrag(List<BuchungsSatz> buchungen) {
        return (acc, b1) -> {
            BuchungsSatz b2 = getBuchungsZwilling(buchungen, b1).get();
            return acc + b2.getKonto().getKontoId() + "   " + b1.gesamtWert() + "\n";
        };
    }

    private static Optional<BuchungsSatz> getBuchungsZwilling(List<BuchungsSatz> buchungen, BuchungsSatz b) {
        return buchungen.stream().filter(bb -> isSameBuchungsId(b, bb) && isNotSameKonto(b, bb)).findFirst();
    }

    private static boolean isSameBuchungsId(BuchungsSatz b, BuchungsSatz bb) {
        return bb.getBuchungsid() == b.getBuchungsid();
    }

    private static boolean isNotSameKonto(BuchungsSatz b, BuchungsSatz bb) {
        return b.getKonto().getKontoId() != bb.getKonto().getKontoId();
    }
    private static boolean isSameKonto(Konto k, Konto k2) {
        return k.getKontoId() == k2.getKontoId();
    }

    @Override
    public String toString() {
        return kontoBezeichnung;
//		return MessageFormat.format("Soll       {0} {1}        Haben \n" +
//                        "----------------------------------------- \n" +
//                        "AB             {2} |                      \n" +
//                        "                    |                     \n" +
//				        "                    |                     \n" +
//						"                    |                     \n" ,
//                kontoId, kontoBezeichnung, formattedDoubleString(anfangsbestand));
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("0.00");
        return newFormat.format(wert);
    }
}
