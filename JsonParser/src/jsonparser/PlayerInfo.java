package jsonparser;


public class PlayerInfo {
    private String uniqueId;
    private String displayName;
    private String platform;
    private long wins;
    private long goals;
    private long mvps;
    private long saves;
    private long shots;
    private long assists;
    private long sRankPoints;
    private long sTier;
    private long sDiv;
    private long dRankPoints;
    private long dTier;
    private long dDiv;
    private long tRankPoints;
    private long tTier;
    private long tDiv;
    
    public PlayerInfo(String uniqueId, String displayName, String platform, long wins, long goals, long mvps, long saves, long shots, long assists, long sRankPoints, long sTier, long sDiv, long dRankPoints, long dTier, long dDiv, long tRankPoints, long tTier, long tDiv)
    {
        this.uniqueId = uniqueId;
        this.displayName = displayName;
        this.platform = platform;
        this.wins = wins;
        this.goals = goals;
        this.mvps = mvps;
        this.saves = saves;
        this.shots = shots;
        this.assists = assists;
        this.sRankPoints = sRankPoints;
        this.sTier = sTier;
        this.sDiv = sDiv;
        this.dRankPoints = dRankPoints;
        this.dTier = dTier;
        this.dDiv = dDiv;
        this.tRankPoints = tRankPoints;
        this.tTier = tTier;
        this.tDiv = tDiv;
    }
    public String getName(){return displayName;}
    public String getId(){return uniqueId;}
    public String getPlatform(){return platform;}
    public long getWins(){return wins;}
    public long getGoals(){return goals;}
    public long getMvps(){return mvps;}
    public long getSaves(){return saves;}
    public long getShots(){return shots;}
    public long getAssists(){return assists;}
    public long getSRP(){return sRankPoints;}
    public long getST(){return sTier;}
    public long getSD(){return sDiv;}
    public long getDRP(){return dRankPoints;}
    public long getDT(){return dTier;}
    public long getDD(){return dDiv;}
    public long getTRP(){return tRankPoints;}
    public long getTT(){return tTier;}
    public long getTD(){return tDiv;}
    
    
    public String toString()
    {
        return "ID: " + uniqueId + 
                "\nName: " + displayName + 
                "\nPlatform: " + platform + 
                "\nStats:\n     wins: " + wins + 
                "\n     goals: " + goals +
                "\n     mvps: " + mvps +
                "\n     saves: " + saves +
                "\n     shots: " + shots +
                "\n     assists: " + assists +
                "\nSolos:\n     Rank Points: " + sRankPoints + 
                "\n     Tier: " + sTier +
                "\n     Division: " + sDiv +
                "\nDuos:\n     Rank Points:" + dRankPoints +
                "\n     Tier: " + dTier +
                "\n     Division: " + dDiv +
                "\nStandard:\n     Rank Points:" + tRankPoints +
                "\n     Tier: " + tTier +
                "\n     Division: " + tDiv;
                
    }
    

    
}