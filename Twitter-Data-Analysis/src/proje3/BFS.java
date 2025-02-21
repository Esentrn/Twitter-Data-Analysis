package proje3;

import org.json.JSONArray;

public class BFS {
    //Bu kısımdaki kodumuz çalışmadığı için yoruma aldık
  /*public void find(Kullanıcı kullanıcı1,Kullanıcı kullanıcı2)
  {
      TweetAnalyzer tw=new TweetAnalyzer();
      KullaniciLinkedList<String> birincikullanıcı=kullanıcı1.getTakipciler();
      KullaniciLinkedList<String> ikincikullanıcı=kullanıcı2.getTakipciler();
      String[] spordizi = null;
      String[] saglıkdizi=null;
      String[] sanatdizi = null;
      String[] takıdizi = null;
      String[] giyimdizi = null;
      String[] teknolojidizi = null;
      String[] tarihdizi = null;
      String[] muzikdizi = null;
      String[] egitimdizi=null;
      String[] yemekdizi=null;
      String[] tatildizi=null;
      for(int i=0;i<birincikullanıcı.size();i++)
      {
         String sonuc= tw.analyzeTweets(kullanıcı1.getTweetler(), kullanıcı1);
          if(sonuc=="spor")
              spordizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="sanat")
              sanatdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="saglık")
              saglıkdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="takı")
              takıdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="giyim")
              giyimdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="teknoloji")
              teknolojidizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="tarih")
              spordizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="muzik")
              muzikdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="egitim")
              egitimdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="yemek")
              yemekdizi[i]=sonuc;
          else 
              continue;
          
          if(sonuc=="tatil")
              tatildizi[i]=sonuc;
          else 
              continue;
          
          
      }
      
      for(int i=0;i<birincikullanıcı.size();i++)
      {
         String sonuc2= tw.analyzeTweets(kullanıcı2.getTweetler(), kullanıcı2);
          if(sonuc2=="spor")
              spordizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="sanat")
              sanatdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="saglık")
              saglıkdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="takı")
              takıdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="giyim")
              giyimdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="teknoloji")
              teknolojidizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="tarih")
              spordizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="muzik")
              muzikdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="egitim")
              egitimdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="yemek")
              yemekdizi[i]=sonuc2;
          else 
              continue;
          
          if(sonuc2=="tatil")
              tatildizi[i]=sonuc2;
          else 
              continue;
          
          
      }
      System.out.println("Spordizi:");
        yazdirDizi(spordizi);

        System.out.println("\nSaglikdizi:");
        yazdirDizi(saglıkdizi);

        System.out.println("\nSanatdizi:");
        yazdirDizi(sanatdizi);

        System.out.println("\nTakidizi:");
        yazdirDizi(takıdizi);

        System.out.println("\nGiyimdizi:");
        yazdirDizi(giyimdizi);

        System.out.println("\nTeknolojidizi:");
        yazdirDizi(teknolojidizi);

        System.out.println("\nTaridizi:");
        yazdirDizi(tarihdizi);

        System.out.println("\nMuzikdizi:");
        yazdirDizi(muzikdizi);

        System.out.println("\nEgitimdizi:");
        yazdirDizi(egitimdizi);

        System.out.println("\nYemekdizi:");
        yazdirDizi(yemekdizi);

        System.out.println("\nTatildizi:");
        yazdirDizi(tatildizi);
    }

    private static void yazdirDizi(String[] dizi) {
        for (String eleman : dizi) {
            System.out.print(eleman + " ");
        }
        System.out.println();
    }
    public void bfs(Kullanıcı startNode, Kullanıcı targetNode) {
    Kuyruk<Kullanıcı> kuyruk = new Kuyruk<>();
    ZiyaretEdilenSet ziyaretEdilen = new ZiyaretEdilenSet();

    kuyruk.ekle(startNode);
    ziyaretEdilen.add(startNode.getKullaniciAdi());

    while (!kuyruk.isEmpty()) {
        Kullanıcı current = kuyruk.cikar();

        // Eğer hedef kullanıcıya ulaşıldıysa bağlantı var demektir
        
            Kullanıcı startUser = get(startNode.getKullaniciAdi());
            Kullanıcı targetUser = get(targetNode.getKullaniciAdi());

            if (startUser != null && targetUser != null && startUser.equals(targetUser)) {
                System.out.println("Bağlantı bulundu: " + startNode.getKullaniciAdi() + " - " + targetNode.getKullaniciAdi());
            } else {
                System.out.println("Bağlantı bulunamadı.");
            }
            
        
System.out.println(startUser);
        System.out.println(targetUser);
        String[] takipciler = current.getTakipciler();

        for (String takipci : takipciler) {
            if (!ziyaretEdilen.contains(takipci)) {
                Kullanıcı takipciKullanici = get(takipci);
                if (takipciKullanici != null) {
                    kuyruk.ekle(takipciKullanici);
                    ziyaretEdilen.add(takipci);
                }
            }
        }
    }
    
    
    System.out.println("Bağlantı bulunamadı2.");
}

    */
}
  

