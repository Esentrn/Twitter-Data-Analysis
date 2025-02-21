
package proje3;

import org.json.JSONArray;

public class TweetAnalyzer {
private int sonuc;
private Hash kullaniciHashTablosu = new Hash();
        private int toplamKullaniciSayisi=0;
        Hash sporHash = new Hash();
        Hash yemekHash = new Hash();
        Hash giyimHash = new Hash();
        Hash takıHash = new Hash();
        Hash teknolojiHash = new Hash();
        Hash tarihHash = new Hash();
        Hash sanatHash = new Hash();
        Hash muzikHash = new Hash();
        Hash saglikHash = new Hash();
        Hash egitimHash = new Hash();
        Hash tatilHash = new Hash();
        String[] sporKelimeler = {"kaleci", "top", "takım", "stad", "gol", "oyuncu", "yedek", "galatasaray", "fenerbahçe", "beşiktaş", "ronaldo", "messi", "icardi", "defans", "faul", "kırmızı kart", "hakem"};
        String[] yemekKelimeler = {"tarif", "içindekiler", "yumurta", "süt", "ana yemek", "kahvaltı", "fast food", "hamburger", "lokanta", "şef", "restaurant", "yemek takımı", "çatal", "bıçak", "meze"};
        String[] giyimKelimeler = {"kışlık", "yazlık", "mont", "ayakkabı", "çanta", "sweat", "elbise", "atkı", "eldiven", "bot", "şal", "panço", "ferace", "tayt", "sırt çantası"};
        String[] takıKelimeler = {"mücevher", "kolye", "bileklik", "saat", "halhal", "yüzük", "pandora", "ip bileklik", "gümüş", "altın", "zümrüt", "set", "çeyrek altın"};
        String[] teknolojiKelimeler = {"bilgisayar", "robot", "yapay zeka", "akıllı sistem", "tablet", "telefon", "uydu", "televizyon", "uygulama", "drone", "görüntü işleme"};
        String[] tarihKelimeler = {"kitap", "padişah", "sultan", "geçmiş", "dönem", "bölge", "işgal", "sınır", "devrim", "savaş", "yükselme", "Osmanlı", "kuruluş", "Atatürk"};
        String[] sanatKelimeler = {"sanatçı", "ressam", "çizim", "sergi", "dijital sergi", "eser", "açık arttırma", "yaratıcılık", "özgür ruh", "heykel", "model", "resim", "toplum", "tuval"};
        String[] muzikKelimeler = {"şarkıcı", "nota", "piyano", "gitar", "albüm", "plak", "beste", "konser", "sahne", "turne"};
        String[] saglikKelimeler = {"hastane", "hastalık", "reçete", "ilaç", "doktor", "hemşire", "acil", "ağrı kesici", "antibiyotik", "sağlık bakanı", "koronavirüs", "grip", "pandemi"};
        String[] egitimKelimeler = {"ders", "okul", "üniversite", "ara tatil", "nöbetçi müdür", "müdür yardımcısı", "matematik", "fizik", "kimya", "elektrik", "programlama", "veri yapıları", "derslik", "amfi", "yoklama"};
        String[] tatilKelimeler = {"dinlenme", "gezi", "yaz", "kış", "kayak", "deniz", "kumsal", "yurtdışı", "yazlık"};
        
    
 public void setToplamKullaniciSayisi(int toplamKullaniciSayisi) {
        this.toplamKullaniciSayisi = toplamKullaniciSayisi;
    }

    public int getToplamKullaniciSayisi() {
        return toplamKullaniciSayisi;
    }

   
        String[] dizi={"spor","saglik","sanat","giyim","teknoloji","tarih","takı","muzik","egitim","yemek","tatil"};
    // Tweet analizini gerçekleştirdiğimiz kısım
    public void analyzeTweets(JSONArray tweets, Kullanıcı kullanici) {
    
    String[] kelimeler = new String[tweets.length()];
    int[] kelimeSayisi = new int[tweets.length()];

    // Her tweeti analiz ettirme kısmı
    for (int i = 0; i < tweets.length(); i++) {
        String tweet = tweets.getString(i);

        // Tweeti kelimelere ayırdık boşluklara göre
        String[] words = tweet.split("\\s+"); 

        
        for (String word : words) {
            word = word.toLowerCase(); 
            word = word.replaceAll("[^a-zA-Z0-9]", ""); 

           
            updateWordCountArray(kelimeler, kelimeSayisi, word);
        }
    }

    // Dizileri sıraladık (kelime sayısına göre)
    sortArraysByCount(kelimeler, kelimeSayisi);

    // En çok tekrar eden dört kelimeyi yazdır
    for (int i = 0; i < Math.min(kelimeler.length, 4); i++) {
        System.out.println("En çok tekrar eden kelime " + (i + 1) + ": " + kelimeler[i] +
                " (" + kelimeSayisi[i] + " kez)");
    }

    
    yazdır(kullanici, kelimeler);
}

        
        
        
        
    

