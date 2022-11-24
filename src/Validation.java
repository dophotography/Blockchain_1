public class Validation {

    public static boolean isValid() {

        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < BlockchainProgram.blockChain.size(); i++) {
            currentBlock = BlockchainProgram.blockChain.get(i);
            previousBlock = BlockchainProgram.blockChain.get(i - 1);

            if (!currentBlock.getBlockHash().equals(currentBlock.calculateHash())){
                return false;
            }

            if (!previousBlock.getBlockHash().equals(currentBlock.getPreviousBlockHash())){
                return false;
            }
        }
        return true;
    }
}
