package Proje;

public class Fatura {
	
        private int faturaNo;
        private String hastaAdi;
        private double miktar;
        private double odemeMiktari;

        public Fatura(int faturaNo, String hastaAdi, double miktar) {
            this.faturaNo = faturaNo;
            this.hastaAdi = hastaAdi;
            this.miktar = miktar;
            this.odemeMiktari = 0;
        }
        
        public String getHastaAdi() {
            return hastaAdi;
        }
        public void odemeEkle(double odemeMiktari) {
            this.odemeMiktari += odemeMiktari;
        }

        public double getKalanBorc() {
            return miktar - odemeMiktari;
        }

        @Override
        public String toString() {
            return "Fatura No: " + faturaNo + ", Hasta Adı: " + hastaAdi + ", Miktar: " + miktar + " TL, Ödenen Miktar: " + odemeMiktari + " TL, Kalan Borç: " + getKalanBorc() + " TL";
        }
    }

