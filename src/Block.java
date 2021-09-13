import java.util.Date;

public class Block {

	  public String hash; 
	  public String previousHash; 
	  private String data;  //our data will be a simple message.
	  private long timeStamp; //as number of milliseconds since 1/1/1970.
	  private int nonce;

	  // Constructor for the block 
	  public Block(String data, String previousHash) { 
		  this.data = data; 
		  this.previousHash = previousHash; 
		  this.timeStamp = new Date().getTime(); 
		  this.hash = calculateHash(); 
	  } 
	  
	  //Calculate new hash based on blocks contents
		public String calculateHash() {
			String calculatedhash = Crypto.applySha256( 
					previousHash +
					Long.toString(timeStamp) +
					Integer.toString(nonce) + 
					data 
					);
			return calculatedhash;
		}
		
		//Increases nonce value until hash target is reached.
		public void mineBlock(int difficulty) {
			String target = Crypto.getDificultyString(difficulty); //Create a string with difficulty * "0" 
			while(!hash.substring( 0, difficulty).equals(target)) {
				nonce ++;
				hash = calculateHash();
			}
			System.out.println("Block Mined!!! : " + hash);
		}

		@Override
		public String toString() {
			return "Block [hash=" + hash + ", previousHash=" + previousHash + ", data=" + data + ", timeStamp="
					+ timeStamp + ", nonce=" + nonce + "]";
		}
		
}