    public void yazdır(Kullanıcı kullanici, String[] kelimeler) {
    int j = 0;
    while (j < kelimeler.length) {
        sonuc = hangiIlgiAlaninaAit(kelimeler[j], sporKelimeler, saglikKelimeler, sanatKelimeler, giyimKelimeler, teknolojiKelimeler, tarihKelimeler, takıKelimeler, muzikKelimeler, egitimKelimeler, yemekKelimeler, tatilKelimeler);
       // dondür();
        if (sonuc == -1) {
            j++;
        } else {
            if (sonuc >= 0 && sonuc < dizi.length) {
                System.out.println(dizi[sonuc] + " (" + kullanici.getTweetler().length() + " tweet)");

        switch (dizi[sonuc]) {
        case "spor":
            sporHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "saglik":
            saglikHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "sanat":
            sanatHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "giyim":
            giyimHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "teknoloji":
            teknolojiHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "tarih":
            tarihHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "takı":
            takıHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "muzik":
            muzikHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "egitim":
            egitimHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "yemek":
            yemekHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        case "tatil":
            tatilHash.put(kullanici);
            System.out.println(kullanici.getKullaniciAdi()); 
            break;
        default:
            System.out.println("Geçersiz ilgi alanı.");
    }
} else {
    System.out.println("İlgi alanı bulunamadı.");
}

            
            break;
        }
    }
    
}

    String dondür()
    {
        return dizi[sonuc];
    }

    public Hash getYemekHash() {
        return yemekHash;
    }

    public Hash getGiyimHash() {
        return giyimHash;
    }
    
    public Hash getTakıHash() {
        return takıHash;
    }
    
    public Hash getSporHash() {
        return sporHash;
    }

    public Hash getSaglikHash() {
        return saglikHash;
    }
    
    public Hash getSanatHash() {
        return sanatHash;
    }
    
    public Hash getTeknolojiHash() {
        return teknolojiHash;
    }

    public Hash getTarihHash() {
        return tarihHash;
    }
    
    public Hash getMuzikHash() {
        return muzikHash;
    }
    
    public Hash getEgitimHash() {
        return egitimHash;
    }
    
    public Hash getTatilHash() {
        return tatilHash;
    }
    
 private static int hangiIlgiAlaninaAit(String arananKelime, String[]... ilgiAlanlari) {
    for (int i = 0; i < ilgiAlanlari.length; i++) {
        for (String kelime : ilgiAlanlari[i]) {
            if (kelime.equals(arananKelime)) {
                return i;  
            }
        }
    }
    return -1;
}

    
   private void updateWordCountArray(String[] wordsArray, int[] wordCountArray, String word) {
    for (int i = 0; i < wordsArray.length; i++) {
        if (wordsArray[i] != null && wordsArray[i].equals(word)) {
            
            wordCountArray[i]++;
            return;
        } else if (wordsArray[i] == null) {
            
            wordsArray[i] = word;
            wordCountArray[i] = 1;
            return;
        }
    }
}
public static void printHashTableContents(Hash hashTable) {
        KullaniciLinkedList[] tablo = hashTable.getTablo();

        for (int i = 0; i < tablo.length; i++) {
            System.out.print("Bucket " + i + ": ");
            KullaniciLinkedList bucket = tablo[i];
            printBucketContents(bucket);
        }
    }

    private static void printBucketContents(KullaniciLinkedList bucket) {
        for (int i = 0; i < bucket.size(); i++) {
            Kullanıcı kullanici = (Kullanıcı) bucket.get(i);
            System.out.print(kullanici.getKullaniciAdi() + " -> ");
        }
        System.out.println("null");
    }

    // Dizileri kelime sayısına göre sıraladık
    private void sortArraysByCount(String[] kelimeler, int[] sayı) {
        for (int i = 0; i < kelimeler.length; i++) {
            for (int j = i + 1; j < kelimeler.length; j++) {
                if (sayı[j] > sayı[i]) {
                    // Swap işlemi
                    int tempCount = sayı[i];
                    sayı[i] = sayı[j];
                    sayı[j] = tempCount;

                    String tempWord = kelimeler[i];
                    kelimeler[i] = kelimeler[j];
                    kelimeler[j] = tempWord;
         }
}
}
}
    
  

}