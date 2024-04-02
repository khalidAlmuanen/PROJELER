package Proje;

import java.time.LocalDateTime;

public class Hasta {

	 String  hastaAdi ;  String hastaSoyadi;  LocalDateTime randevuTarihi ;  String  doktorAdi ;  int  randevuId;
	 Hasta(){}
	 Hasta(String  hastaAdi ,  String hastaSoyadi ,  LocalDateTime randevuTarihi ,  String  doktorAdi ,  int  randevuId){
		 this.hastaAdi = hastaAdi;
		 this.hastaSoyadi =hastaSoyadi;
		 this.randevuTarihi = randevuTarihi;
		 this.doktorAdi = doktorAdi;
		 this.randevuId = randevuId;
	 }
	 
        public void sethastaAdi(String hastaAdi)
        {
        	this.hastaAdi = hastaAdi;
        }
        public String gethastaAdi()
        {
        	return hastaAdi;
        }
        public void sethastaSoyadi(String hastaSoyadi)
        {
        	this.hastaSoyadi = hastaSoyadi;
        }
        public String gethastaSoyadi()
        {
        	return hastaSoyadi;
        }
        public void setrandevuTarihi(LocalDateTime randevuTarihi)
        {
        	this.randevuTarihi = randevuTarihi;
        }
        public LocalDateTime getrandevuTarihi()
        {
        	return randevuTarihi;
        }
        public void setdoktorAdi(String doktorAdi)
        {
        	this.doktorAdi = doktorAdi;
        }
        public String getidoktorAdi()
        {
        	return doktorAdi;
        }
        public void setrandevuId(int randevuId)
        {
        	this.randevuId = randevuId;
        }
        public int getrandevuId()
        {
        	return randevuId;
        }
        public String toString(){//overriding the toString() method  
        	  return " Hasta Adi: " +hastaAdi+"\n "+"Hasta soyadi: "+hastaSoyadi+"\n "+"Randevu tarihi: "+randevuTarihi+"\n "+"Doktor adi: "+doktorAdi+"\n "+"Randevu ID: "+randevuId;  
        	 }
		public void Hasta(String hastaAdi2, String hastaSoyadi2, LocalDateTime randevuTarihi2, String doktorAdi2,
				int randevuId2) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		 
		
        
}
