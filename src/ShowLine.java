/**
 * Created by agodbout on 2018-10-19.
 */
public class ShowLine {

    private int mLineId;

    //who said the line
    private String mCharacter;

    //the line
    private String mLine;

    //the episode
    private int mEpisode;

    //the season
    private int mSeason;



    ShowLine(String character, String line, int episode, int season) {
        mCharacter = character;
        mLine = line;
        mEpisode = episode;
        mSeason = season;
    }

    public int getLineId()  {return mLineId; }

    public String getCharacter() {
        return mCharacter;
    }

    public String getLine() {
        return mLine;
    }

    public int getEpisode() {
        return mEpisode;
    }

    public Integer getSeason() {
        return mSeason;
    }
}

