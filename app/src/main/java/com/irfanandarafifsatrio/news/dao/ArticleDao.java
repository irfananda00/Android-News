package com.irfanandarafifsatrio.news.dao;

import java.util.List;

/**
 * Created by irfanandarafifsatrio on 4/15/17.
 */

public class ArticleDao {

    /**
     * status : ok
     * source : espn
     * sortBy : top
     * articles : [{"author":null,"title":"Follow live: Sharks looking for 2-0 lead in Edmonton","description":"NHL Hockey Gamecast: Final statistics from the San Jose vs. Edmonton game played on April 14, 2017","url":"http://cdn.espn.com/nhl/gamecast?gameId=400950068","urlToImage":null,"publishedAt":null},{"author":null,"title":"McDavid is living up to the moment","description":"Connor McDavid knows previous accolades mean nothing in the playoffs, so he still has plenty to prove. \"He's our unquestioned leader,\" said Oilers goalie Cam Talbot. \"Where he goes, we go.\"","url":"http://www.espn.com/nhl/story/_/id/19133169/nhl-2017-stanley-cup-edmonton-oilers-captain-connor-mcdavid-plenty-prove","urlToImage":"http://a4.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0328%2Fr194456_1296x729_16%2D9.jpg","publishedAt":"2017-04-14T20:18:08Z"},{"author":"Craig CustanceESPN Senior Writer","title":"Jackets have no answer for Pens stars","description":"Columbus matched up well on paper, but a Pittsburgh Penguins offense led by Sidney Crosby, Evgeni Malkin and Phil Kessel is just proving too much for the Blue Jackets to contain.","url":"http://www.espn.com/nhl/story/_/id/19161081/nhl-2017-stanley-cup-no-answer-sidney-crosby","urlToImage":"http://a1.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0414%2Fr199817_2_1296x729_16%2D9.jpg","publishedAt":"2017-04-15T02:28:50Z"},{"author":null,"title":"David Villa scores wonder goal as NYCFC beat the Philadelphia Union","description":"The Union are still winless in 2017 after David Villa and Jack Harrison scored for NYCFC in a 2-0 win.","url":"http://www.espnfc.com/major-league-soccer/story/3103902/david-villa-scores-wonder-goal-as-nycfc-beat-the-philadelphia-union","urlToImage":"http://a.espncdn.com/combiner/i/?img=/photo/2017/0414/r199833_1296x864_3-2.jpg&site=espnfc","publishedAt":null},{"author":null,"title":"ESPN Forecast: Predicting winners for first round of NBA playoffs","description":"Who will advance to the second round of the NBA playoffs? We polled the ESPN Forecast panel of experts.","url":"http://www.espn.com/nba/story/_/id/19157195/2017-nba-playoffs-predicting-winners-round-1","urlToImage":"http://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0326%2Fr194079_1296x729_16%2D9.jpg","publishedAt":"2017-04-14T16:00:00Z"},{"author":"Brian WindhorstESPN Senior Writer","title":"Having fun yet? Cavs hoping to make joyful noise in playoffs","description":"The Cavaliers' regular-season ride was full of all sorts of pitfalls. With that grind over, can Cleveland return to the fun-filled form that propelled them to their first title last season?","url":"http://www.espn.com/nba/story/_/id/19154818/2017-nba-playoffs-cleveland-cavaliers-hoping-make-joyful-noise","urlToImage":"http://a4.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0413%2Fr199631_1296x729_16%2D9.jpg","publishedAt":"2017-04-14T15:53:46Z"},{"author":"Kevin PeltonESPN Staff Writer","title":"Playoffs and lottery will decide where Melo goes next","description":"Kevin Pelton says to watch three playoff teams as potential destinations for Carmelo Anthony.","url":"http://www.espn.com/nba/insider/story/_/id/19160136/playoffs-decide-where-carmelo-anthony-goes-next-kevin-pelton","urlToImage":"http://a2.espncdn.com/combiner/i?img=%2Fphoto%2F2015%2F1104%2Fr22992_1296x729_16%2D9.jpg","publishedAt":"2017-04-14T23:02:58Z"},{"author":"Eddie MatzESPN Senior Writer","title":"Daniel Murphy delivers walk-off as ridiculous run continues for Nats","description":"A 10th-inning double to give the Nationals a win Friday over the Phillies was just the latest feat for Daniel Murphy, who's hit in all 10 games so far.","url":"http://www.espn.com/blog/washington-nationals/post/_/id/2346/daniel-murphy-delivers-walk-off-as-ridiculous-run-continues-for-nationals","urlToImage":"http://a2.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0414%2Fr199836_1296x729_16%2D9.jpg","publishedAt":"2017-04-15T02:38:14Z"},{"author":"Jayson StarkESPN Senior Writer","title":"The night baseball stopped to retire No. 42 forever","description":"Twenty years ago, President Bill Clinton, Jackie Robinson's widow, Rachel, and commissioner Bud Selig walked onto the Shea Stadium grass -- and made a stunning announcement.","url":"http://www.espn.com/mlb/story/_/id/19141070/an-oral-history-night-baseball-retired-jackie-robinson-no-42","urlToImage":"http://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0412%2Fr199206_988x556_16%2D9.jpg","publishedAt":"2017-04-14T17:36:11Z"},{"author":"Scott LauberESPN Staff Writer","title":"Red Sox have the star power to keep Jackie Robinson's legacy alive","description":"Last year, African-Americans comprised just 6.7 percent of MLB's player pool. With Mookie Betts, Jackie Bradley Jr., David Price and Chris Young, Boston could be the epicenter of a renaissance.","url":"http://www.espn.com/mlb/story/_/id/19141100/red-sox-star-power-keep-jackie-robinson-legacy-alive","urlToImage":"http://a1.espncdn.com/combiner/i?img=%2Fphoto%2F2017%2F0412%2Fr199062_1296x729_16%2D9.jpg","publishedAt":"2017-04-14T17:00:12Z"}]
     */

    private String status;
    private String source;
    private String sortBy;
    private List<ArticlesBean> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class ArticlesBean {
        /**
         * author : null
         * title : Follow live: Sharks looking for 2-0 lead in Edmonton
         * description : NHL Hockey Gamecast: Final statistics from the San Jose vs. Edmonton game played on April 14, 2017
         * url : http://cdn.espn.com/nhl/gamecast?gameId=400950068
         * urlToImage : null
         * publishedAt : null
         */

        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }
}
