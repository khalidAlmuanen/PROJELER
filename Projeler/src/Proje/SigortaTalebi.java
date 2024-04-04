package Proje;

public class SigortaTalebi {
	
        private String hastaAdi;
        private double talepMiktari;

        public SigortaTalebi(String hastaAdi, double talepMiktari) {
            this.hastaAdi = hastaAdi;
            this.talepMiktari = talepMiktari;
        }

        @Override
        public String toString() {
            return "Hasta Adı: " + hastaAdi + ", Talep Miktarı: " + talepMiktari + " TL";
        }
    }

