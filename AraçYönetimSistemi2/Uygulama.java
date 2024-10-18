import java.util.Scanner;

public class Uygulama {
	private static Scanner scanner= new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
            System.out.println("1. Araç ekle");
            System.out.println("2. Araç Sat");
            System.out.println("3. Araç fiyat güncelle");
            System.out.println("4. Satılan araçları listele(otomobil/motosiklet/kamyon");
            System.out.println("5. Çıkış");

            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();
		
            switch(secim) {
            
            case 1: System.out.println("hangi tür araç eklemek istiyorsunuz:\n 1-otomobil 2-motosiklet 3-kamyon");
            int tur=scanner.nextInt();
           scanner.nextLine();
            System.out.print("Marka: ");
            String marka = scanner.nextLine();
            System.out.println("fiyat giriniz:");
            double fiyat = scanner.nextDouble();
            scanner.nextLine();
            Arac yeniArac=null;
            
         switch(tur) {
         case 1:
        	 System.out.print("araç türünü seçiniz: hatchback Sedan Suv ");
        	 String ozellik=scanner.nextLine();
        	 yeniArac=new Otomobil(marka,fiyat,ozellik);
        	 System.out.println(marka + " markalı" + ozellik +" otomobil satış fiyatı "+fiyat+ " TL olarak eklendi." );
        	 break;
        	 
         case 2:
        	 System.out.print("ön siperlik var mı ");
         String onSiperlik=scanner.nextLine();
         yeniArac=new Motosiklet(marka, fiyat, onSiperlik);
         System.out.println(marka + " markalı motosiklet  satış fiyatı "+fiyat+ " TL olarak eklendi.");
         break;
         
         case 3:
        	 System.out.println("kamyonun teker sayısını giriniz");
        	 int tekerSayisi=scanner.nextInt();
        	 yeniArac=new Kamyon(marka, fiyat, tekerSayisi);
        	 System.out.println(marka + " markalı " + tekerSayisi + " tekerli Kamyon  satış fiyatı "+fiyat+ " TL olarak eklendi.");
        	 break;

         default:
             System.out.println("Geçersiz araç türü.");
             break;
         }
         break;
            case 2:
            	Arac.tumAraclariListele();
            	System.out.print("Satılacak araç numarasını seçin: ");
               int satilacakAracNo = scanner.nextInt();
               if (satilacakAracNo > 0 && satilacakAracNo <= Arac.tumAraclarinListesi.size()) {
                   Arac secilenArac = Arac.tumAraclarinListesi.get(satilacakAracNo - 1);
                   if (!secilenArac.isSatildiMi()) {
                       // Aracı sat ve toplam kazancı güncelle
                       secilenArac.aracSat();
                       Arac.toplamKazanc += secilenArac.getFiyat();
                       
                       // Aracı listeden çıkar
                       Arac.tumAraclarinListesi.remove(secilenArac);
                       
                       System.out.println("Araç başarıyla satıldı.");
                   } else {
                       System.out.println("Bu araç zaten satıldı.");
                   }
               } else {
                   System.out.println("Geçersiz numara.");
               }
               break;
            
            case 3:
            	Arac.tumAraclariListele();  //bunlar zaten satılmamış olanlar
            	System.out.print("fiyatı güncellenecek araç numarasını seçin: ");
               int guncellenecekArac=scanner.nextInt();
               scanner.nextLine();
               System.out.print("Yeni fiyatı girin: ");
               double yeniFiyat = scanner.nextDouble();
               scanner.nextLine(); // Boş satır geçişi için ekleme
               if (guncellenecekArac > 0 && guncellenecekArac <= Arac.tumAraclarinListesi.size()) {
                   Arac secilenArac = Arac.tumAraclarinListesi.get(guncellenecekArac - 1);
                   secilenArac.fiyatGuncelle(yeniFiyat);
            }
               else {
            	   System.out.println("Seçilen araç daha önce satılmış, fiyat güncellenemez.");
               }
            break;
            
            case 4:
            	System.out.println("Hangisini görüntülemek istersiniz? \n 1-Otomobil 2-Motosiklet 3-Kamyon");
            	int satilanlar=scanner.nextInt();
            	switch(satilanlar) {
            	case 1:
            		Otomobil.satilanAraclariListele();
            		break;
            	case 2:
            		Motosiklet.satilanAraclariListele();
            		break;
            	case 3:
            		Kamyon.satilanAraclariListele();
            		break;
            	}
            case 5: 
            	break;
            
            default:
            	System.out.println("eksik veya hatalı işlem yaptınız.");
            	break;
            	
	
	}
	
}
}}
