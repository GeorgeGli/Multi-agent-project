import java.util.Random;


/**
 * @author mamakos
 *
 */
public class Game
{
	private int[][][][] payoff;
	
	private int me = 0;
	private int opponent = 0;
	private int cIter = 0;	  // current iteration
	private int iters = 0;
	private String oppPrevAction = "";	// the previous action of my opponent ("A" or "B")
	private String prevAction = "";
	private int prevOutcome = 0;		// my outcome from the previous iteration
	private int myScore = 0;			// my total outcome
	private String state = "";			// can be "A", "B" or "C"
	private String prevstate = "";
	private int roundAaa = 0, roundAab = 0, roundAba = 0, roundAbb = 0, roundA=0;
	private int roundBaa = 0, roundBab = 0, roundBba = 0, roundBbb = 0, roundB=0;
	private int roundCaa = 0, roundCab = 0, roundCba = 0, roundCbb = 0, roundC=0;
	private int myScoreAaa = 0, myScoreAab = 0, myScoreAba = 0, myScoreAbb = 0;
	private int myScoreBaa = 0, myScoreBab = 0, myScoreBba = 0, myScoreBbb = 0;
	private int myScoreCaa = 0, myScoreCab = 0, myScoreCba = 0, myScoreCbb = 0;
	private int oppActionAA = 0, oppActionAB = 0; 
	private int oppActionBA = 0, oppActionBB = 0; 
	private int oppActionCA = 0, oppActionCB = 0;
	private float pAA = 0, pAB = 0;
	private float pBA = 0, pBB = 0;
	private float pCA = 0, pCB = 0;
	private float MmyScoreAba = 0, MmyScoreAbb = 0, MmyScoreAab = 0, MmyScoreAaa = 0;
	private float MmyScoreBba = 0, MmyScoreBbb = 0, MmyScoreBab = 0, MmyScoreBaa = 0;
	private float MmyScoreCba = 0, MmyScoreCbb = 0, MmyScoreCab = 0, MmyScoreCaa = 0;
	
	public Game()
	{
		payoff = new int[3][2][2][2]; 	// [states][actionsP1][actionsP2][players]
	}
	
	public void setPlayers(int me, int opponent)
	{
		this.me = me;
		this.opponent = opponent;
	}
	
