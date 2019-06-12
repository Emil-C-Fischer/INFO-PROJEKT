package application;

abstract class DE{ //DATENELEMENT
    abstract String gibKuerzel();
    abstract int gibIndex();
    abstract boolean standortSetzen(boolean b);
    abstract String gibBezeichnung();
    abstract boolean gibRaetselAktiv();
    abstract void RaetselTrue();
    abstract void RaetselFalse();
}