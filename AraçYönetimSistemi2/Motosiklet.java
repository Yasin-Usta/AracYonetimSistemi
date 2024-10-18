import java.util.ArrayList;
import java.util.List;

public class Motosiklet extends Arac{
	private String onSiperlikVarMı;
	private static List<Motosiklet> satilanMotosikletler=new ArrayList<>();

	public Motosiklet(String marka, double fiyat, String onSiperlikVarMı) {
		super(marka, fiyat);
		this.onSiperlikVarMı = onSiperlikVarMı;
	}
	
	
	

	public String getOnSiperlikVarMı() {
		return onSiperlikVarMı;
	}




	public void setOnSiperlikVarMı(String onSiperlikVarMı) {
		this.onSiperlikVarMı = onSiperlikVarMı;
	}




	@Override
	public void aracSat() {
		if(satildiMi) {
			System.out.println("HATA!" +getMarka() + "markalı motosiklet satılmış olduğundan tekrar satamazsınız");
		}
		else {
			toplamKazanc+=getFiyat();
			System.out.println(getMarka() + " markalı " + "motosiklet "  + getFiyat() + " TL'ye satıldı.");
			satilanMotosikletler.add(this);
			this.setSatildiMi(true);
			satilanAracSayisi++;
			System.out.println("şuana kadar satılan araç sayısı: " + satilanAracSayisi);	
		}
			
	}

	@Override
	public void fiyatGuncelle(double yeniFiyat) {
		if(isSatildiMi()) {
			System.out.println("HATA-araç satılmış olduğundan fiyat güncellemesi yapamazsınız.");
		}
		else {
			System.out.println("eski fiyat: " + getFiyat() + " TL. Yeni Fiyat: "+ yeniFiyat + " olarak güncellendi.");
			super.setFiyat(yeniFiyat);
		}		
	}

	
	public static void satilanAraclariListele() {
		System.out.println("---Satılan Motosikletler---");
		for(Motosiklet motosiklet:satilanMotosikletler) {
			System.out.println( motosiklet.getMarka()    + " markalı " +  "motosiklet" + " " +motosiklet.getFiyat() + " TL'ye satıldı.");
		}		
	}

	
	

	

}