	public void setIters(int iters)
	{
		this.iters = iters;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void incrementIter()
	{
		cIter++;
	}
	
	public int getCiter()
	{
		return cIter;
	}
	
	public void update(int prevOutcome, String oppPrevAction, String state)
	{		
		this.prevOutcome = prevOutcome;
		this.oppPrevAction = oppPrevAction;
		this.prevstate = this.state;
		this.state = state;
		
		myScore += prevOutcome;
	}
	
	public String selectAction()
	{	
		
		
		if (prevstate.contentEquals("A"))
		{
			
			roundA++;
			if (prevAction.contentEquals("A"))
			{
				if (oppPrevAction.contentEquals("A"))
				{
					oppActionAA++;
					
					roundAaa++;
					myScoreAaa += prevOutcome;
					MmyScoreAaa = (float)myScoreAaa/roundAaa;
				}
				else
				{
					
					oppActionAB++;
					
					roundAab++;
					myScoreAab += prevOutcome;
					MmyScoreAab = (float)myScoreAab/roundAab;
					
				}
			}
			else
			{
				if (oppPrevAction.contentEquals("A"))
				{
					
					oppActionAA++;
					
					roundAba++;
					myScoreAba += prevOutcome;
					MmyScoreAba = (float)myScoreAba/roundAba;
					
				}
				else
				{
					
					oppActionAB++;
					
					roundAbb++;
					myScoreAbb += prevOutcome;
					MmyScoreAbb = (float)myScoreAbb/roundAbb;
					
				}
			}
				
		}
		
		
		else if (prevstate.contentEquals("B"))
		{
			
			roundB++;
			if (prevAction.contentEquals("A"))
			{
				if (oppPrevAction.contentEquals("A"))
				{
					oppActionBA++;
					
					roundBaa++;
					myScoreBaa += prevOutcome;
					MmyScoreBaa = (float)myScoreBaa/roundBaa;
				}
				else
				{
					
					oppActionBB++;
					
					roundBab++;
					myScoreBab += prevOutcome;
					MmyScoreBab = (float)myScoreBab/roundBab;
					
				}
			}
			else
			{
				if (oppPrevAction.contentEquals("A"))
				{
					
					oppActionBA++;
					
					roundBba++;
					myScoreBba += prevOutcome;
					MmyScoreBba = (float)myScoreBba/roundBba;
					
				}
				else
				{
					
					oppActionBB++;
					
					roundBbb++;
					myScoreBbb += prevOutcome;
					MmyScoreBbb = (float)myScoreBbb/roundBbb;
					
				}
			}
				
		}
		
		else
		{
			roundC++;
			if (prevAction.contentEquals("A"))
			{
				if (oppPrevAction.contentEquals("A"))
				{
					oppActionCA++;
					
					roundCaa++;
					myScoreCaa += prevOutcome;
					MmyScoreCaa = (float)myScoreCaa/roundCaa;
				}
				else
				{
					
					oppActionCB++;
					
					roundCab++;
					myScoreCab += prevOutcome;
					MmyScoreCab = (float)myScoreCab/roundCab;
					
				}
			}
			else
			{
				if (oppPrevAction.contentEquals("A"))
				{
					
					oppActionCA++;
					
					roundCba++;
					myScoreCba += prevOutcome;
					MmyScoreCba = (float)myScoreCba/roundCba;
					
				}
				else
				{
					
					oppActionCB++;
					
					roundCbb++;
					myScoreCbb += prevOutcome;
					MmyScoreCbb = (float)myScoreCbb/roundCbb;
					
				}
			}
			
		}
		
		
		if (roundA!=0)
		{
			pAA = (oppActionAA*100)/roundA;
			pAB = (oppActionAB*100)/roundA;
		}
		if (roundB!=0)
		{
			pBA = (oppActionBA*100)/roundB;
			pBB = (oppActionBB*100)/roundB;
		}
		if (roundC!=0)
		{
			pCA = (oppActionCA*100)/roundC;
			pCB = (oppActionCB*100)/roundC;
		}
		
		//System.out.println("pCA: "+ pCA + "pCB: "+ pCB + "roundC: " + roundC + "oppActionCA: "+ oppActionCA);
		//System.out.println("ScoreAA: " + MmyScoreAaa + " ScoreAB: " + MmyScoreAab + " ScoreBA: " + MmyScoreAba + " ScoreBB: " + MmyScoreAbb + " roundA: "+roundA);
		//System.out.println("ScoreAA: " + MmyScoreBaa + " ScoreAB: " + MmyScoreBab + " ScoreBA: " + MmyScoreBba + " ScoreBB: " + MmyScoreBbb + " roundB: "+roundB);
		//System.out.println("ScoreAA: " + MmyScoreCaa + " ScoreAB: " + MmyScoreCab + " ScoreBA: " + MmyScoreCba + " ScoreBB: " + MmyScoreCbb + " roundC: "+roundC);
		
		
		if (this.state.contentEquals("A"))
		{
			
			if(roundA<15)
			{
				Random rng = new Random();	
				float rand = rng.nextFloat();
				
				if(rand > 0.5)
				{
					this.prevAction = "B";
					return "B";
				}
				this.prevAction = "A";
				return "A";
			}
			if (pAA > 98)
			{
				if (MmyScoreAaa > MmyScoreAba)
				{
					this.prevAction = "A";
					return "A";
				}
				else
				{
					this.prevAction = "B";
					return "B";
				}
			}
			else if (pAB > 98)
			{
				if (MmyScoreAab > MmyScoreAbb)
				{
					this.prevAction = "A";
					return "A";
				}
				else
				{
					this.prevAction = "B";
					return "B";
				}
			}
			if (MmyScoreAab > MmyScoreAba)
			{
				
				if(MmyScoreAab > MmyScoreAaa)
				{
					System.out.println("A = 1");
					this.prevAction = "A";
					return "A";
				}
				else
				{
					System.out.println("A = 3");
					
					if (MmyScoreAab > MmyScoreAba)
					{
						this.prevAction = "A";
						return "A";
					}
					else
					{
						this.prevAction = "B";
						return "B";
					}
				}
				
			}
			else
			{
				
				if(MmyScoreAba > MmyScoreAaa)
				{
					System.out.println("A = 2");
					this.prevAction = "B";
					return "B";
				}
				else
				{
					System.out.println("A = 3");
					
					if (MmyScoreAab > MmyScoreAba)
					{
						this.prevAction = "A";
						return "A";
					}
					else
					{
						this.prevAction = "B";
						return "B";
					}
				}
				
			}
			
		}
		else if (this.state.contentEquals("B"))
		{
			
			if(roundB<15)
			{
				Random rng = new Random();	
				float rand = rng.nextFloat();
				
				if(rand > 0.5)
				{
					this.prevAction = "B";
					return "B";
				}
				this.prevAction = "A";
				return "A";
			}
			if (pBA > 98)
			{
				if (MmyScoreBaa > MmyScoreBba)
				{
					this.prevAction = "A";
					return "A";
				}
				else
				{
					this.prevAction = "B";
					return "B";
				}
			}
			else if (pBB > 98)
			{
				if (MmyScoreBab > MmyScoreBbb)
				{
					this.prevAction = "A";
					return "A";
				}
				else
				{
					this.prevAction = "B";
					return "B";
				}
			}
			if (MmyScoreBab > MmyScoreBba)
			{
				
				if(MmyScoreBab > MmyScoreBaa)
				{
					System.out.println("B = 1");
					this.prevAction = "A";
					return "A";
				}
				else
				{
					System.out.println("B = 3");
					
					if (MmyScoreBab > MmyScoreBba)
					{
						this.prevAction = "A";
						return "A";
					}
					else
					{
						this.prevAction = "B";
						return "B";
					}
				}
				
			}
			else
			{
				
				if(MmyScoreBba > MmyScoreBaa)
				{
					System.out.println("B = 2");
					this.prevAction = "B";
					return "B";
				}
				else
				{
					System.out.println("B = 3");
					
					if (MmyScoreBab > MmyScoreBba)
					{
						this.prevAction = "A";
						return "A";
					}
					else
					{
						this.prevAction = "B";
						return "B";
					}
				}
				
			}
			
		}
		else
		{
			
			if(roundC<15)
			{
				Random rng = new Random();	
				float rand = rng.nextFloat();
				
				if(rand > 0.5)
				{
					this.prevAction = "B";
					return "B";
				}
				this.prevAction = "A";
				return "A";
			}
			if (pCA > 98)
			{
				if (MmyScoreCaa > MmyScoreCba)
				{
					this.prevAction = "A";
					return "A";
				}
				else
				{
					this.prevAction = "B";
					return "B";
				}
			}
			else if (pCB > 98)
			{
				if (MmyScoreCab > MmyScoreCbb)
				{
					this.prevAction = "A";
					return "A";
				}
				else
				{
					this.prevAction = "B";
					return "B";
				}
			}
			if (MmyScoreCab > MmyScoreCba)
			{
				
				if(MmyScoreCab > MmyScoreCaa)
				{
					System.out.println("C = 1");
					this.prevAction = "A";
					return "A";
				}
				else
				{
					System.out.println("C = 3");
					
					if (MmyScoreCab > MmyScoreCba)
					{
						this.prevAction = "A";
						return "A";
					}
					else
					{
						this.prevAction = "B";
						return "B";
					}
				}
				
			}
			else
			{
				
				if(MmyScoreCba > MmyScoreCaa)
				{
					System.out.println("C = 2");
					this.prevAction = "B";
					return "B";
				}
				else
				{
					System.out.println("C = 3");
					
					if (MmyScoreCab > MmyScoreCba)
					{
						this.prevAction = "A";
						return "A";
					}
					else
					{
						this.prevAction = "B";
						return "B";
					}
				}
				
			}
			
		}
		
	
	}

}
