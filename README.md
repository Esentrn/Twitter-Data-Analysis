# X (Twitter) Veri Analizi ve Kullanıcı İlişkilendirmesi  

Bu proje, JSON tabanlı veri setlerini işleyerek kullanıcı ilişkilerini, ortak ilgi alanlarını ve ağ desenlerini keşfeden bir Twitter veri analiz aracıdır. Grafik algoritmaları ve hash tabloları kullanarak takipçi bağlantılarını görselleştirir ve paylaşılan ilgi alanlarına dayalı olarak potansiyel kullanıcı eşleşmeleri önerir. 

## Proje Hedefleri  
- **JSON Veri Seti Kullanımı**: **twitter.json** dosyası ile analiz gerçekleştirme  
- **Hash Tabloları ile Veri Organizasyonu**: Kullanıcı verilerini verimli şekilde saklama  
- **Graf Modelleme**: Takipçi-takip edilen ilişkisini analiz etme  
- **İlgi Alanı Bazlı Eşleştirme**: Ortak ilgi alanlarına sahip kullanıcıları belirleme  
- **Graf Algoritmaları ile Analiz**: Kullanıcı ilişkilerini keşfetme  

## Proje Özellikleri  
**Veri Kaynağı**  
- **twitter.json** dosyası kullanılmıştır.  
- Veritabanı yerine **dosya tabanlı giriş-çıkış** işlemleri gerçekleştirilmiştir.  

**Kullanıcı Verisi**  
Her kullanıcı aşağıdaki bilgileri içerir:  
- Kullanıcı Adı, Ad-Soyad, Takipçi Sayısı, Takip Edilen Sayısı, Dil, Bölge  
- Paylaşılan tweet içerikleri  
- Takip edilenler ve takipçiler  

**Veri Yapıları ve Algoritmalar**  
- **Hash Tabloları**: Kullanıcı ve ilgi alanı verilerini organize etmek için  
- **Graf Yapıları**: Kullanıcı ilişkilerini düğüm ve kenarlar ile modellemek  
- **Arama Algoritmaları**: Kullanıcı ilgi alanlarını bulmak için  
- **DFS/BFS**: Kullanıcılar arası bağlantıları analiz etmek için  
- **Minimum Spanning Tree (MST)**: Benzer ilgi alanlarına sahip kullanıcıları belirlemek için  
