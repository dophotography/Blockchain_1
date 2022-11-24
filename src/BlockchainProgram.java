import java.util.ArrayList;

public class BlockchainProgram {

    //series of blocks in a chain
    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static void main(String[] args) {


        //block 1
        String[] duckMadeMe = {"Shade takes 600$", "Miguel gives 900$"};
        Block firstBlock = new Block(duckMadeMe, null);
        blockChain.add(firstBlock);

        //block 2
        String[] shadeGivesMoney = {"Shade gives 200$", "Miguel takes 300$"};
        Block secondBlock = new Block(shadeGivesMoney, firstBlock.getBlockHash());
        blockChain.add(secondBlock);

        //block 3
        String[] shadeTakesMoney = {"Shade takes 600$", "Miguel gives 900$"};
        Block thirdBlock = new Block(shadeTakesMoney, secondBlock.getBlockHash());
        blockChain.add(thirdBlock);

        //validation of the blockchain
        boolean isValid = Validation.isValid();
        if (!isValid) {
            System.out.println(" --> The blockchain doesn't work");
        } else {
            //output
            System.out.println(" --> First block is: " + firstBlock.toString());
            System.out.println(" --> Second block is: " + secondBlock.toString());
            System.out.println(" --> Third block is: " + thirdBlock.toString());
            System.out.println(" --> The blockchain is:" + blockChain.toString());
        }

    }

}