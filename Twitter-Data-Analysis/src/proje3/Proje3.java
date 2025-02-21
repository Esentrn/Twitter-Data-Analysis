package proje3;
//import org.json.JSONArray;
//import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import org.json.JSONArray;
import org.json.JSONObject;



public class Proje3 {
    public static void main(String[] args) {
        String[] tumKelimeler = {
    "kaleci", "top", "takım", "stad", "gol", "oyuncu", "yedek", "galatasaray", "fenerbahçe", "beşiktaş", "ronaldo", "messi", "icardi", "defans", "faul", "kırmızı kart", "hakem",
    "tarif", "içindekiler", "yumurta", "süt", "ana yemek", "kahvaltı", "fast food", "hamburger", "lokanta", "şef", "restaurant", "yemek takımı", "çatal", "bıçak", "meze",
    "kışlık", "yazlık", "mont", "ayakkabı", "çanta", "sweat", "elbise", "atkı", "eldiven", "bot", "şal", "panço", "ferace", "tayt", "sırt çantası",
    "mücevher", "kolye", "bileklik", "saat", "halhal", "yüzük", "pandora", "ip bileklik", "gümüş", "altın", "zümrüt", "set", "çeyrek altın",
    "bilgisayar", "robot", "yapay zeka", "akıllı sistem", "tablet", "telefon", "uydu", "televizyon", "uygulama", "drone", "görüntü işleme",
    "kitap", "padişah", "sultan", "geçmiş", "dönem", "bölge", "işgal", "sınır", "devrim", "savaş", "yükselme", "Osmanlı", "kuruluş", "Atatürk",
    "sanatçı", "ressam", "çizim", "sergi", "dijital sergi", "eser", "açık arttırma", "yaratıcılık", "özgür ruh", "heykel", "model", "resim", "toplum", "tuval",
    "şarkıcı", "nota", "piyano", "gitar", "albüm", "plak", "beste", "konser", "sahne", "turne",
    "hastane", "hastalık", "reçete", "ilaç", "doktor", "hemşire", "acil", "ağrı kesici", "antibiyotik", "sağlık bakanı", "koronavirüs", "grip", "pandemi",
    "ders", "okul", "üniversite", "ara tatil", "nöbetçi müdür", "müdür yardımcısı", "matematik", "fizik", "kimya", "elektrik", "programlama", "veri yapıları", "derslik", "amfi", "yoklama",
    "dinlenme", "gezi", "yaz", "kış", "kayak", "deniz", "kumsal", "yurtdışı", "yazlık"
};

       try {
            // Kullanıcı bilgilerini okuma kısmı 
            String jsonDosyasi = new String(Files.readAllBytes(Paths.get("twitter.json")));
            JSONArray kullaniciVerileri = new JSONArray(jsonDosyasi);
            TweetAnalyzer tweetAnalyzer = new TweetAnalyzer(); 
            Hash kullaniciHashTablosu = new Hash();
            DFS dfs = new DFS();  
            
            System.out.println(kullaniciVerileri.length());
            int c=0;
            
            
            PrintStream dosyaCikti = new PrintStream(new FileOutputStream("cikti.txt"));
            System.setOut(dosyaCikti);
            for (int i = 0; i < kullaniciVerileri.length(); i++) {
                JSONObject kullaniciJson = kullaniciVerileri.getJSONObject(i);


                Kullanıcı kullanici = new Kullanıcı(
                        kullaniciJson.getString("username"),
                        kullaniciJson.getString("name"),
                        kullaniciJson.getInt("followers_count"),
                        kullaniciJson.getInt("following_count"),
                        kullaniciJson.getString("language"),
                        kullaniciJson.getString("region"),
                        kullaniciJson.getJSONArray("tweets")
                );

           
  
                kullaniciHashTablosu.put(kullanici);
                c++;
               tweetAnalyzer.analyzeTweets(kullanici.getTweetler(), kullanici); // Tweet analizini yap
               
                dfs.dfs(kullaniciHashTablosu, kullanici.getKullaniciAdi(), tumKelimeler);
                JSONArray takipciListesiJson = kullaniciJson.getJSONArray("followers");
                JSONArray takipEdilenListesiJson = kullaniciJson.getJSONArray("following");

                for (int j = 0; j < takipciListesiJson.length(); j++) {
                    kullanici.addTakipci(takipciListesiJson.getString(j));
                   
                }

                for (int j = 0; j < takipEdilenListesiJson.length(); j++) {
                    kullanici.addTakipEdilen(takipEdilenListesiJson.getString(j));
                   
                }
                  
             
 
               
            }
             
            
            KullaniciGrafi kullaniciGrafi = new KullaniciGrafi(kullaniciHashTablosu);
            Kullanıcı kullanici1=kullaniciHashTablosu.get("burcu06");
            
        
        Kullanıcı kullanici2 = kullaniciHashTablosu.get("umran.durak");
        BFS bfs=new BFS();
        
        
            
            int b=0;
            // Hash tablosunu ekrana bas
            
            for (KullaniciLinkedList<Kullanıcı> altliste : kullaniciHashTablosu.getTablo()) {
                for (int i = 0; i < altliste.size(); i++) {
                    Kullanıcı kullanici = altliste.get(i);
                    System.out.println("Kullanıcı Adı: " + kullanici.getKullaniciAdi());
                    System.out.println("Tam Ad: " + kullanici.getTamAd());
                    System.out.println("Takipçi Sayısı: " + kullanici.getTakipciSayisi());
                    System.out.println("Takip Edilen Sayısı: " + kullanici.getTakipEdilenSayisi());
                    System.out.println("Dil: " + kullanici.getDil());
                    System.out.println("Bölge: " + kullanici.getBolge());
                    System.out.println("Tweetler: " + kullanici.getTweetler());
                    System.out.println("Takipçiler: " + kullanici.getTakipciler());
                    System.out.println("Takip Edilenler: " + kullanici.getTakipEdilenler());
                    System.out.println("-----------");
                    b++;
                }
            }

            // Kullanıcı grafini ekrana bas
          
            kullaniciGrafi.grafiYazdir();
           
            //kullaniciGrafi.kullaniciGrafiYazdir("ali.alpugan");
            
             // Aranan kullanıcıyı bulma 
            /*Kullanıcı arananKullanici = kullaniciHashTablosu.get("ada.durmaz");
            if (arananKullanici != null) {
                System.out.println("Kullanıcı Adı: " + arananKullanici.getKullaniciAdi());
                System.out.println("Tam Ad: " + arananKullanici.getTamAd());
                System.out.println("Takipçi Sayısı: " + arananKullanici.getTakipciSayisi());
                System.out.println("Takip Edilen Sayısı: " + arananKullanici.getTakipEdilenSayisi());
                System.out.println("Dil: " + arananKullanici.getDil());
                System.out.println("Bölge: " + arananKullanici.getBolge());
                // Diğer özellikler
            } else {
                System.out.println("Kullanıcı bulunamadı.");
            }
            */
            
            
           
          
            
            
            
            System.out.println("Yemek Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getYemekHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Giyim Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getGiyimHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Takı Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getTakıHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Spor Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getSporHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Saglik Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getSaglikHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Sanat Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getSanatHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Teknoloji Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getTeknolojiHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Tarih Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getTarihHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Muzik Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getMuzikHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Eğitim Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getEgitimHash());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Tatil Hash Tablosu");
            tweetAnalyzer.printHashTableContents(tweetAnalyzer.getTatilHash());
            
           
            
            /*Graph kullaniciGrafi2 = new Graph(kullaniciHashTablosu);
            kullaniciGrafi2.printGraph(); Çalışmayan Graf veri yapısı*/
            

           
        GraphAnalyzer graphAnalyzer = new GraphAnalyzer(kullaniciGrafi);
            graphAnalyzer.findAndStoreSimilarUsers("pocan.emre");

            // Hash tablolarını ekrana bas
            System.out.println("Dil Hash Tablosu:");
            graphAnalyzer.printHashTableContents(graphAnalyzer.getDilHash());

            System.out.println("Bölge Hash Tablosu:");
            graphAnalyzer.printHashTableContents(graphAnalyzer.getBolgeHash());

            System.out.println("Takipçi Hash Tablosu:");
            graphAnalyzer.printHashTableContents(graphAnalyzer.getTakipciHash());

            System.out.println("Takip Edilen Hash Tablosu:");
            graphAnalyzer.printHashTableContents(graphAnalyzer.getTakipEdilenHash());
           
            
           dosyaCikti.close(); 

            
        
        GraphPanel graphPanel = new GraphPanel(kullaniciGrafi, "ada.durmaz");

        JFrame frame = new JFrame("Kullanıcı İlişkileri Grafi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000); 
        frame.setLocationRelativeTo(null);

        frame.add(graphPanel);

        frame.setVisible(true);
      
        } catch (Exception e) {
            e.printStackTrace();
}
        
}

}