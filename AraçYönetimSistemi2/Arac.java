import java.util.ArrayList;
import java.util.List;

public abstract class Arac {
    private String marka;
	private double fiyat;
	public static double toplamKazanc;
	protected static List<Arac> tumAraclarinListesi=new ArrayList<>();
	public boolean satildiMi;
	public static int satilanAracSayisi=0;
	public Arac(String marka, double fiyat) {
		this.marka = marka;
		this.fiyat = fiyat;
		tumAraclarinListesi.add(this);
		this.satildiMi=false;
	}
	
	


	//boolean ın  get Metodu böyledir isSatildiMi() şeklinde if in içinde vs kullanılır
	public boolean isSatildiMi() {
		return satildiMi;
	}




	public void setSatildiMi(boolean satildiMi) {
		this.satildiMi = satildiMi;
	}




	public String getMarka() {
		return marka;
	}




	public double getFiyat() {
		return fiyat;
	}


	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}




	




	@Override
	
		public String toString() {
		    return "Arac [marka=" + marka + ", fiyat=" + fiyat + ", Toplam Kazanç=" + toplamKazanc +
		           ", satildiMi=" + (satildiMi ? "Evet" : "Hayır") + "]";
		}
		




	public abstract void aracSat();
	public abstract void fiyatGuncelle(double yeniFiyat);
	
	public static void tumAraclariListele() {
		int i=1;
		System.out.println("---Tüm Araçlar---");
		for(Arac arac:tumAraclarinListesi) {
			System.out.println(i + "." +arac);
			i++;
		}
	}
	public static double satislardanEldeEdilenKazanç() {
		
		System.out.println("Satılan araçlardan elde edilen kazanç: " +  toplamKazanc + " TL" );
		return toplamKazanc;
	}
		
	
	
	
	

}
