import java.util.*;

class Program {
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    // Write your code here.
    return getOrgInfo(topManager, reportOne, 
reportTwo).lowestCommonManager;
  }
	
	public static OrgInfo getOrgInfo(OrgChart manager, OrgChart 
reportOne, OrgChart reportTwo){
		int numImportantReports = 0;
		
		for(OrgChart directReport : manager.directReports){
			OrgInfo orgInfo = getOrgInfo(directReport, 
reportOne, reportTwo);
			if( orgInfo.lowestCommonManager != null) return 
orgInfo;
			numImportantReports += 
orgInfo.numImportantReports;
		}
		
		if( manager == reportOne || manager == reportTwo) 
numImportantReports++;
		
		OrgChart lowestCommonManager = numImportantReports == 2 
? manager : null ;
		OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager, 
numImportantReports);
		return newOrgInfo;
		
	}

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
	
	static class OrgInfo{
		public OrgChart lowestCommonManager;
		
		int numImportantReports;
		
		OrgInfo(OrgChart lowestCommonManager, int 
numImportantReports){
			this.lowestCommonManager = lowestCommonManager;
			this.numImportantReports = numImportantReports;
		}
	}
}

