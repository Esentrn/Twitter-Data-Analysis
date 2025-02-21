package proje3;

import org.json.JSONArray;

public class DFS {
    private HashSet<String> visited;

    public DFS() {
        visited = new HashSet<>();
    }

    public void dfs(Hash kullaniciHashTablosu, String kullaniciAdi, String[] keywords) {
        Stack<String> stack = new Stack<>();
        stack.push(kullaniciAdi);

        while (!stack.isEmpty()) {
            String currentUsername = stack.pop();

            if (!visited.contains(currentUsername)) {
                visited.add(currentUsername);

                Kullanıcı currentKullanici = kullaniciHashTablosu.get(currentUsername);

                // Kullanıcının tweetlerini kontrol etme methodunu çağırdık
                analyzeAndListTweets(currentKullanici, keywords);

               
              for (String follower : currentKullanici.getTakipciler()) {
    if (follower != null) {
        stack.push(follower);
    }
}

            }
        }
    }

  public void analyzeAndListTweets(Kullanıcı kullanici, String[] keywords) {
    if (kullanici != null) {
        if (kullanici.getTweetler() != null) {
            System.out.println("Tweetler for " + kullanici.getKullaniciAdi() + ":");
            for (int i = 0; i < kullanici.getTweetler().length(); i++) {
                if (!kullanici.getTweetler().isNull(i)) {
                    String tweet = kullanici.getTweetler().getString(i);
                    if (containsKeywords(tweet, keywords)) {
                        System.out.println("- " + tweet);
                    }
                }
            }
            System.out.println("--------------");
        } else {
            System.out.println("Tweetler for " + kullanici.getKullaniciAdi() + " bulunamadı.");
        }
    } else {
        System.out.println("Kullanıcı null.");
    }
}



    private boolean containsKeywords(String tweet, String[] keywords) {
        for (String keyword : keywords) {
            if (tweet.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
