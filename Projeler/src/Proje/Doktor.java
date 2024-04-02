 String  hastaAdi ;  String hastaSoyadi;  LocalDateTime randevuTarihi ;  String  doktorAdi ;  int  randevuId;
	 @Override
	 public void randevuAl(String hastaAdi, String hastaSoyadi, LocalDateTime randevuTarihi, String doktorAdi, int randevuId) {
	     super.Hasta(hastaAdi, hastaSoyadi, randevuTarihi, doktorAdi, randevuId);
	     // Randevu alındığında yapılacak işlemler burada gerçekleştirilir 
	    
	     if(!(hastaAdi == null || hastaSoyadi == null || doktorAdi == null || randevuId == 0)) {
	         System.out.println("Hasta Adı: " + hastaAdi ); 
	         System.out.println("Hasta Soyadı: " + hastaSoyadi );
	         System.out.println("Randevu Tarihi: " + randevuTarihi );
	         System.out.println("Doktor Adı: " + doktorAdi );
	         System.out.println("Randevu Id: " + randevuId +"\n");
	         System.out.println("Randevu alındı.");}
	     else 
	         System.out.println("Randevu alınmadı."+"\n");
	     
	 }

	/* @Override
	 public void randevuIptalEt(int randevuId) {
	     // Veritabanından randevuyu iptal etme işlemleri burada gerçekleştirilir
		 boolean randevuBulundu = false;
		for (int i = 0; i < randevuListesi.size(); i++) {
	         if (randevuListesi.get(i).getrandevuId() == randevuId) {
	             randevuListesi.remove(i);
	             randevuBulundu = true;
	             System.out.println("Randevu başarıyla iptal edildi.");
	             break;
	         }
	     }
	     if (!randevuBulundu) {
	         System.out.println("Randevu iptal edilemedi. Geçerli bir randevu ID'si girin.");
	     }
	 }*/
	    public boolean randevuIptalEt(int randevuId) {
		     // Veritabanından randevuyu iptal etme işlemleri burada gerçekleştirilir
	    	if(!(randevuId)) return false;
			return kart.getHesap().paraCek(miktar);
			return randevuBulundu;
		 }
	 public void randevuYenidenPlanla(int randevuId, LocalDateTime yeniTarih) {
		    // Randevuyu yeni bir tarihe yeniden planlama işlemleri burada gerçekleştirilir

import java.time.LocalDateTime;

for (Hasta hasta : randevuListesi) {
		        if (hasta.getrandevuId() == randevuId) {
		            hasta.setrandevuTarihi(yeniTarih);
		            System.out.println("Randevu başarıyla yeniden planlandı.");
		            return;
		        }
		    }
		    System.out.println("Belirtilen randevu ID'si ile eşleşen randevu bulunamadı.");
		}
  }
