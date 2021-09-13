import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static List<Block> blockchain = new ArrayList<Block>();
	// Miner
	public static int difficulty = 5;
	
	public static void main(String[] args) {
		
		System.out.println("Trying to Mine block 1... ");
		Transfer transfer1 = new Transfer("001", "Sok Chan", "002", "Pech Dara", 20L, "USD");
		addBlock(new Block(transfer1.toString(), "0"));
		
		System.out.println("Trying to Mine block 2... ");
		Transfer transfer2 = new Transfer("002", "Pech Dara", "001", "Sok Chan", 30L, "USD");
		addBlock(new Block(transfer2.toString(),blockchain.get(blockchain.size()-1).hash));
		
		System.out.println("Trying to Mine block 3... ");
		// Test Valid
		Transfer transfer3 = new Transfer("003", "Koe Sopheak", "001", "Sok Chan", 40L, "USD");
		addBlock(new Block(transfer3.toString(),blockchain.get(blockchain.size()-1).hash));	
		
		// Test Invalid
		//addBlock(new Block("Hello, Chivon . I am fine thank and you ?","0"));	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		// Display Block
		for(Block block : blockchain) {
			System.out.println(block.toString());
		}
	}
	
public static Boolean isChainValid() {
		
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			// compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			// compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			// check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
	
	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
}
